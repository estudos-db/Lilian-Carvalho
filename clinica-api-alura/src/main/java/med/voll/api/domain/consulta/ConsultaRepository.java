package med.voll.api.domain.consulta;

import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<ConsultaJPA, Long> {

	boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

	boolean existsByPacienteIdAndDataBetween(Long idPaciente, LocalDateTime primeiroHorario,
	                                         LocalDateTime ultimoHorario);
}
