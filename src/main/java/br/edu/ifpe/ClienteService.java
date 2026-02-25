package br.edu.ifpe;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class ClienteService {

    private ClienteRepositorio clienteRepositorio;

    public ClienteService(ClienteRepositorio repo) {
        this.clienteRepositorio = repo;
    }

    public void cadastrar(Cliente cliente) {

        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório!");
        }

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

        Cliente tutor = clienteRepositorio.buscarPorCodigo(tutorId)
                .orElseThrow(() -> new IllegalArgumentException("Tutor não encontrado!"));

        dependente.setTutor(tutor);

        clienteRepositorio.inserir(dependente);
    }

    public void cadastrarPlanoSaude(Integer codigoCliente, PlanoSaude plano) {

        Cliente cliente = clienteRepositorio.buscarPorCodigo(codigoCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        YearMonth validade = YearMonth.parse(plano.getValidade(), formatter);

        if (validade.isBefore(YearMonth.now())) {
            throw new IllegalArgumentException("Plano de saúde vencido!");
        }

        cliente.adicionarPlanoSaude(plano);
        clienteRepositorio.atualizar(cliente);

    }

    public void registrarCondicaoSaude(Integer codigoCliente, CondicaoSaude condicao) {

        Cliente cliente = clienteRepositorio.buscarPorCodigo(codigoCliente)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado!"));

        if (condicao.getPressaoCorporal() == null || condicao.getPressaoCorporal().isBlank()) {
            throw new IllegalArgumentException("Pressão corporal obrigatória!");
        }

        if (condicao.getTemperaturaCorporal() == null || condicao.getTemperaturaCorporal().isBlank()) {
            throw new IllegalArgumentException("Temperatura corporal obrigatória!");
        }

        cliente.adicionarCondicaoSaude(condicao);

        clienteRepositorio.atualizar(cliente);
    }
}