package com.alefh.deusnocomando.repository;

import com.alefh.deusnocomando.modelos.Palpite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PalpiteiroRepository extends MongoRepository<Palpite, String>{

    List<Palpite> findByCodigoPartida(Long codigoPartida);
}
