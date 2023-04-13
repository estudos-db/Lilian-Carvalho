package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEnderecoDTO;

public record DadosAtualizacaoMedico(@NotNull Long id, String nome, String telefone,
                                     DadosEnderecoDTO endereco) {}
