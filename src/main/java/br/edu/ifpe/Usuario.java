package br.edu.ifpe;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Usuario {

    private String nome;
    private String cpf;
    private Integer idade;
}
