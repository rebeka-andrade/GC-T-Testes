package br.edu.ifpe;

public class ClienteService {

    private ClienteRepositorio clienteRepositorio;

    public ClienteService(ClienteRepositorio repo) {
        this.clienteRepositorio = repo;
    }

    public void cadastrar(Cliente cliente) {

        this.clienteRepositorio.inserir(cliente);
    }

}
