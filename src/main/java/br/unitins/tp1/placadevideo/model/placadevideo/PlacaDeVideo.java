package br.unitins.tp1.placadevideo.model.placadevideo;

import java.math.BigDecimal;

import br.unitins.tp1.placadevideo.model.DefaultEntity;
import jakarta.persistence.Entity;

@Entity
public class PlacaDeVideo extends DefaultEntity {

    private String modelo;
    private String categoria;
    private BigDecimal preco;
    private String descricao;
    private Integer estoque;

    // Especificações técnicas
    private String tipoMemoria;
    private Integer capacidadeMemoria; // GB
    private Integer quantidadeCoolers;

    // Dimensões
    private Integer altura;
    private Integer largura;
    private Integer comprimento;

    // Conectores de saída de vídeo
    private String saidasVideo;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public String getTipoMemoria() {
        return tipoMemoria;
    }

    public void setTipoMemoria(String tipoMemoria) {
        this.tipoMemoria = tipoMemoria;
    }

    public Integer getCapacidadeMemoria() {
        return capacidadeMemoria;
    }

    public void setCapacidadeMemoria(Integer capacidadeMemoria) {
        this.capacidadeMemoria = capacidadeMemoria;
    }

    public Integer getQuantidadeCoolers() {
        return quantidadeCoolers;
    }

    public void setQuantidadeCoolers(Integer quantidadeCoolers) {
        this.quantidadeCoolers = quantidadeCoolers;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public Integer getComprimento() {
        return comprimento;
    }

    public void setComprimento(Integer comprimento) {
        this.comprimento = comprimento;
    }

    public String getSaidasVideo() {
        return saidasVideo;
    }

    public void setSaidasVideo(String saidasVideo) {
        this.saidasVideo = saidasVideo;
    }
}
