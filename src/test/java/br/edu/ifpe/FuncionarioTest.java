package br.edu.ifpe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class FuncionarioTest {

    @Mock
    private FuncionarioRepositorio funcionarioRepositorio;

    @InjectMocks
    private FuncionarioService funcionarioService;

    private Funcionario funcionario;

    @BeforeEach
    public void configurar() {
        funcionario = Funcionario.builder()
                .codigo(22)
                .area("Financeiro")
                .matricula("2024y7")
                .login("funcionario")
                .senha("789@22")
                .build();
    }

    @Test
    public void testeCadastroFuncionarioComSucesso() {

        this.funcionarioService.cadastrar(this.funcionario);

        verify(this.funcionarioRepositorio, times(1)).inserir(this.funcionario);
    }
}