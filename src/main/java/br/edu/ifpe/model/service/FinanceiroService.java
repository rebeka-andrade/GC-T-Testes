package br.edu.ifpe.model.service;

public class FinanceiroService {

    public double calcularTotal(double consulta,
                                double exames,
                                double medicamentos) {

        return consulta + exames + medicamentos;
    }

    public String cobrarPlano(double total) {

        if (total <= 0) {
            throw new IllegalArgumentException("Valor inválido para cobrança.");
        }

        return "Plano de saúde cobrado com sucesso. Total: R$ " + total;
    }
}