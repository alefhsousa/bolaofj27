package com.alefh.deusnocomando.worldcupapi.models;

import com.alefh.deusnocomando.modelos.Partida;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
public class Match {

    private String location;
    @JsonProperty(value = "fifa_id")
    private Long fifaId;
    private String winner;
    @JsonProperty(value = "winner_code")
    private String winnerCode;
    @JsonProperty(value = "home_team")
    private Team homeTeam;
    @JsonProperty(value = "away_team")
    private Team awayTeam;
    private String status;


    public Partida toDomain() {
        Partida partida = new Partida();
        partida.setCodigoDaFifa(this.fifaId);
        partida.setCodigoVencedor(this.winnerCode);
        partida.setEstadio(this.location);
        partida.setMandante(this.homeTeam.toDomain());
        partida.setVisitante(this.awayTeam.toDomain());
        partida.setStatus(status);
        return partida;
    }
}
