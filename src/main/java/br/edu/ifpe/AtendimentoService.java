package br.edu.ifpe;

import java.util.Optional;

public class AtendimentoService {

    private AtendimentoRepositorio atendimentoRepositorio;
    private ClienteRepositorio clienteRepositorio;
    private PlanoSaudeRepositorio planoRepositorio;

    public AtendimentoService(
            AtendimentoRepositorio atendimentoRepositorio,
            ClienteRepositorio clienteRepositorio,
            PlanoSaudeRepositorio planoRepositorio) {

        this.atendimentoRepositorio = atendimentoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.planoRepositorio = planoRepositorio;
    }

    public void registrarAtendimento(Atendimento atendimento) {

        clienteRepositorio.buscarPorCodigo(
                atendimento.getCliente().getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));

        planoRepositorio.buscarPorCodigo(
                atendimento.getPlano().getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Plano não encontrado!"));

        atendimentoRepositorio.salvar(atendimento);
    }

    public void registrarProntuario(Atendimento atendimento,
                                 String prescricao,
                                 String medicamentos) {

        Prontuario prontuario = new Prontuario();
        prontuario.setPrescricao(prescricao);
        prontuario.setMedicamentos(medicamentos);

        atendimento.setProntuario(prontuario);
    }
}