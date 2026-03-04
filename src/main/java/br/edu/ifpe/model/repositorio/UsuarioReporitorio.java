package br.edu.ifpe.model.repositorio;

import java.util.Optional;

import br.edu.ifpe.model.entity.Usuario;

public interface UsuarioReporitorio {

    void inserir(Usuario usuario);

    Optional<Usuario> buscarPorEmail(String email);
}