package br.edu.ifpe;

public class FuncionarioService {

    private FuncionarioRepositorio FuncionarioRepositorio;

    public FuncionarioService(FuncionarioReporitorio repo) {
        this.funcionarioReporitorio = repo;
    }

    public void cadastrar(Funcionario funcionario) {

        this.funcionarioRepositorio.inserir(funcionario);
    }
}
