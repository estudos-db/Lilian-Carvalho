package med.voll.api.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface
public interface MedicoRepository extends JpaRepository<MedicoJPA, Long> {

	Page<MedicoJPA> findAllByAtivoTrue(Pageable paginacao);
}
