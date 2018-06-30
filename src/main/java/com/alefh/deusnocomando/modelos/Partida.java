package com.alefh.deusnocomando.modelos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "partidas")
public class Partida {

    @Id
    private String id;
    private String estadio;
    private String codigoVencedor;
    private Long codigoDaFifa;
    private Selecao mandante;
    private Selecao visitante;
    private String status;

}
