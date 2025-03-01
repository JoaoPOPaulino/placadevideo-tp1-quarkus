package br.unitins.tp1.placadevideo.model.pedido;

import java.math.BigDecimal;

import br.unitins.tp1.placadevideo.model.DefaultEntity;
import br.unitins.tp1.placadevideo.model.placadevideo.PlacaDeVideo;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ItemPedido extends DefaultEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_placa_de_video", nullable = false)
    private PlacaDeVideo placaDeVideo;

    private Integer quantidade;
    private BigDecimal preco;

    public PlacaDeVideo getPlacaDeVideo() {
        return placaDeVideo;
    }

    public void setPlacaDeVideo(PlacaDeVideo placaDeVideo) {
        this.placaDeVideo = placaDeVideo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
