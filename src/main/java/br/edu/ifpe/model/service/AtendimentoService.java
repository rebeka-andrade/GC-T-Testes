package br.edu.ifpe.model.service;

import br.edu.ifpe.model.entity.Atendimento;
import br.edu.ifpe.model.entity.Prontuario;
import br.edu.ifpe.model.repositorio.AtendimentoRepositorio;
import br.edu.ifpe.model.repositorio.ClienteRepositorio;
import br.edu.ifpe.model.repositorio.PlanoSaudeRepositorio;

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

    public void registrarProntuarioCompleto(
            Atendimento atendimento,
            String antecedentesClinicos,
            String antecedentesFamiliares,
            String sintomas,
            String diagnostico,
            String dataAtendimento) {

        Prontuario prontuario = new Prontuario();
        prontuario.setAntecedentesClinicos(antecedentesClinicos);
        prontuario.setAntecedentesFamiliares(antecedentesFamiliares);
        prontuario.setSintomas(sintomas);
        prontuario.setDiagnostico(diagnostico);
        prontuario.setDataAtendimento(dataAtendimento);

        atendimento.setProntuario(prontuario);
    }
}