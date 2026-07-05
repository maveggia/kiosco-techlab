package com.techlab.kiosco_techlab.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "lineas_pedido")
public class LineaPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cantidad;
    private double subtotal;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    public LineaPedido() {}

    public Long getId() { return id; }
    public int getCantidad() { return cantidad; }
    public double getSubtotal() { return subtotal; }
    public Producto getProducto() { return producto; }

    public void setId(Long id) { this.id = id; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public void setProducto(Producto producto) { this.producto = producto; }
}