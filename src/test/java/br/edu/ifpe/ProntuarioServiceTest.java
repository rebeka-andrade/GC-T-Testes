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

    @Test
    void deveSubmeterProntuarioParaDorAIComSucesso() {

        Prontuario prontuario = new Prontuario();
        prontuario.setSintomas("Dor no peito");
        prontuario.setDiagnostico("Pressão elevada");

        ProntuarioService service = new ProntuarioService();

        String sugestao = service.submeterParaDorAI(prontuario);

        assertNotNull(sugestao);
        assertFalse(sugestao.isBlank());
    }

    @Test
    void deveAcionarDorAIAoFinalizarProntuario() {

        Prontuario prontuario = new Prontuario();
        prontuario.setSintomas("Dor no peito");
        prontuario.setDiagnostico("Pressão elevada");

        ProntuarioService service = new ProntuarioService();

        String sugestao = service.finalizarProntuario(prontuario);

        assertNotNull(sugestao);
        assertTrue(sugestao.contains("Sugestão DorAI"));
    }

    @Test
    void deveExecutarProcessamentoDeProntuarioViaDorAI() {

        Prontuario prontuario = new Prontuario();
        prontuario.setSintomas("Dor no peito");
        prontuario.setDiagnostico("Pressão elevada");

        ProntuarioService service = new ProntuarioService();

        String resultado = service.processarProntuario(prontuario);

        assertNotNull(resultado);
        assertTrue(resultado.contains("Processamento DorAI concluído"));
    }

    @Test
    void deveRealizarAtendimentoAmbulatorialECobrarPlano() {

        Prontuario prontuario = new Prontuario();
        prontuario.setSintomas("Dor no peito");
        prontuario.setDiagnostico("Pressão elevada");

        ProntuarioService service = new ProntuarioService();

        String resultado = service.realizarAtendimentoAmbulatorial(prontuario);

        assertNotNull(resultado);
        assertTrue(resultado.contains("Plano de saúde cobrado"));
    }

    @Test
    void TC_028_deveCobrarPlanoEmergencialComCalculoCorretoDoTotal() {

        Prontuario prontuario = new Prontuario();
        prontuario.setSintomas("Dor intensa");
        prontuario.setDiagnostico("Possível infarto");

        ProntuarioService service = new ProntuarioService();

        String resultado = service.realizarAtendimentoEmergencial(
                prontuario
        );

        assertEquals(
                "Plano de saúde cobrado com sucesso. Total: R$ 200.0",
                resultado
        );
    }
}

