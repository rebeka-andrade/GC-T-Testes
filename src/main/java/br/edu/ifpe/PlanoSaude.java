package br.edu.ifpe;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PlanoSaude {

    private String nomePlano;
    private String validade;
}