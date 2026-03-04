package br.edu.ifpe;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PlanoSaude {

    private Integer codigo;
    private String nomePlano;
    private String validade;
}