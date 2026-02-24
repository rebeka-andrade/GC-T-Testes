package br.edu.ifpe;

import java.util.Optional;

public interface UsuarioReporitorio {

    void inserir(Usuario usuario);

    Optional<Usuario> buscarPorEmail(String email);
}
