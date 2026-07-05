package com.techlab.kiosco_techlab.servicio;

import com.techlab.kiosco_techlab.modelo.LineaPedido;
import com.techlab.kiosco_techlab.modelo.Pedido;
import com.techlab.kiosco_techlab.modelo.Producto;
import com.techlab.kiosco_techlab.repositorio.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicio {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoServicio productoServicio;

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido crear(Pedido pedido) {
        double total = 0;
        for (LineaPedido linea : pedido.getLineas()) {
            Producto producto = productoServicio.buscarPorId(linea.getProducto().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            productoServicio.validarStock(producto, linea.getCantidad());
            linea.setProducto(producto);
            linea.setSubtotal(producto.getPrecio() * linea.getCantidad());
            producto.setStock(producto.getStock() - linea.getCantidad());
            productoServicio.guardar(producto);
            total += linea.getSubtotal();
        }
        pedido.setTotal(total);
        return pedidoRepository.save(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
}