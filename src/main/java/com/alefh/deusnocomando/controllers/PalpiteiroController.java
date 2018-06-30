package com.alefh.deusnocomando.controllers;

import com.alefh.deusnocomando.modelos.Palpite;
import com.alefh.deusnocomando.services.PalpiteiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import static java.util.Optional.ofNullable;

@RestController
@RequestMapping("/palpites")
public class PalpiteiroController {
    @Autowired private PalpiteiroService service;

    @PostMapping
    public ResponseEntity<Palpite> criaPalpite(@RequestBody Palpite palpite) throws URISyntaxException {
        Palpite palpiteCriado = service.criaPalpite(palpite);
        return  ResponseEntity
                .created(new URI("/palpites/" + palpiteCriado.getId()))
                .body(palpiteCriado);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Palpite> buscaPalpitePeloId(@PathVariable String id) {
        Palpite palpite = service.buscaPeloId(id);

        if (Objects.isNull(palpite)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(palpite);
    }

    @PostMapping(value = "/checaPalpites")
    public ResponseEntity checaPalpites() {
        service.checaPalpites();
        return ResponseEntity.accepted().build();
    }

}
