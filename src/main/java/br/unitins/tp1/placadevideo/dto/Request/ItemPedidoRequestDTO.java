package br.unitins.tp1.placadevideo.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ItemPedidoRequestDTO(
        @NotNull(message = "O campo idProduto deve ser informado.")
        @Positive(message = "O idProduto deve ser um número positivo.")
        Long idProduto,
        @NotNull(message = "O campo quantidade deve ser informado.")
        @Positive(message = "A quantidade deve ser um número positivo.")
        Integer quantidade) {

}
