package br.unitins.tp1.placadevideo.repository;

import java.util.List;

import br.unitins.tp1.placadevideo.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
    
    public List<Cliente> findByNome(String nome ){
        return find("SELECT cliente FROM Cliente cliente Where cliente.nome LIKE ?1", "%"+ nome + "%").list();
    }

}
