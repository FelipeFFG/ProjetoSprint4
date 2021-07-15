package com.example.projetosprint4.repository;

import com.example.projetosprint4.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
