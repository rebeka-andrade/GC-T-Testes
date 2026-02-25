package br.edu.ifpe;

public class ClienteService {

    private ClienteRepositorio clienteRepositorio;

    public ClienteService(ClienteRepositorio repo) {
        this.clienteRepositorio = repo;
    }

    public void cadastrar(Cliente cliente) {

        if (clienteRepositorio.buscarPorCPF(cliente.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado!");
        }

        this.clienteRepositorio.inserir(cliente);
    }

    public void atualizar(Cliente cliente) {

        clienteRepositorio.buscarPorCodigo(cliente.getCodigo())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));

        clienteRepositorio.atualizar(cliente);
    }

    public void login(String email, String senha) {

        Cliente cliente = clienteRepositorio.buscarPorEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado!"));

        if (!cliente.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Senha inválida!");
        }
    }

    public void cadastrarDependente(Cliente dependente, Integer tutorId) {
    }

}