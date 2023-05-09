package com.nuuptech.load.repository;

import com.nuuptech.load.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
    // métodos personalizados de consulta si es necesario
}
