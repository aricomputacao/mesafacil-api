package com.mesafacil.dominio.reserva.restaurante.service;

import com.mesafacil.dominio.reserva.restaurante.model.Mesa;
import com.mesafacil.dominio.reserva.restaurante.repository.MesaRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@CacheConfig(cacheNames = {"mesaCache"})
public class MesaService {
    private final MesaRepository mesaRepository;

    @CacheEvict(allEntries = true, cacheNames = "mesaCache")
    public void cadastrarMesa(Mesa mesa) {
        mesaRepository.save(mesa);
    }

    /**
     * unless = "#result == null": Indica que o resultado não será armazenado no cache se for nulo.
     * Isso é útil para evitar armazenar resultados vazios.
     * @return
     */
    @Cacheable( unless = "#result == null ")
    public Page<Mesa> consultar(Pageable pageable){
        return mesaRepository.findAll(pageable);
    }

}
