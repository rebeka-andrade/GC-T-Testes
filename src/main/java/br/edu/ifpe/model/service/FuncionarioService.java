package br.edu.ifpe.model.service;

import br.edu.ifpe.model.entity.Funcionario;
import br.edu.ifpe.model.repositorio.FuncionarioRepositorio;

public class FuncionarioService {

    private FuncionarioRepositorio funcionarioRepositorio;

    public FuncionarioService(FuncionarioRepositorio repo) {
        this.funcionarioRepositorio = repo;
    }

    public void cadastrar(Funcionario funcionario) {

        this.funcionarioRepositorio.inserir(funcionario);
    }
}