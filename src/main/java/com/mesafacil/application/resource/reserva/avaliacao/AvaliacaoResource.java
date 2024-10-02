package com.mesafacil.application.resource.reserva.avaliacao;

import com.mesafacil.application.util.UriUtil;
import com.mesafacil.dominio.reserva.avaliacao.entity.AvaliacaoDto;
import com.mesafacil.dominio.reserva.avaliacao.mapper.AvaliacaoMapper;
import com.mesafacil.dominio.reserva.avaliacao.model.Avaliacao;
import com.mesafacil.dominio.reserva.avaliacao.service.AvaliacaoService;
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
@RequestMapping("/api/v1/reserva/avaliacao")
@Tag(name = "Avaliação", description = "Registro de avaliações dos restaurantes")
public class AvaliacaoResource {

    private final AvaliacaoService avaliacaoService;
    private final AvaliacaoMapper avaliacaoMapper;

    @GetMapping
    @Operation(summary = "Buscar as avaliações registradas.", method = "GET")
    public Page<AvaliacaoDto> consultarTodos( @Parameter(hidden = true)  @PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        return avaliacaoService.consultar(paginacao).map(avaliacaoMapper::entityToDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma avaliação pelo identificador.", method = "GET")
    public ResponseEntity<AvaliacaoDto> consultarAvaliacao(@PathVariable("id") Long id) {
        return avaliacaoService.consultarPorId(id)
                .map(avaliacao -> ResponseEntity.ok(avaliacaoMapper.entityToDto(avaliacao)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastra uma nova avaliação.", method = "POST")
    public ResponseEntity<AvaliacaoDto> cadastrar(@Valid @RequestBody AvaliacaoDto avaliacaoDto) {
        Avaliacao avaliacao = avaliacaoMapper.dtoToEntity(avaliacaoDto);
        avaliacaoService.cadastrar(avaliacao);
        return ResponseEntity.created(UriUtil.createUriWithId(avaliacao.getId()))
                .body(avaliacaoMapper.entityToDto(avaliacao));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma avaliação pelo identificador.", method = "DELETE")
    public ResponseEntity<Object> deletarAvaliacao(@PathVariable("id") Long id) {
        return avaliacaoService.consultarPorId(id)
                .map(avaliacao -> {
                    avaliacaoService.deletar(avaliacao);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma avaliação pelo identificador.", method = "PUT")
    public ResponseEntity<AvaliacaoDto> atualizarAvaliacao(@PathVariable("id") Long id, @RequestBody AvaliacaoDto avaliacaoDto) {
        return avaliacaoService.consultarPorId(id)
                .map(avaliacaoExistente -> {
                    avaliacaoExistente.setNota(avaliacaoDto.nota());
                    avaliacaoExistente.setComentario(avaliacaoDto.comentario());
                    Avaliacao avaliacaoAtualizada = avaliacaoService.atualizar(avaliacaoExistente);

                    return ResponseEntity.ok(avaliacaoMapper.entityToDto(avaliacaoAtualizada));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
