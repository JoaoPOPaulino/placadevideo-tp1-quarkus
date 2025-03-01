package br.unitins.tp1.placadevideo.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.tp1.placadevideo.model.pedido.Pedido;

public record PedidoGeralResponseDTO(
        Long id,
        LocalDateTime data,
        BigDecimal valorTotal,
        List<UpdateStatusPedidoResponseDTO> statusPedido) {

    public static PedidoGeralResponseDTO valueOf(Pedido pedido) {
        return new PedidoGeralResponseDTO(
                pedido.getId(),
                pedido.getData(),
                pedido.getValorTotal(),
                pedido.getStatus().stream()
                        .map(UpdateStatusPedidoResponseDTO::valueOf)
                        .collect(Collectors.toList())
        );
    }
}
