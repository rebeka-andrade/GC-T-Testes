package br.edu.ifpe;

public class DorAIService {

    public String processar(Prontuario prontuario) {

        if (prontuario == null) {
            throw new IllegalArgumentException("Prontuário obrigatório!");
        }

        return "Processamento DorAI concluído e salvo com sucesso.";
    }
}