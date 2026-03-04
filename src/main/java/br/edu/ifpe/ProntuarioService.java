package br.edu.ifpe;

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

        // Simulação da IA DorAI
        return "Sugestão DorAI: Possível caso de hipertensão. Avaliar pressão arterial.";
    }

    public String finalizarProntuario(Prontuario prontuario) {

        if (prontuario == null) {
            throw new IllegalArgumentException("Prontuário obrigatório!");
        }

        // Aqui simulamos que o registro foi finalizado
        // e automaticamente chamamos a DorAI

        return submeterParaDorAI(prontuario);
    }
}