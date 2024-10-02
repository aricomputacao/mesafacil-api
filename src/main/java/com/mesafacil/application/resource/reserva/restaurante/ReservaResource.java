package com.mesafacil.application.resource.reserva.restaurante;

import com.mesafacil.application.util.UriUtil;
import com.mesafacil.dominio.reserva.avaliacao.entity.AvaliacaoDto;
import com.mesafacil.dominio.reserva.avaliacao.model.Avaliacao;
import com.mesafacil.dominio.reserva.restaurante.entity.ReservaDto;
import com.mesafacil.dominio.reserva.restaurante.mapper.ReservaMapper;
import com.mesafacil.dominio.reserva.restaurante.model.Mesa;
import com.mesafacil.dominio.reserva.restaurante.model.Reserva;
import com.mesafacil.dominio.reserva.restaurante.model.Restaurante;
import com.mesafacil.dominio.reserva.restaurante.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/reserva/reserva")
@Tag(name = "Reserva", description = "Controle do registro de reservas.")
public class ReservaResource {

    private final ReservaService reservaService;
    private final ReservaMapper reservaMapper;

    @GetMapping
    @Operation(summary = "Buscar as reservas registrados.", method = "GET")
    public Page<ReservaDto> consultarTodos(@Parameter(hidden = true)  @PageableDefault(size = 10, sort = {"nomeCliente"}) Pageable paginacao) {
        return reservaService.consultar(paginacao).map(reservaMapper::entityToDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastra uma nova reserva.", method = "POST")
    public ResponseEntity<ReservaDto> cadastrarReserva(@Valid @RequestBody ReservaDto reservaDto) {
        Reserva reserva = reservaMapper.dtoToEntity(reservaDto);
        reservaService.cadastrarReserva(reserva);
        return ResponseEntity.created(UriUtil.createUriWithId(reserva.getIdReserva()))
                .body(reservaMapper.entityToDto(reserva));
    }


    @PutMapping("/{id}")
    @Operation(summary = "Confirma uma reserva pelo identificador.", method = "PUT")
    public ResponseEntity<ReservaDto> atualizarReserva(@PathVariable("id") Long id, @RequestBody ReservaDto reservaDto) {
        return reservaService.consultarPorId(id)
                .map(reservaExistente -> {
                    reservaExistente.setDescricao(reservaDto.descricao());
                    Reserva reservaAtualizada = reservaService.atualizar(reservaExistente);

                    return ResponseEntity.ok(reservaMapper.entityToDto(reservaAtualizada));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
