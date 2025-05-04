package com.example.proyecto_final.Service;

import com.example.proyecto_final.Model.Pedido;
import com.example.proyecto_final.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> getPedidoById(Integer id) {
        return pedidoRepository.findById(id);
    }

    public Pedido createPedido(Pedido pedido) {
        pedido.setFechaPedido(LocalDateTime.now());
        return pedidoRepository.save(pedido);
    }

    public Optional<Pedido> updatePedido(Integer id, Pedido pedidoDetails) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setUsuario(pedidoDetails.getUsuario());
            pedido.setTotal(pedidoDetails.getTotal());
            pedido.setEstado(pedidoDetails.getEstado());
            pedido.setDireccionEnvio(pedidoDetails.getDireccionEnvio());
            pedido.setMetodoPago(pedidoDetails.getMetodoPago());
            return pedidoRepository.save(pedido);
        });
    }
    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    public boolean existsById(Integer id) {
        return pedidoRepository.existsById(id);
    }

    public boolean deletePedido(Integer id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
