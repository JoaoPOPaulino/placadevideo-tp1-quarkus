package br.unitins.tp1.placadevideo.service.pedido;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.annotations.servers.Server;

import br.unitins.tp1.placadevideo.dto.request.ItemPedidoRequestDTO;
import br.unitins.tp1.placadevideo.dto.request.PedidoRequestDTO;
import br.unitins.tp1.placadevideo.model.pedido.ItemPedido;
import br.unitins.tp1.placadevideo.model.pedido.Pedido;
import br.unitins.tp1.placadevideo.model.pedido.StatusPedido;
import br.unitins.tp1.placadevideo.model.usuario.Cliente;
import br.unitins.tp1.placadevideo.repository.pedido.PedidoRepository;
import br.unitins.tp1.placadevideo.service.cliente.ClienteService;
import br.unitins.tp1.placadevideo.service.placadevideo.PlacaDeVideoService;
import br.unitins.tp1.placadevideo.validation.ValidationException;

@Server
public class PedidoServiceImpl {

    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;
    private final PlacaDeVideoService placaDeVideoService;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, ClienteService clienteService, PlacaDeVideoService placaDeVideoService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
        this.placaDeVideoService = placaDeVideoService;
    }

    @Transactional
    public Pedido realizarPedido(PedidoRequestDTO pedidoDTO) {
        Cliente cliente = clienteService.findById(pedidoDTO.idUsuario());
        if (cliente == null) {
            throw new ValidationException("idUsuario", "Cliente não encontrado.");
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setData(LocalDateTime.now());
        pedido.setStatus(StatusPedido.AGUARDANDO_PAGAMENTO);

        List<ItemPedido> itens = adicionarItens(pedidoDTO.itens(), pedido);
        if (itens.isEmpty()) {
            throw new ValidationException("itens", "O pedido deve conter pelo menos um item válido.");
        }

        pedido.setItens(itens);
        pedido.setValorTotal(calcularTotalPedido(itens));
        return pedidoRepository.save(pedido);
    }

    private List<ItemPedido> adicionarItens(List<ItemPedidoRequestDTO> itensDTO, Pedido pedido) {
        return itensDTO.stream().map(itemDTO -> {
            var placaDeVideo = placaDeVideoService.findById(itemDTO.idProduto());
            if (placaDeVideo == null) {
                throw new ValidationException("idProduto", "Produto não encontrado.");
            }

            if (placaDeVideo.getEstoque() < itemDTO.quantidade()) {
                throw new ValidationException("quantidade", "Estoque insuficiente para o produto: " + placaDeVideo.getModelo());
            }

            var itemPedido = new ItemPedido();
            itemPedido.setPedido(pedido);
            itemPedido.setPlacaDeVideo(placaDeVideo);
            itemPedido.setQuantidade(itemDTO.quantidade());
            itemPedido.setPreco(placaDeVideo.getPreco().multiply(BigDecimal.valueOf(itemDTO.quantidade())));

            placaDeVideo.setEstoque(placaDeVideo.getEstoque() - itemDTO.quantidade());
            placaDeVideoService.update(placaDeVideo);

            return itemPedido;
        }).collect(Collectors.toList());
    }

    private BigDecimal calcularTotalPedido(List<ItemPedido> itens) {
        return itens.stream()
                .map(ItemPedido::getPreco)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public Pedido atualizarStatus(Long id, StatusPedido status) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ValidationException("idPedido", "Pedido não encontrado."));

        pedido.setStatus(status);
        return pedidoRepository.save(pedido);
    }
}
