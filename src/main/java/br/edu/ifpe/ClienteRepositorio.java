package br.edu.ifpe;

import java.util.Optional;

public interface ClienteRepositorio {
    
    void inserir(Cliente cliente);

    Optional<Cliente> buscarPorEmail(String email);
}