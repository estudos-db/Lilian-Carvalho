package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoJPA {

	private String logradouro;
	private String bairro;
	private String cep;
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;

	public EnderecoJPA(DadosEnderecoDTO dadosEnderecoDTO) {
		this.logradouro = dadosEnderecoDTO.logradouro();
		this.bairro = dadosEnderecoDTO.bairro();
		this.cep = dadosEnderecoDTO.cep();
		this.uf = dadosEnderecoDTO.uf();
		this.cidade = dadosEnderecoDTO.cidade();
		this.numero = dadosEnderecoDTO.numero();
		this.complemento = dadosEnderecoDTO.complemento();
	}

	public void atualizarInformacoes(DadosEnderecoDTO endereco) {
		if (endereco.logradouro() != null) {
			this.logradouro = endereco.logradouro();
		}
		if (endereco.bairro() != null) {
			this.bairro = endereco.bairro();
		}
		if (endereco.cep() != null) {
			this.cep = endereco.cep();
		}
		if (endereco.uf() != null) {
			this.uf = endereco.uf();
		}
		if (endereco.cidade() != null) {
			this.cidade = endereco.cidade();
		}
		if (endereco.numero() != null) {
			this.numero = endereco.numero();
		}
		if (endereco.complemento() != null) {
			this.complemento = endereco.complemento();
		}
	}
}
