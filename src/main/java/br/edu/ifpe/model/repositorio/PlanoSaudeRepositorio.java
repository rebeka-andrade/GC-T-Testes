package br.edu.ifpe.model.repositorio;

import java.util.Optional;

import br.edu.ifpe.model.entity.PlanoSaude;

public interface PlanoSaudeRepositorio {
    Optional<PlanoSaude> buscarPorCodigo(Integer codigo);
}