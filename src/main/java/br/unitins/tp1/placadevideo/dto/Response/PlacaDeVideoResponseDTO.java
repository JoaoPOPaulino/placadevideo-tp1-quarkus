package br.unitins.tp1.placadevideo.dto.response;

import java.math.BigDecimal;

import br.unitins.tp1.placadevideo.model.placadevideo.PlacaDeVideo;

public record PlacaDeVideoResponseDTO(
        Long id,
        String modelo,
        String categoria,
        BigDecimal preco,
        String descricao,
        Integer estoque,
        String tipoMemoria,
        Integer capacidadeMemoria,
        Integer quantidadeCoolers,
        Integer altura,
        Integer largura,
        Integer comprimento,
        String saidasVideo) {

    public static PlacaDeVideoResponseDTO valueOf(PlacaDeVideo placaDeVideo) {
        return new PlacaDeVideoResponseDTO(
                placaDeVideo.getId(),
                placaDeVideo.getModelo(),
                placaDeVideo.getCategoria(),
                placaDeVideo.getPreco(),
                placaDeVideo.getDescricao(),
                placaDeVideo.getEstoque(),
                placaDeVideo.getTipoMemoria(),
                placaDeVideo.getCapacidadeMemoria(),
                placaDeVideo.getQuantidadeCoolers(),
                placaDeVideo.getAltura(),
                placaDeVideo.getLargura(),
                placaDeVideo.getComprimento(),
                placaDeVideo.getSaidasVideo());
    }
}
