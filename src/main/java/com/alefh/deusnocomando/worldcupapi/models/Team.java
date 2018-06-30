package com.alefh.deusnocomando.worldcupapi.models;

import com.alefh.deusnocomando.modelos.Selecao;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Team {

    private String country;
    private String code;
    private Integer goals;

    public Selecao toDomain() {
        Selecao selecao = new Selecao();
        selecao.setGols(goals);
        selecao.setNome(country);
        selecao.setSigla(code);
        return selecao;
    }
}
