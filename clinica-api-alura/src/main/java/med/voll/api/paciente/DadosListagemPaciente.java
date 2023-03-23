package med.voll.api.paciente;

public record DadosListagemPaciente(Long id, String nome, String email, String cpg) {

	public DadosListagemPaciente(PacienteJPA pacienteJPA) {
		this(pacienteJPA.getId(), pacienteJPA.getNome(), pacienteJPA.getEmail(), pacienteJPA.getCpf());
	}
}
