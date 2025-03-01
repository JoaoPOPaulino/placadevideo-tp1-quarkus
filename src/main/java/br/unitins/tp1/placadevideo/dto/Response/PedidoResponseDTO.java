package br.unitins.tp1.placadevideo.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.tp1.placadevideo.model.pedido.Pedido;

public record PedidoResponseDTO(
        Long id,
        LocalDateTime data,
        BigDecimal valorTotal,
        String status,
        List<ItemPedidoResponseDTO> itens) {

    public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getData(),
                pedido.getValorTotal(),
                (pedido.getStatus() != null && !pedido.getStatus().isEmpty())
                ? pedido.getStatus().get(pedido.getStatus().size() - 1).getStatus().name()
                : "N/A",
                pedido.getItens().stream()
                        .map(ItemPedidoResponseDTO::valueOf)
                        .collect(Collectors.toList())
        );
    }
}
