package com.alefh.deusnocomando.worldcupapi;

import com.alefh.deusnocomando.worldcupapi.models.Match;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "world-cup", url = "${worldcup.api}")
public interface WorldCupApiClient {

    @GetMapping(value = "/matches")
    List<Match> buscaPartidasNaApi();
}
