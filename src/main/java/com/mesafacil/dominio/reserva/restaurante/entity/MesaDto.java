package com.mesafacil.dominio.reserva.restaurante.entity;

import com.mesafacil.dominio.reserva.restaurante.enumeration.DisponibilidadeMesa;
import com.mesafacil.dominio.reserva.restaurante.model.Restaurante;
import jakarta.validation.constraints.NotNull;

public record MesaDto(


        Long idMesa,

        @NotNull
        Restaurante restaurante,

        @NotNull
        int numeroMesa,

        @NotNull
        DisponibilidadeMesa descricao
) {
//        public boolean isDisponivel(){
//                return descricao == DisponibilidadeMesa.DISPONIVEL;
//        }
}