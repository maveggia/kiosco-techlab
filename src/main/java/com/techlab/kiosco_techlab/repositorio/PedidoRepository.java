package com.techlab.kiosco_techlab.repositorio;

import com.techlab.kiosco_techlab.modelo.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}