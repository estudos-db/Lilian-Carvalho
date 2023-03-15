package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.DadosCadastroMedicoDTO;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.MedicoJPA;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository medicoRepository;

	@PostMapping
	@Transactional
	public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedicoDTO dadosCadastroMedicoDTO) {
		medicoRepository.save(new MedicoJPA(dadosCadastroMedicoDTO));
	}

	@GetMapping
	public Page<DadosListagemMedico> listarMedicos(
			@PageableDefault(size = 5, sort = "nome", direction = Direction.ASC) Pageable paginacao) {
		return medicoRepository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
	}

	@PutMapping
	@Transactional
	public void atualizarCadastroMedico(
			@RequestBody @Valid DadosAtualizacaoMedico dadosAtualizacaoMedico) {
		MedicoJPA medico = medicoRepository.getReferenceById(dadosAtualizacaoMedico.id());
		medico.atualizarInformacoes(dadosAtualizacaoMedico);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void desativarCadastro(@PathVariable Long id) {
		MedicoJPA medicoJPA = medicoRepository.getReferenceById(id);
		medicoJPA.desativarCadastro();
	}

}


