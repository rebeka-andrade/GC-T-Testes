package br.edu.ifpe;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Cliente {
    
    private Integer codigo;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;
    private String senha;

    private Cliente tutor;
}