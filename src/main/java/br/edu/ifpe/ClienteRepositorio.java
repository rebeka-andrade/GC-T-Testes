package br.edu.ifpe;

import java.util.Optional;

public interface ClienteRepositorio {

    void inserir(Cliente cliente);

    Optional<Cliente> buscarPorEmail(String email);

    Optional<Cliente> buscarPorCPF(String cpf);

    Optional<Cliente> buscarPorCodigo(Integer codigo);

    void atualizar(Cliente cliente);

}