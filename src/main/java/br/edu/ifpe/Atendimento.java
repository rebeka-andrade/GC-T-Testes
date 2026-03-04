package br.edu.ifpe;

public class Atendimento {

    private Cliente cliente;
    private PlanoSaude plano;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PlanoSaude getPlano() {
        return plano;
    }

    public void setPlano(PlanoSaude plano) {
        this.plano = plano;
    }
}