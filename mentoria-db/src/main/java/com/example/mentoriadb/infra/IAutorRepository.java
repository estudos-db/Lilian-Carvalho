package com.example.mentoriadb.infra;

import com.example.mentoriadb.application.dto.AutorResponse;
import com.example.mentoriadb.domain.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IAutorRepository extends JpaRepository<Autor, Long> {
    List<AutorResponse> findAllByNome(String nome);


}

