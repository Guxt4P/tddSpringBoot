package com.faculdade.tdd_desconto.repository;

import com.faculdade.tdd_desconto.model.Pedido;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    private final Map<Long, Pedido> pedidos = new ConcurrentHashMap<>();

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return Optional.ofNullable(pedidos.get(id));
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
        return pedido;  }
}

/*PedidoRepositoryImpl (Implementação Concreta em Memória):
Classe concreta anotada com @Repository que armazena os dados 
em um ConcurrentHashMap.
Papel no Spring Boot: Fornece o Bean que o Spring precisa injetar via @Autowired no PedidoService para subir o contexto da aplicação (SpringBootTest) sem erros.
 */
