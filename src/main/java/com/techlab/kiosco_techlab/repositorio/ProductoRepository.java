package com.techlab.kiosco_techlab.repositorio;

import com.techlab.kiosco_techlab.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}