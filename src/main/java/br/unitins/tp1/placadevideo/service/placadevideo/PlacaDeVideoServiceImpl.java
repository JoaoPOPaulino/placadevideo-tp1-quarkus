package br.unitins.tp1.placadevideo.service.placadevideo;

import java.util.List;

import br.unitins.tp1.placadevideo.dto.request.PlacaDeVideoRequestDTO;
import br.unitins.tp1.placadevideo.model.placadevideo.PlacaDeVideo;
import br.unitins.tp1.placadevideo.repository.placadevideo.PlacaDeVideoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PlacaDeVideoServiceImpl implements PlacaDeVideoService {

    @Inject
    private PlacaDeVideoRepository placaDeVideoRepository;

    @Override
    public PlacaDeVideo findById(Long id) {
        return placaDeVideoRepository.findByIdOptional(id)
                .orElseThrow(() -> new EntityNotFoundException("Placa de Vídeo não encontrada."));
    }

    @Override
    public PlacaDeVideo findByDescricao(String descricao) {
        return placaDeVideoRepository.findByDescricao(descricao);
    }

    @Override
    public List<PlacaDeVideo> findByModelo(String modelo) {
        return placaDeVideoRepository.findByModelo(modelo);
    }

    @Override
    public List<PlacaDeVideo> findAll() {
        return placaDeVideoRepository.listAll();
    }

    @Override
    @Transactional
    public PlacaDeVideo create(@Valid PlacaDeVideoRequestDTO dto) {
        PlacaDeVideo placaDeVideo = new PlacaDeVideo();
        updateEntityFromDTO(placaDeVideo, dto);
        placaDeVideoRepository.persist(placaDeVideo);
        return placaDeVideo;
    }

    @Override
    @Transactional
    public PlacaDeVideo update(Long id, @Valid PlacaDeVideoRequestDTO dto) {
        PlacaDeVideo placaDeVideo = findById(id);
        updateEntityFromDTO(placaDeVideo, dto);
        return placaDeVideo;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!placaDeVideoRepository.deleteById(id)) {
            throw new EntityNotFoundException("Placa de Vídeo não encontrada para exclusão.");
        }
    }

    private void updateEntityFromDTO(PlacaDeVideo placaDeVideo, PlacaDeVideoRequestDTO dto) {
        placaDeVideo.setModelo(dto.modelo());
        placaDeVideo.setCategoria(dto.categoria());
        placaDeVideo.setPreco(dto.preco());
        placaDeVideo.setDescricao(dto.descricao());
        placaDeVideo.setEstoque(dto.estoque());

        placaDeVideo.setTipoMemoria(dto.tipoMemoria());
        placaDeVideo.setCapacidadeMemoria(dto.capacidadeMemoria());
        placaDeVideo.setQuantidadeCoolers(dto.quantidadeCoolers());

        placaDeVideo.setAltura(dto.altura());
        placaDeVideo.setLargura(dto.largura());
        placaDeVideo.setComprimento(dto.comprimento());

        placaDeVideo.setSaidasVideo(dto.saidasVideo());
    }

    @Override
    public PlacaDeVideo updateNomeImagem(Long id, String nomeImagem) {
        throw new UnsupportedOperationException("Unimplemented method 'updateNomeImagem'");
    }
}
