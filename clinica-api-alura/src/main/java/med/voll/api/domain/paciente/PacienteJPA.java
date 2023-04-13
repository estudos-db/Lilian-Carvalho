package med.voll.api.domain.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.EnderecoJPA;

//Classe de entidade; que sera persistida no banco de dados

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PacienteJPA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean ativo;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	@Embedded
	private EnderecoJPA endereco;

	public PacienteJPA(DadosPacienteDTO dadosPacienteDTO) {
		this.ativo = true;
		this.nome = dadosPacienteDTO.nome();
		this.email = dadosPacienteDTO.email();
		this.telefone = dadosPacienteDTO.telefone();
		this.cpf = dadosPacienteDTO.cpf();
		this.endereco = new EnderecoJPA(dadosPacienteDTO.endereco());
	}

	public void atualizarInformacoes(DadosAtualizacaoPaciente dadosAtualizacaoPaciente) {
		if (dadosAtualizacaoPaciente.nome() != null) {
			this.nome = dadosAtualizacaoPaciente.nome();
		}
		if (dadosAtualizacaoPaciente.telefone() != null) {
			this.telefone = dadosAtualizacaoPaciente.telefone();
		}
		if (dadosAtualizacaoPaciente.endereco() != null) {
			this.endereco.atualizarInformacoes(dadosAtualizacaoPaciente.endereco());
		}
	}

	public void desativarCadastro() {
		this.ativo = false;
	}
}
