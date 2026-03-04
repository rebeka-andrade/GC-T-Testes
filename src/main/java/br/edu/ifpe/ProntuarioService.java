package br.edu.ifpe;

public class ProntuarioService {

    public void registrarPrescricao(Prontuario prontuario,
                                    String prescricao,
                                    String medicamentos) {

        prontuario.setPrescricao(prescricao);
        prontuario.setMedicamentos(medicamentos);
    }
}