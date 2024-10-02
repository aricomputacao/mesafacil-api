package com.mesafacil.dominio.reserva.restaurante.service;

import com.mesafacil.dominio.reserva.avaliacao.model.Avaliacao;
import com.mesafacil.dominio.reserva.restaurante.entity.HorarioFuncionamentoDto;
import com.mesafacil.dominio.reserva.restaurante.enumeration.TipoDeCulinaria;
import com.mesafacil.dominio.reserva.restaurante.mapper.HorarioFuncionamentoMapper;
import com.mesafacil.dominio.reserva.restaurante.mapper.MesaMapper;
import com.mesafacil.dominio.reserva.restaurante.model.HorarioFuncionamento;
import com.mesafacil.dominio.reserva.restaurante.model.Restaurante;
import com.mesafacil.dominio.reserva.restaurante.repository.HorarioFuncionamentoRepository;
import com.mesafacil.dominio.reserva.restaurante.repository.MesaRepository;
import com.mesafacil.dominio.reserva.restaurante.repository.RestauranteRepository;
import com.mesafacil.dominio.reserva.restaurante.useCase.UseCaseRestauranteHorario;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@CacheConfig(cacheNames = {"restauranteCache"})
public class RestauranteService {

    private final HorarioFuncionamentoRepository horarioFuncionamentoRepository;
    private final RestauranteRepository restauranteRepository;
    private final HorarioFuncionamentoMapper horarioFuncionamentoMapper;
    private final List<UseCaseRestauranteHorario> useCaseRestauranteHorarios;

    @CacheEvict(allEntries = true, cacheNames = "restauranteCache")
    public void cadastrar(Restaurante restaurante) {
        restauranteRepository.save(restaurante);
    }

    @CacheEvict(allEntries = true, cacheNames = "restauranteCache")
    public HorarioFuncionamento registrarHorarioFuncionamento(HorarioFuncionamentoDto horarioFuncionamentoDto) {
        useCaseRestauranteHorarios
                .forEach(validacao -> validacao.validar(horarioFuncionamentoDto));
        HorarioFuncionamento horarioFuncionamento = horarioFuncionamentoMapper.dtoToEntity(horarioFuncionamentoDto);
        horarioFuncionamentoRepository.save(horarioFuncionamento);
        return horarioFuncionamento;
    }


    @Cacheable( unless = "#result == null ")
    public  Optional<List<Restaurante>> consultarPorTipoCulinaria(TipoDeCulinaria tipoDeCulinaria) {
        List<Restaurante> restaurantes = restauranteRepository.findByTiposDeCulinaria(tipoDeCulinaria);
        return restaurantes.isEmpty() ? Optional.empty() : Optional.of(restaurantes);
    }

//    @CacheEvict(allEntries = true, cacheNames = "mesaCache")
//    public Mesa cadastrarMesa(MesaDto mesaDto) {
//        Mesa mesa = mesaMapper.dtoToEntity(mesaDto);
//        mesaRepository.save(mesa);
//        return mesa;
//    }



    /**
     * unless = "#result == null": Indica que o resultado não será armazenado no cache se for nulo.
     * Isso é útil para evitar armazenar resultados vazios.
     * @return
     */
    @Cacheable( unless = "#result == null ")
    public Page<Restaurante> consultar(Pageable pageable){
        return restauranteRepository.findAll(pageable);
    }


}
