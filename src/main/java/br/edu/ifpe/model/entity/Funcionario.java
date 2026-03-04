package br.edu.ifpe.model.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Funcionario {

    private Integer codigo;
    private String area;
    private String matricula;
    private String login;
    private String senha;
    
}
