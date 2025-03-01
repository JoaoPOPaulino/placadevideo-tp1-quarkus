package br.unitins.tp1.placadevideo.dto.response;

import java.time.LocalDateTime;

import br.unitins.tp1.placadevideo.model.pedido.StatusPedido;
import br.unitins.tp1.placadevideo.model.pedido.UpdateStatusPedido;

public record UpdateStatusPedidoResponseDTO( // Corrigido nome da classe
        StatusPedido status,
        LocalDateTime dataAtualizacao) {

    public static UpdateStatusPedidoResponseDTO valueOf(UpdateStatusPedido updateStatus) { // Ajustado nome do parâmetro
        return new UpdateStatusPedidoResponseDTO(
                updateStatus.getStatus(),
                updateStatus.getDataAtualizacao()
        );
    }
}
