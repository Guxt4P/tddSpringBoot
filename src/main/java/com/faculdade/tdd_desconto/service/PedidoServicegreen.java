package com.faculdade.tdd_desconto.service;

import com.faculdade.tdd_desconto.model.Pedido;
import com.faculdade.tdd_desconto.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class PedidoServicegreen {

    @Autowired 
    private PedidoRepository repository;

    public Pedido calcularEAplicarDesconto(Long id) {
        Pedido pedido = repository.buscarPorId(id)
            .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

            if (pedido.getValorTotal() > 100.00){
                double novoValor = pedido.getValorTotal() * 0.90;
                pedido.setValorTotal(novoValor);
            }

            return repository.salvar(pedido);


    }
    
}


//Green