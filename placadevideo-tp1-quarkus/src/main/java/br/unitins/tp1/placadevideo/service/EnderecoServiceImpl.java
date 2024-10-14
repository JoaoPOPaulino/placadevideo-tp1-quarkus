package br.unitins.tp1.placadevideo.service;

import java.util.List;

import br.unitins.tp1.placadevideo.dto.EnderecoRequestDTO;
import br.unitins.tp1.placadevideo.model.Cliente;
import br.unitins.tp1.placadevideo.model.Endereco;
import br.unitins.tp1.placadevideo.repository.EnderecoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {
    
    @Inject
    public EnderecoRepository enderecoRepository;
    
    @Override
    public Endereco findById(Long id) {
        return enderecoRepository.findById(id);
    }
   
    @Override
    public List<Endereco> findByCliente(Long idCliente) {
        return enderecoRepository.findByCliente(idCliente);
    }
    
    @Override
    public List<Endereco> findAll() {
        return enderecoRepository.findAll().list();
    }

    @Override
    @Transactional
    public Endereco create(EnderecoRequestDTO dto, Cliente cliente) {
        Endereco endereco = new Endereco();
        endereco.setCep(dto.cep());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());
        endereco.setBairro(dto.bairro());
        endereco.setNumero(dto.numero());
        endereco.setCliente(cliente);

        enderecoRepository.persist(endereco);
        return endereco;
    }

    @Override
    @Transactional
    public Endereco update(Long id, EnderecoRequestDTO dto) {
        Endereco endereco = enderecoRepository.findById(id);
        endereco.setCep(dto.cep());
        endereco.setCidade(dto.cidade());
        endereco.setEstado(dto.estado());
        endereco.setBairro(dto.bairro());
        endereco.setNumero(dto.numero());
        endereco.setCliente(null);
        return endereco;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        enderecoRepository.deleteById(id);
    }


}
