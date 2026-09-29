package com.faculdade.tdd_desconto.repository;

import com.faculdade.tdd_desconto.model.Pedido;
import java.util.Optional;

public interface PedidoRepository {
    Optional<Pedido> buscarPorId(Long id);
    Pedido salvar(Pedido pedido);
};

// Optional é uma classe usada
// para evitar erros do tipo NullPointerException

/*PedidoRepository (Interface):
Defines o contrato de persistência (quais métodos existem, como buscarPorId e salvar).
Permite que o PedidoService dependa de uma abstração.*/
