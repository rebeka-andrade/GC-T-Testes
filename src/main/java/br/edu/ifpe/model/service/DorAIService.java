package br.edu.ifpe.model.service;

import br.edu.ifpe.model.entity.Prontuario;

public class DorAIService {

    public String processar(Prontuario prontuario) {

        if (prontuario == null) {
            throw new IllegalArgumentException("Prontuário obrigatório!");
        }

        return "Processamento DorAI concluído e salvo com sucesso.";
    }
}