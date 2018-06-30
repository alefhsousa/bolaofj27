package com.alefh.deusnocomando.services;

import com.alefh.deusnocomando.modelos.Palpite;
import com.alefh.deusnocomando.repository.PalpiteiroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PalpiteiroService {

    @Autowired private PalpiteiroRepository palpiteiroRepository;
    @Autowired private ChecadorDoPalpiteiro checadorDoPalpiteiro;

    public Palpite criaPalpite(Palpite palpite) {
        return palpiteiroRepository.save(palpite);
    }

    public void checaPalpites() {
        checadorDoPalpiteiro.checaOsPalpites();
    }

    public Palpite buscaPeloId(String id) {
        return palpiteiroRepository.findOne(id);
    }
}
