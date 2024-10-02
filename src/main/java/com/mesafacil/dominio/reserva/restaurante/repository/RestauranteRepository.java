package com.mesafacil.dominio.reserva.restaurante.repository;

import com.mesafacil.dominio.reserva.restaurante.enumeration.TipoDeCulinaria;
import com.mesafacil.dominio.reserva.restaurante.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    @Query("SELECT R FROM Restaurante  R JOIN R.tiposDeCulinaria T WHERE T = :tipoDeCulinaria")
    List<Restaurante> findByTiposDeCulinaria(@Param("tipoDeCulinaria") TipoDeCulinaria tipoDeCulinaria);
}
