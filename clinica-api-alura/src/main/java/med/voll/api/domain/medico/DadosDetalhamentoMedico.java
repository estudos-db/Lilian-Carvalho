package med.voll.api.domain.medico;

import med.voll.api.domain.endereco.EnderecoJPA;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm,
                                      String telefone, Especialidade especialidade,
                                      EnderecoJPA enderecoJPA) {

	public DadosDetalhamentoMedico(MedicoJPA medicoJPA) {
		this(medicoJPA.getId(), medicoJPA.getNome(), medicoJPA.getEmail(), medicoJPA.getCrm(),
		     medicoJPA.getTelefone(), medicoJPA.getEspecialidade(), medicoJPA.getEndereco());
	}
}
