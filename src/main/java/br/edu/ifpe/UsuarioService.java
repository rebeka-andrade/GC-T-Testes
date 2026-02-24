package br.edu.ifpe;

public class UsuarioService {

    private UsuarioReporitorio usuarioReporitorio;

    public UsuarioService(UsuarioReporitorio repo) {
        this.usuarioReporitorio = repo;
    }

    public void cadastrar(Usuario usuario) {

        this.usuarioReporitorio.inserir(usuario);
    }

    public void login(String email, String senha) {
        
    }

}