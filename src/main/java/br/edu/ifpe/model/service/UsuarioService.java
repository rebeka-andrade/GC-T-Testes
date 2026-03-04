package br.edu.ifpe.model.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import br.edu.ifpe.model.entity.Usuario;
import br.edu.ifpe.model.repositorio.UsuarioReporitorio;

public class UsuarioService {

    private UsuarioReporitorio usuarioReporitorio;

    public UsuarioService(UsuarioReporitorio repo) {
        this.usuarioReporitorio = repo;
    }

    public void cadastrar(Usuario usuario) {
        this.usuarioReporitorio.inserir(usuario);
    }

    public void login(String email, String senha) {

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("e-mail inválido");
        }

        Optional<Usuario> usuarioOptional = usuarioReporitorio.buscarPorEmail(email);

        if (usuarioOptional.isEmpty()) {
            throw new NoSuchElementException("Login incorreto, tente novamente");
        }

        Usuario usuario = usuarioOptional.get();

        if (!usuario.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Senha inválida, tente novamente");
        }
    }
}