package com.faculdade.tdd_desconto.model;

public class Pedido {
    private Long id;
    private Double valorTotal;

    public Pedido(Long id, Double valorTotal) {
        this.id = id;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

}