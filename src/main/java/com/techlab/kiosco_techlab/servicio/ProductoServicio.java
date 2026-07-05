package com.techlab.kiosco_techlab.servicio;

import com.techlab.kiosco_techlab.excepciones.StockInsuficienteException;
import com.techlab.kiosco_techlab.modelo.Producto;
import com.techlab.kiosco_techlab.repositorio.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto actualizar(Long id, Producto datos) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombre(datos.getNombre());
        producto.setDescripcion(datos.getDescripcion());
        producto.setPrecio(datos.getPrecio());
        producto.setCategoria(datos.getCategoria());
        producto.setImagen(datos.getImagen());
        producto.setStock(datos.getStock());
        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

    public void validarStock(Producto producto, int cantidad) {
        if (cantidad > producto.getStock()) {
            throw new StockInsuficienteException("Stock insuficiente para " + producto.getNombre());
        }
    }
}