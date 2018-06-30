package com.alefh.deusnocomando.services;

import com.alefh.deusnocomando.modelos.Palpite;
import com.alefh.deusnocomando.modelos.Partida;
import com.alefh.deusnocomando.repository.PalpiteiroRepository;
import com.alefh.deusnocomando.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChecadorDoPalpiteiro {
    @Autowired private PalpiteiroRepository palpiteiroRepository;
    @Autowired private PartidaRepository partidaRepository;


    @Scheduled(fixedRate = 120000)
    public void checaOsPalpites() {
        ArrayList<Palpite> palpitesCerteiros = new ArrayList<Palpite>();
        partidaRepository.findByStatus("completed")
                .forEach(partida -> {
                    List<Palpite> palpites = palpiteiroRepository.findByCodigoPartida(partida.getCodigoDaFifa());


                    palpites.forEach(palpite -> {
                        boolean seGanhou = verificaSeGanhou(partida, palpite);

                        if (seGanhou) {
                            palpite.tornaPalpiteCerteiro();
                            palpitesCerteiros.add(palpite);
                        }
                        palpite.palpiteVerificado();
                        palpiteiroRepository.save(palpite);
                    });
                });
        if (!palpitesCerteiros.isEmpty()) {
            palpiteiroRepository.save(palpitesCerteiros);
        }
    }

    private boolean verificaSeGanhou(Partida partida, Palpite palpite) {
        boolean resultadoDaCasa = partida.getMandante().getGols() == palpite.getMandante().getGols();
        boolean resultadoVisitante = partida.getVisitante().getGols() == palpite.getVisitante().getGols();
        return resultadoDaCasa && resultadoVisitante;
    }
}
