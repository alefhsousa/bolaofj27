package com.alefh.deusnocomando;

import com.alefh.deusnocomando.modelos.Partida;
import com.alefh.deusnocomando.repository.PartidaRepository;
import com.alefh.deusnocomando.worldcupapi.WorldCupApiClient;
import com.alefh.deusnocomando.worldcupapi.models.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableFeignClients
public class DeusnocomandoApplication {
	@Autowired private WorldCupApiClient client;
	@Autowired private PartidaRepository partidaRepository;
	public static void main(String[] args) {
		SpringApplication.run(DeusnocomandoApplication.class, args);
	}

	@PostConstruct
	public void populateDatabase() {

		if(partidaRepository.count() <= 0 ) {
			List<Partida> partidas = client.buscaPartidasNaApi()
					.stream()
					.map(Match::toDomain)
					.collect(Collectors.toList());

			partidaRepository.save(partidas);
		}

	}
}
