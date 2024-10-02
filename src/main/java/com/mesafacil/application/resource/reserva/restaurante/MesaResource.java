package com.mesafacil.application.resource.reserva.restaurante;

import com.mesafacil.application.util.UriUtil;
import com.mesafacil.dominio.reserva.restaurante.entity.MesaDto;
import com.mesafacil.dominio.reserva.restaurante.mapper.MesaMapper;
import com.mesafacil.dominio.reserva.restaurante.model.Mesa;
import com.mesafacil.dominio.reserva.restaurante.model.Restaurante;
import com.mesafacil.dominio.reserva.restaurante.service.MesaService;
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
@RequestMapping("/api/v1/reserva/mesa")
@Tag(name = "Mesa", description = "Controle do registro de Mesas")
public class MesaResource {

    private final MesaService mesaService;
    private final MesaMapper mesaMapper;

    @GetMapping
    @Operation(summary = "Buscar as mesas registrados.", method = "GET")
    public Page<MesaDto> consultarTodos(@Parameter(hidden = true)   @PageableDefault(size = 10, sort = {"numeroMesa"}) Pageable paginacao) {
        return mesaService.consultar(paginacao).map(mesaMapper::entityToDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastra uma nova mesa.", method = "POST")
    public ResponseEntity<MesaDto> cadastrarMesa(@Valid @RequestBody MesaDto mesaDto) {
        Mesa mesa = mesaMapper.dtoToEntity(mesaDto);
        mesaService.cadastrarMesa(mesa);
        return ResponseEntity.created(UriUtil.createUriWithId(mesa.getIdMesa()))
                .body(mesaMapper.entityToDto(mesa));
    }

}
