package br.edu.ifpe;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Cliente {
    
    private Integer codigo;
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;
    private String senha;

    private Cliente tutor;
}