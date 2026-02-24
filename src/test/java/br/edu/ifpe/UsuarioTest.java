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
public class UsuarioTest {

    @Mock
    private UsuarioReporitorio usuarioReporitorio;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;

    @BeforeEach
    public void configurar() {
        usuario = Usuario.builder()
                .nome("Vilmar")
                .idade(10)
                .cpf("11111111111")
                .build();
    }

    // ==================== LOGIN ====================

    @Test
    public void testeUsuarioCadastroComSucesso() {

        this.usuarioService.cadastrar(this.usuario);

        verify(this.usuarioReporitorio, times(2)).inserir(this.usuario);
    }

}