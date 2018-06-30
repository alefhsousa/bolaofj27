package com.alefh.deusnocomando.repository;

import com.alefh.deusnocomando.modelos.Partida;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PartidaRepository extends MongoRepository<Partida, String> {

    List<Partida> findByStatus(String status);
    Partida findByCodigoDaFifa(Long codigoFifa);
}
