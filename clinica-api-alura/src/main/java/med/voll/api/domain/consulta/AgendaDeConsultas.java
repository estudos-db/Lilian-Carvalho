package med.voll.api.domain.consulta;

import java.util.List;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.medico.MedicoJPA;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {

	@Autowired
	private ConsultaRepository consultaRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private List<ValidadorAgendamentoDeConsulta> validadores;

	public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
		if (!pacienteRepository.existsById(dadosAgendamentoConsulta.idPaciente())) {
			throw new ValidacaoException("ID do paciente informado não existe!");
		}

		if (dadosAgendamentoConsulta.idMedico() != null && !medicoRepository.existsById(
				dadosAgendamentoConsulta.idMedico())) {
			throw new ValidacaoException("ID do médico informado não existe!");
		}

		validadores.forEach(validador -> validador.validar(dadosAgendamentoConsulta));

		var paciente = pacienteRepository.getReferenceById(dadosAgendamentoConsulta.idPaciente());
		var medico = escolherMedico(dadosAgendamentoConsulta);
		if (medico == null) {
			throw new ValidacaoException("Não existe medico disponivel nessa data!");
		}
		var consulta = new ConsultaJPA(null, medico, paciente, dadosAgendamentoConsulta.data());

		consultaRepository.save(consulta);

		return new DadosDetalhamentoConsulta(consulta);
	}

	private MedicoJPA escolherMedico(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
		if (dadosAgendamentoConsulta.idMedico() != null) {
			return medicoRepository.getReferenceById(dadosAgendamentoConsulta.idMedico());
		}

		if (dadosAgendamentoConsulta.especialidade() == null) {
			throw new ValidacaoException("Especialidade é obrigatória quando medico não for escolhido!");
		}
		return medicoRepository.escolherMedicoAleatorioLivreNaData(
				dadosAgendamentoConsulta.especialidade(), dadosAgendamentoConsulta.data());
	}
}
