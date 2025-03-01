package br.unitins.tp1.placadevideo.dto.request;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PedidoRequestDTO(
        @NotNull(message = "A lista de itens não pode ser nula.")
        @Valid
        List<ItemPedidoRequestDTO> itens,
        @NotNull(message = "O campo idUsuario deve ser informado.")
        @Positive(message = "O idUsuario deve ser um número positivo.")
        Long idUsuario) {

}
