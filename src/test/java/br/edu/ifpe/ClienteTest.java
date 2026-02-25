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

    @BeforeEach
    public void configurar() {
        cliente = Cliente.builder()
                .codigo(33)
                .nome("Rebeka")
                .dataNascimento("12/06/2006")
                .cpf("123")
                .email("rebeka@gmail.com")
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

}