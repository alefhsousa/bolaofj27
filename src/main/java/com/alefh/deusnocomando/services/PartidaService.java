package com.alefh.deusnocomando.services;

import com.alefh.deusnocomando.modelos.Partida;
import com.alefh.deusnocomando.repository.PartidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PartidaService {

    private PartidaRepository partidaRepository;

    public List<Partida> listaPartidas() {
        return partidaRepository.findAll();
    }
}
