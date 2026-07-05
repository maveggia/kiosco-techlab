package com.techlab.kiosco_techlab.controlador;

import com.techlab.kiosco_techlab.modelo.Pedido;
import com.techlab.kiosco_techlab.repositorio.PedidoRepository;
import com.techlab.kiosco_techlab.servicio.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoControlador {

    @Autowired
    private PedidoServicio pedidoServicio;

    @Autowired
    private PedidoRepository pedidoRepositorio;

    @GetMapping
    public List<Pedido> listar() {
        return pedidoServicio.listar();
    }

    @PostMapping
    public Pedido crear(@RequestBody Pedido pedido) {
        return pedidoServicio.crear(pedido);
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoServicio.buscarPorId(id);
    }

    @PutMapping("/{id}/estado")
    public Pedido actualizarEstado(@PathVariable Long id, @RequestBody String estado) {
        Pedido pedido = pedidoServicio.buscarPorId(id);
        pedido.setEstado(estado.replace("\"", ""));
        return pedidoRepositorio.save(pedido);
    }
}