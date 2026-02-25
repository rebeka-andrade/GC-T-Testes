package br.edu.ifpe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClienteTest {

    @Mock
    private ClienteRepositorio clienteRepositorio;

    @InjectMocks
    private ClienteService clienteService;

    private Cliente cliente;
    private Cliente tutor;

    @BeforeEach
    public void configurar() {
        cliente = Cliente.builder()
                .codigo(33)
                .nome("Rebeka")
                .dataNascimento("12/06/2010")
                .cpf("144.657.893-67")
                .email("rebeka@gmail.com")
                .senha("123456@f")
                .tutor(tutor)
                .build();

                Cliente tutor = Cliente.builder()
                .codigo(1)
                .nome("Clarice")
                .build();
    }

    @Test
    public void testeClientePacienteCadastroComSucesso() {

        this.clienteService.cadastrar(this.cliente);

        verify(this.clienteRepositorio, times(1)).inserir(this.cliente);
    }

    @Test
    public void testeVerificarCPFCadastro() {

        when(clienteRepositorio.buscarPorCPF("144.657.893-67"))
                .thenReturn(Optional.of(cliente));

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> clienteService.cadastrar(cliente));

        assertEquals("CPF já cadastrado!", exception.getMessage());
    }

    @Test
    public void testeAtualizarPerfilClienteSistema() {

        when(clienteRepositorio.buscarPorCodigo(33))
                .thenReturn(Optional.of(cliente));

        clienteService.atualizar(cliente);

        verify(clienteRepositorio, times(1)).buscarPorCodigo(33);
        verify(clienteRepositorio, times(1)).atualizar(cliente);
    }

    @Test
    public void testeAtualizarClienteInexistente() {

        when(clienteRepositorio.buscarPorCodigo(33))
                .thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> clienteService.atualizar(cliente));

        assertEquals("Cliente não encontrado!", exception.getMessage());

        verify(clienteRepositorio, times(1)).buscarPorCodigo(33);
        verify(clienteRepositorio, times(0)).atualizar(cliente);
    }

    @Test
    public void testeLoginComSucesso() {

        when(clienteRepositorio.buscarPorEmail("rebeka@gmail.com"))
                .thenReturn(Optional.of(cliente));

        clienteService.login("rebeka@gmail.com", "123456@f");

        verify(clienteRepositorio, times(1))
                .buscarPorEmail("rebeka@gmail.com");
    }

    @Test
    public void cadastrarMenorComoDependenteComSucesso() {

        when(clienteRepositorio.buscarPorCodigo(1))
                .thenReturn(Optional.of(tutor));

        clienteService.cadastrarDependente(cliente, 1);

        verify(clienteRepositorio, times(1)).buscarPorCodigo(1);
        verify(clienteRepositorio, times(1)).inserir(cliente);
    }
}