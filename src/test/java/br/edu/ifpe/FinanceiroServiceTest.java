package br.edu.ifpe;

import org.junit.jupiter.api.Test;

import br.edu.ifpe.model.service.FinanceiroService;

import static org.junit.jupiter.api.Assertions.*;

public class FinanceiroServiceTest {

    @Test
    void deveCalcularTotalERealizarCobrancaAmbulatorial() {

        FinanceiroService financeiro = new FinanceiroService();

        double valorConsulta = 200.0;
        double valorExames = 150.0;
        double valorMedicamentos = 50.0;

        double total = financeiro.calcularTotal(
                valorConsulta,
                valorExames,
                valorMedicamentos
        );

        String resultado = financeiro.cobrarPlano(total);

        assertEquals(400.0, total);
        assertTrue(resultado.contains("Plano de saúde cobrado"));
    }
}