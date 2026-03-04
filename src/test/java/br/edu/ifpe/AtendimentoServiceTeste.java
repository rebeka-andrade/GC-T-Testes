package br.edu.ifpe;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AtendimentoServiceTest {

    private AtendimentoRepositorio atendimentoRepositorio;
    private ClienteRepositorio clienteRepositorio;
    private PlanoSaudeRepositorio planoRepositorio;

    private AtendimentoService atendimentoService;

    private Cliente cliente;
    private PlanoSaude plano;
    private Atendimento atendimento;

    @BeforeEach
    public void setUp() {

        atendimentoRepositorio = mock(AtendimentoRepositorio.class);
        clienteRepositorio = mock(ClienteRepositorio.class);
        planoRepositorio = mock(PlanoSaudeRepositorio.class);

        atendimentoService = new AtendimentoService(
                atendimentoRepositorio,
                clienteRepositorio,
                planoRepositorio
        );

        cliente = new Cliente();
        cliente.setCodigo(2);

        plano = new PlanoSaude();
        plano.setCodigo(1);

        atendimento = new Atendimento();
        atendimento.setCliente(cliente);
        atendimento.setPlano(plano);
    }

    @Test
    public void testeRegistrarAtendimentoAmbulatorialComSucesso() {

        when(clienteRepositorio.buscarPorCodigo(2))
                .thenReturn(Optional.of(cliente));

        when(planoRepositorio.buscarPorCodigo(1))
                .thenReturn(Optional.of(plano));

        atendimentoService.registrarAtendimento(atendimento);

        verify(atendimentoRepositorio, times(1))
                .salvar(atendimento);
    }
}