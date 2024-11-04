package br.unitins.tp1.placadevideo.service.pedido;

import java.util.List;

import br.unitins.tp1.placadevideo.dto.PedidoRequestDTO;
import br.unitins.tp1.placadevideo.model.Pedido;

public interface PedidoService {

    Pedido findById(Long id);

    List<Pedido> findByUsername(String username);

    Pedido create(PedidoRequestDTO dto);

    void cancelarPedido(Long id);

    


}
