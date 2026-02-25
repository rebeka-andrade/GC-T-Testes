package br.edu.ifpe;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CondicaoSaude {

    private String pressaoCorporal;
    private String temperaturaCorporal;
    private String sintomas;
}