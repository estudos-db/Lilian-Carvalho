package com.example.mentoriadb.application.service;

import com.example.mentoriadb.application.dto.AutorRequest;
import com.example.mentoriadb.application.dto.AutorResponse;
import com.example.mentoriadb.domain.models.Autor;
import com.example.mentoriadb.infra.IAutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service public class AutorService implements IAutorService {

    private final IAutorRepository autorRepository;

    public AutorService(IAutorRepository autorRepository) {this.autorRepository = autorRepository;}

    @Override
    public void criarAutor(AutorRequest autorRequest) {
        Autor autor = new Autor(autorRequest.nome, autorRequest.telefone, autorRequest.dataNascimento);
        this.autorRepository.save(autor);
    }

    @Override
    public List<AutorResponse> obterAutorPorNome(String nome) {
        return this.autorRepository.findAllByNome(nome);
    }


}
