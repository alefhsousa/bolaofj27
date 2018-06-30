package com.alefh.deusnocomando.controllers;

import com.alefh.deusnocomando.modelos.Partida;
import com.alefh.deusnocomando.services.PartidaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("partidas")
@AllArgsConstructor
public class PartidaController {
    private PartidaService service;

    @GetMapping
    public ResponseEntity<List<Partida>> buscaPartidas() {
        return ResponseEntity.ok(service.listaPartidas());
    }
}
