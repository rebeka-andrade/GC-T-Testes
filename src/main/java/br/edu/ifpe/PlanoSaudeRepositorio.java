package br.edu.ifpe;

import java.util.Optional;

public interface PlanoSaudeRepositorio {
    Optional<PlanoSaude> buscarPorCodigo(Integer codigo);
}