package br.unitins.tp1.placadevideo.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PlacaDeVideoRequestDTO(
        @NotBlank(message = "O campo modelo deve ser informado")
        String modelo,
        @NotBlank(message = "O campo categoria deve ser informado")
        String categoria,
        @NotNull(message = "O campo preço deve ser informado")
        BigDecimal preco,
        @NotBlank(message = "O campo descrição deve ser informado")
        String descricao,
        @NotNull(message = "O campo estoque deve ser informado")
        Integer estoque,
        @NotBlank(message = "O campo tipo de memória deve ser informado")
        String tipoMemoria,
        @NotNull(message = "O campo capacidade de memória deve ser informado")
        Integer capacidadeMemoria,
        @NotNull(message = "O campo quantidade de coolers deve ser informado")
        Integer quantidadeCoolers,
        @NotNull(message = "O campo altura deve ser informado")
        Integer altura,
        @NotNull(message = "O campo largura deve ser informado")
        Integer largura,
        @NotNull(message = "O campo comprimento deve ser informado")
        Integer comprimento,
        @NotBlank(message = "O campo saídas de vídeo deve ser informado")
        String saidasVideo) {

}
