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

        cliente = Cliente.builder()
                .codigo(2)
                .nome("Clarice")
                .cpf("123.321.123-45")
                .email("clarice@gmail.com")
                .build();

        plano = PlanoSaude.builder()
                .codigo(1)
                .nomePlano("Nimed")
                .validade("17/07/2027")
                .build();

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

    @Test
    public void testeRegistrarAtendimentoEmergencialComSucesso() {

        Atendimento atendimentoEmergencial = new Atendimento();
        atendimentoEmergencial.setCliente(cliente);
        atendimentoEmergencial.setPlano(plano);
        atendimentoEmergencial.setTipo("EMERGENCIAL");
        atendimentoEmergencial.setMedico("Junior");
        atendimentoEmergencial.setAcompanhante("Lucicleide");

        when(clienteRepositorio.buscarPorCodigo(2))
                .thenReturn(Optional.of(cliente));

        when(planoRepositorio.buscarPorCodigo(1))
                .thenReturn(Optional.of(plano));

        atendimentoService.registrarAtendimento(atendimentoEmergencial);

        verify(atendimentoRepositorio, times(1))
                .salvar(atendimentoEmergencial);
    }
}