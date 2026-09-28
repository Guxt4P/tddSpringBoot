package com.faculdade.tdd_desconto.service;

import com.faculdade.tdd_desconto.model.Pedido;
import com.faculdade.tdd_desconto.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    // Constantes explícitas em vez de números soltos no código
    private static final double LIMITE_MINIMO_DESCONTO = 100.0;
    private static final double PERCENTUAL_DESCONTO = 0.10; // 10%

    @Autowired
    private PedidoRepository repository;

    public Pedido calcularEAplicarDesconto(Long id) {
        Pedido pedido = buscarPedidoOuLancarExcecao(id);

        if (isElegivelParaDesconto(pedido)) {
            aplicarDesconto(pedido);
        }

        return repository.salvar(pedido);
    }

    // Métodos privados com responsabilidade única (Refatoração)
    private Pedido buscarPedidoOuLancarExcecao(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));
    }

    private boolean isElegivelParaDesconto(Pedido pedido) {
        return pedido.getValorTotal() > LIMITE_MINIMO_DESCONTO;
    }

    private void aplicarDesconto(Pedido pedido) {
        double valorComDesconto = pedido.getValorTotal() * (1 - PERCENTUAL_DESCONTO);
        pedido.setValorTotal(valorComDesconto);
    }
}

//Refactor