package med.voll.api.domain.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.endereco.EnderecoJPA;

// Entidade JPA: Java Persistence API, usada para
@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoJPA {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Boolean ativo;
	private String nome;
	private String email;
	private String telefone;
	private String crm;
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	@Embedded
	private EnderecoJPA endereco;

	public MedicoJPA(DadosCadastroMedicoDTO dadosCadastroMedicoDTO) {
		this.ativo = true;
		this.nome = dadosCadastroMedicoDTO.nome();
		this.email = dadosCadastroMedicoDTO.email();
		this.telefone = dadosCadastroMedicoDTO.telefone();
		this.crm = dadosCadastroMedicoDTO.crm();
		this.especialidade = dadosCadastroMedicoDTO.especialidade();
		this.endereco = new EnderecoJPA(dadosCadastroMedicoDTO.endereco());
	}

	public void atualizarInformacoes(DadosAtualizacaoMedico dadosAtualizacaoMedico) {
		if (dadosAtualizacaoMedico.nome() != null) {
			this.nome = dadosAtualizacaoMedico.nome();
		}
		if (dadosAtualizacaoMedico.telefone() != null) {
			this.telefone = dadosAtualizacaoMedico.telefone();
		}
		if (dadosAtualizacaoMedico.endereco() != null) {
			this.endereco.atualizarInformacoes(dadosAtualizacaoMedico.endereco());
		}
	}

	public void desativarCadastro() {
		this.ativo = false;
	}
}
