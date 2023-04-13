package med.voll.api.domain.medico;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import med.voll.api.domain.consulta.ConsultaJPA;
import med.voll.api.domain.endereco.DadosEnderecoDTO;
import med.voll.api.domain.paciente.DadosPacienteDTO;
import med.voll.api.domain.paciente.PacienteJPA;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {

	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	@DisplayName(
			"Deveria devolver null quando o único medico cadastrado não está disponível na " + "data")
	void escolherMedicoAleatorioLivreNaDataCenario1() {
		var proximaSegunda = LocalDate.now()
		                              .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
		                              .atTime(10, 0);
		var medico = cadastrarMedico("Medico 1", "medico1@email.com", "145278",
		                             Especialidade.CARDIOLOGIA);
		var paciente = cadastrarPaciente("Paciente 1", "paciente1@email.com", "102578925878");
		agendarConsulta(medico, paciente, proximaSegunda);
		var medicoLivre =
				medicoRepository.escolherMedicoAleatorioLivreNaData(Especialidade.CARDIOLOGIA,
		                                                                      proximaSegunda);

		Assertions.assertThat(medicoLivre).isNull();
	}

	@Test
	@DisplayName("Deveria devolver medico quando ele estiver disponivel na data")
	void escolherMedicoAleatorioLivreNaDataCenario2() {
		var proximaSegunda = LocalDate.now()
		                              .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
		                              .atTime(10, 0);
		var medico = cadastrarMedico("Medico 1", "medico1@email.com", "145278",
		                             Especialidade.CARDIOLOGIA);
		var medicoLivre =
				medicoRepository.escolherMedicoAleatorioLivreNaData(Especialidade.CARDIOLOGIA,
		                                                                      proximaSegunda);

		Assertions.assertThat(medicoLivre).isEqualTo(medico);
	}

	private void agendarConsulta(MedicoJPA medico, PacienteJPA paciente, LocalDateTime data) {
		testEntityManager.persist(new ConsultaJPA(null, medico, paciente, data));
	}

	private MedicoJPA cadastrarMedico(String nome, String email, String crm,
	                                  Especialidade especialidade) {
		var medico = new MedicoJPA(dadosCadastroMedico(nome, email, crm, especialidade));
		testEntityManager.persist(medico);
		return medico;
	}

	private PacienteJPA cadastrarPaciente(String nome, String email, String cpf) {
		var paciente = new PacienteJPA(dadosPaciente(nome, email, cpf));
		testEntityManager.persist(paciente);
		return paciente;
	}

	private DadosCadastroMedicoDTO dadosCadastroMedico(String nome, String email, String crm,
	                                                   Especialidade especialidade) {
		return new DadosCadastroMedicoDTO(nome, email, "8955552222", crm, especialidade,
		                                  dadosEndereco());
	}

	private DadosPacienteDTO dadosPaciente(String nome, String email, String cpf) {
		return new DadosPacienteDTO(nome, email, "6588441122", cpf, dadosEndereco());
	}

	private DadosEnderecoDTO dadosEndereco() {
		return new DadosEnderecoDTO("Rua 01", "Centro", "25896321", "Cidade 01", "NL", null, null);
	}
}