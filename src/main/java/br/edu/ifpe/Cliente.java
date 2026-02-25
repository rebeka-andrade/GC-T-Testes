package br.edu.ifpe;

import java.util.ArrayList;
import java.util.List;

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

    @Builder.Default
    private List<PlanoSaude> planosSaude = new ArrayList<>();

    @Builder.Default
    private List<CondicaoSaude> condicoesSaude = new ArrayList<>();

    public void adicionarPlanoSaude(PlanoSaude plano) {
        this.planosSaude.add(plano);
    }

    public void adicionarCondicaoSaude(CondicaoSaude condicao) {
        this.condicoesSaude.add(condicao);
    }
}