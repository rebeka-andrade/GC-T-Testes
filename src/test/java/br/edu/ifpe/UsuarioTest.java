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

import java.util.NoSuchElementException;
import java.util.Optional;

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
                .email("vilmar@gmail.com")
                .senha("123456@f")
                .build();
    }

    @Test
    public void testeUsuarioCadastroComSucesso() {

        this.usuarioService.cadastrar(this.usuario);

        verify(this.usuarioReporitorio, times(1)).inserir(this.usuario);
    }

    @Test
    public void testeLoginSenhaInvalida() {

        when(usuarioReporitorio.buscarPorEmail("vilmar@gmail.com"))
                .thenReturn(Optional.of(usuario));

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> usuarioService.login("vilmar@gmail.com", "0000000"));

        assertEquals("Senha inválida, tente novamente", exception.getMessage());

        verify(usuarioReporitorio, times(1))
                .buscarPorEmail("vilmar@gmail.com");
    }

    @Test
    public void testeLoginInvalido() {

        when(usuarioReporitorio.buscarPorEmail("clarice@gmail.com"))
                .thenReturn(Optional.empty());

        NoSuchElementException exception = assertThrows(
                NoSuchElementException.class,
                () -> usuarioService.login("clarice@gmail.com", "123456@f"));

        assertEquals("Login incorreto, tente novamente", exception.getMessage());

        verify(usuarioReporitorio, times(1))
                .buscarPorEmail("clarice@gmail.com");
    }

    @Test
    public void testeEmailInvalido() {

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> usuarioService.login("vilmargmail.com", "123456@f"));

        assertEquals("e-mail inválido", exception.getMessage());

        verify(usuarioReporitorio, times(0))
                .buscarPorEmail("vilmargmail.com");
    }

}