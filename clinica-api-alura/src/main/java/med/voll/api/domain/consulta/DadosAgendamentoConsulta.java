package med.voll.api.domain.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import med.voll.api.domain.medico.Especialidade;

public record DadosAgendamentoConsulta(@NotNull Long idPaciente, Long idMedico,
                                       @NotNull @Future LocalDateTime data,
                                       Especialidade especialidade) {}
