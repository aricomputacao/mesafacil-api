package com.mesafacil.dominio.reserva.restaurante.entity;

import com.mesafacil.dominio.reserva.restaurante.enumeration.StatusReserva;
import com.mesafacil.dominio.reserva.restaurante.model.Mesa;
import com.mesafacil.dominio.reserva.restaurante.model.Restaurante;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public record ReservaDto (

    Long idReserva,

    @NotNull
    String nomeCliente,

    @NotNull
    Restaurante restaurante,

    @NotNull
    Date data,

    @NotNull
    Time horario,

    @NotNull
    Mesa mesa,

    @NotNull
    StatusReserva descricao
) {
}
