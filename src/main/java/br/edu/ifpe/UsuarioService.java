package br.edu.ifpe;

import java.util.Optional;

public class UsuarioService {

    private UsuarioReporitorio usuarioReporitorio;

    public UsuarioService(UsuarioReporitorio repo) {
        this.usuarioReporitorio = repo;
    }

    public void cadastrar(Usuario usuario) {

        this.usuarioReporitorio.inserir(usuario);
    }

    public void login(String email, String senha) {

        Optional<Usuario> usuarioOptional = usuarioReporitorio.buscarPorEmail(email);

        if (usuarioOptional.isEmpty()) {
            throw new RuntimeException("Login incorreto, tente novamente");
        }

        Usuario usuario = usuarioOptional.get();

        if (!usuario.getSenha().equals(senha)) {
            throw new RuntimeException("Senha inválida, tente novamente");
        }
    }

}