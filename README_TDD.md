# TDD no projeto tdd-desconto

Este projeto foi desenvolvido para praticar Test-Driven Development (TDD) em uma aplicação Spring Boot simples, com foco no cálculo de desconto de pedidos.

## 1. Conceito de TDD

TDD é uma metodologia em que os testes são escritos antes da implementação funcional.

O fluxo normalmente é:

1. Escrever um teste que descreve o comportamento esperado.
2. Rodar o teste e confirmar que ele falha.
3. Implementar o código mínimo necessário para passar.
4. Rodar os testes novamente.
5. Refatorar o código sem mudar o comportamento.

Esse ciclo é conhecido como:

- Red
- Green
- Refactor

Ou seja:

- Red: o teste falha.
- Green: o código passa no teste.
- Refactor: o código é melhorado sem quebrar o comportamento.

---

## 2. Estrutura do projeto

Neste projeto, temos os principais elementos:

### Pedido

Classe de domínio que representa um pedido.

Arquivo:
- src/main/java/com/faculdade/tdd_desconto/model/Pedido.java

Ela possui:
- id
- valorTotal
- getters e setters

---

### PedidoRepository

Interface que define o contrato do repositório.

Arquivo:
- src/main/java/com/faculdade/tdd_desconto/repository/PedidoRepository.java

Ela define os métodos que qualquer implementação de persistência deve oferecer, como:

- buscarPorId(Long id)
- salvar(Pedido pedido)

Essa interface serve para desacoplar o serviço da implementação concreta. O `PedidoService` depende da abstração, não de uma classe específica.

Em outras palavras:

- `PedidoRepository` = contrato
- o serviço só conhece a interface

---

### PedidoRepositoryImpl

Implementação concreta da interface `PedidoRepository`.

Arquivo:
- src/main/java/com/faculdade/tdd_desconto/repository/PedidoRepositoryImpl.java

Ela foi criada para fornecer uma implementação funcional com armazenamento em memória usando `Map`.

Funções:

- buscarPorId(Long id): retorna um pedido salvo em memória
- salvar(Pedido pedido): salva ou atualiza um pedido

Essa classe é marcada com `@Repository`, então o Spring consegue gerenciar o bean e injetá-la no serviço.

---

### PedidoService

Classe de serviço responsável pela regra de negócio.

Arquivo:
- src/main/java/com/faculdade/tdd_desconto/service/PedidoService.java

A responsabilidade principal do serviço é:

- buscar o pedido pelo id
- verificar se o valor total é maior que 100
- aplicar desconto de 10%
- salvar o pedido atualizado

A lógica principal está aqui:

```java
if (isElegivelParaDesconto(pedido)) {
    aplicarDesconto(pedido);
}
```

O método `calcularEAplicarDesconto(Long id)` usa a dependência do repositório por meio de injeção.

---

### PedidoServicegreen

Arquivo:
- src/main/java/com/faculdade/tdd_desconto/service/PedidoServicegreen.java

Essa classe representa a implementação verde, ou seja, a etapa em que a funcionalidade já foi escrita para fazer o teste passar.

Ela segue um fluxo simples:

1. busca o pedido
2. verifica se o valor é maior que 100
3. aplica o desconto de 10%
4. salva o pedido

A lógica é semelhante ao serviço principal, mas mostra claramente a ideia de "green" no ciclo TDD: a funcionalidade já funcionando após a implementação.

---

### PedidoServiceTest

Arquivo:
- src/test/java/com/faculdade/tdd_desconto/service/PedidoServiceTest.java

Este é o teste principal do TDD neste projeto.

Ele usa Mockito para simular o repositório e verificar o comportamento do serviço sem depender de banco real.

O teste chamado:

```java
void deveAplicarDescontoParaComprasAcimaDeCem()
```

descreve o comportamento esperado:

> Deve aplicar 10% de desconto para compras acima de R$ 100

O cenário do teste:

- cria um pedido com valor 200.0
- simula que o repositório retorna esse pedido
- chama `calcularEAplicarDesconto(1L)`
- valida que o valor final ficou 180.0

A asserção principal é:

```java
assertEquals(180.0, pedidoComDesconto.getValorTotal(), 0.001);
```

Esse teste valida que 200 * 0.90 = 180.

---

## 3. Fluxo de TDD aplicado no projeto

### Red

Primeiro, o teste é escrito para descrever a regra de negócio:

- se o valor total for maior que 100, aplicar desconto de 10%

O teste é executado e deveria falhar se a lógica ainda não existir.

### Green

A implementação do serviço é criada para atender ao teste.

O código é evoluído até que o teste passe.

### Refactor

Depois que o teste passou, o código pode ser melhorado e organizado:

- extração de métodos privados
- constantes para valores fixos
- nomes mais claros
- melhor legibilidade

---

## 4. Importância do PedidoRepository no TDD

O `PedidoRepository` é essencial porque o serviço precisa acessar os dados, mas a regra de negócio não deve ficar acoplada à implementação da persistência.

No TDD, isso facilita porque:

- o teste pode mockar o repositório
- a lógica do serviço pode ser testada isoladamente
- não é necessário banco real para validar o comportamento principal

Essa separação deixa o teste mais rápido, mais confiável e mais focado na regra de negócio.

---

## 5. Exemplo de responsabilidade por camada

- `Pedido` representa o domínio
- `PedidoRepository` define como o domínio é acessado
- `PedidoRepositoryImpl` implementa o acesso em memória
- `PedidoService` implementa a regra de negócio
- `PedidoServiceTest` valida a regra com TDD

Isso mostra bem a separação de responsabilidades, que é um conceito importante em desenvolvimento orientado a testes.

---

## 6. Conclusão

Este projeto demonstra muito bem o ciclo de TDD:

- o teste define o comportamento esperado
- a implementação faz o comportamento acontecer
- o repositório separa a persistência da regra de negócio
- o serviço comunica a lógica com o armazenamento

O uso combinado de:

- `PedidoRepository`
- `PedidoRepositoryImpl`
- `PedidoService`
- `PedidoServicegreen`
- `PedidoServiceTest`

mostra a evolução natural do TDD em um projeto real: escrever teste, fazer funcionar, refatorar e manter a qualidade.

---

## 7. Comando para executar os testes

No diretório do projeto, pode-se usar:

```powershell
./mvnw test
```

ou, para testar uma classe específica:

```powershell
./mvnw test -Dtest=PedidoServiceTest
```

Esse comando confirma se a regra de desconto está funcionando conforme o TDD definido.
