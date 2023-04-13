package med.voll.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.time.LocalDateTime;
import med.voll.api.domain.consulta.AgendaDeConsultas;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.DadosDetalhamentoConsulta;
import med.voll.api.domain.medico.Especialidade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class ConsultaControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private JacksonTester<DadosAgendamentoConsulta> dadosAgendamentoConsultaJson;

	@Autowired
	private JacksonTester<DadosDetalhamentoConsulta> dadosDetalhamentoConsultaJson;

	@MockBean
	private AgendaDeConsultas agendaDeConsultas;

	@Test
	@DisplayName("Deveria devolver codigo HTTP 400 quando informações estão invalidas")
	@WithMockUser
	void agendarCenario1()
	throws Exception {
		var response = mockMvc.perform(post("/consultas")).andReturn().getResponse();

		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());


	}

	@Test
	@DisplayName("Deveria devolver codigo HTTP 200 quando informações estão validas")
	@WithMockUser
	void agendarCenario2()
	throws Exception {
		var data = LocalDateTime.now().plusHours(1);
		var especialidade = Especialidade.DEMARTOLOGIA;

		var dadosDetalhamento = new DadosDetalhamentoConsulta(null, 2l, 5l, data);

		when(agendaDeConsultas.agendar(any())).thenReturn(dadosDetalhamento);

		var response = mockMvc.perform(post("/consultas").contentType(MediaType.APPLICATION_JSON)
		                                                 .content(dadosAgendamentoConsultaJson.write(
				                                                                                      new DadosAgendamentoConsulta(2l, 5l, data,
				                                                                                                                   especialidade))
		                                                                                      .getJson()))
		                      .andReturn()
		                      .getResponse();

		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		var jsonEsperado = dadosDetalhamentoConsultaJson.write(dadosDetalhamento).getJson();

		Assertions.assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);


	}
}