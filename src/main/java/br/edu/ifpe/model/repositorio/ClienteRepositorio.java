package br.edu.ifpe.model.repositorio;

import java.util.Optional;

import br.edu.ifpe.model.entity.Cliente;

public interface ClienteRepositorio {

    void inserir(Cliente cliente);

    Optional<Cliente> buscarPorEmail(String email);

    Optional<Cliente> buscarPorCPF(String cpf);

    Optional<Cliente> buscarPorCodigo(Integer codigo);

    void atualizar(Cliente cliente);

}