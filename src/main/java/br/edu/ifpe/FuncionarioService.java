package br.edu.ifpe;

public class FuncionarioService {

    private FuncionarioRepositorio funcionarioRepositorio;

    public FuncionarioService(FuncionarioRepositorio repo) {
        this.funcionarioRepositorio = repo;
    }

    public void cadastrar(Funcionario funcionario) {

        this.funcionarioRepositorio.inserir(funcionario);
    }
}