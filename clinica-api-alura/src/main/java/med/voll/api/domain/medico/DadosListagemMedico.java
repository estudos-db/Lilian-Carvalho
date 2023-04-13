package med.voll.api.domain.medico;

public record DadosListagemMedico(Long id, String nome, String email, String crm,
                                  Especialidade especialidade) {

	public DadosListagemMedico(MedicoJPA medicoJPA) {
		this(medicoJPA.getId(), medicoJPA.getNome(), medicoJPA.getEmail(), medicoJPA.getCrm(),
		     medicoJPA.getEspecialidade());
	}
}
