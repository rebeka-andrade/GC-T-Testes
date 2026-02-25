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

}