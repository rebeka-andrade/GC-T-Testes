package br.edu.ifpe.model.service;

import br.edu.ifpe.model.entity.Prontuario;

public class ProntuarioService {

    public void registrarPrescricao(Prontuario prontuario,
                                    String prescricao,
                                    String medicamentos) {

        prontuario.setPrescricao(prescricao);
        prontuario.setMedicamentos(medicamentos);
    }

    public String submeterParaDorAI(Prontuario prontuario) {

        if (prontuario == null) {
            throw new IllegalArgumentException("Prontuário obrigatório!");
        }

        if (prontuario.getSintomas() == null || prontuario.getSintomas().isBlank()) {
            throw new IllegalArgumentException("Prontuário sem informações suficientes!");
        }

        return "Sugestão DorAI: Possível caso de hipertensão. Avaliar pressão arterial.";
    }

    public String finalizarProntuario(Prontuario prontuario) {

        if (prontuario == null) {
            throw new IllegalArgumentException("Prontuário obrigatório!");
        }

        return submeterParaDorAI(prontuario);
    }

    public String processarProntuario(Prontuario prontuario) {

        DorAIService dorAI = new DorAIService();

        return dorAI.processar(prontuario);
    }

    public String realizarAtendimentoAmbulatorial(Prontuario prontuario) {

        if (prontuario == null) {
            throw new IllegalArgumentException("Prontuário obrigatório!");
        }

        FinanceiroService financeiro = new FinanceiroService();

        double total = 100.0; 
        return financeiro.cobrarPlano(total);
    }

    public String realizarAtendimentoEmergencial(Prontuario prontuario) {

        if (prontuario == null) {
            throw new IllegalArgumentException("Prontuário obrigatório!");
        }

        FinanceiroService financeiro = new FinanceiroService();

       double total = 200.0; 
       return financeiro.cobrarPlano(total);
    }

}