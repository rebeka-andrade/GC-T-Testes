package br.edu.ifpe;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProntuarioServiceTest {

    @Test
    void deveRegistrarPrescricaoEMedicamentosComSucesso() {

        Prontuario prontuario = new Prontuario();
        prontuario.setDataAtendimento("20/03/2026");

        ProntuarioService service = new ProntuarioService();

        service.registrarPrescricao(
                prontuario,
                "Uso de analgésico por 5 dias",
                "Dipirona"
        );

        assertEquals("Uso de analgésico por 5 dias", prontuario.getPrescricao());
        assertEquals("Dipirona", prontuario.getMedicamentos());
    }
}

