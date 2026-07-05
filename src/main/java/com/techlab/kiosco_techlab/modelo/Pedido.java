package com.techlab.kiosco_techlab.modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    private double total;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedido_id")
    private List<LineaPedido> lineas = new ArrayList<>();

    public Pedido() { this.estado = "pendiente"; }

    public Long getId() { return id; }
    public String getEstado() { return estado; }
    public double getTotal() { return total; }
    public List<LineaPedido> getLineas() { return lineas; }

    public void setId(Long id) { this.id = id; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setTotal(double total) { this.total = total; }
    public void setLineas(List<LineaPedido> lineas) { this.lineas = lineas; }
}