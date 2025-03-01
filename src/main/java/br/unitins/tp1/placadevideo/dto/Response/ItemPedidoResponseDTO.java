package br.unitins.tp1.placadevideo.dto.response;

import java.math.BigDecimal;

import br.unitins.tp1.placadevideo.model.pedido.ItemPedido;

public record ItemPedidoResponseDTO(
        Long idProduto,
        Integer quantidade,
        BigDecimal precoUnitario) {

    public static ItemPedidoResponseDTO valueOf(ItemPedido item) {
        return new ItemPedidoResponseDTO(
                item.getPlacaDeVideo().getId(),
                item.getQuantidade(),
                item.getPreco()
        );
    }
}
