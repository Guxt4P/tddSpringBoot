package com.faculdade.tdd_desconto.service;

import com.faculdade.tdd_desconto.model.Pedido;
import com.faculdade.tdd_desconto.repository.PedidoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private PedidoService service;

    @Test
    @DisplayName("Deve aplicar 10% de desconto para compras acima de R$ 100")
    void deveAplicarDescontoParaComprasAcimaDeCem() {

        // ARRANGE
        Pedido pedidoOriginal = new Pedido(1L, 200.0);

        when(repository.buscarPorId(1L))
                .thenReturn(Optional.of(pedidoOriginal));
                //"Quando o Service pedir o pedido 1 ao repositório, finja que encontrou e me devolva este pedido fictício."

        when(repository.salvar(any(Pedido.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // ACT
        Pedido pedidoComDesconto =
                service.calcularEAplicarDesconto(1L);

        // ASSERT
        assertEquals(
                180.0,
                pedidoComDesconto.getValorTotal(),
                0.001
        );

        verify(repository, times(1))
                .salvar(any(Pedido.class));
    }
}


// A classe pedidoService esta vermelho pois ainda nao criamos ela 
// Pois fazer ela com menos codigo
// RED