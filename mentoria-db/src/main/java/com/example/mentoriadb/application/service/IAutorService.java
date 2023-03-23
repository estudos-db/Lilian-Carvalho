package com.example.mentoriadb.application.service;

import com.example.mentoriadb.application.dto.AutorRequest;
import com.example.mentoriadb.application.dto.AutorResponse;

import java.util.List;
public interface IAutorService {

    void criarAutor(AutorRequest autorRequest);

    List<AutorResponse> obterAutorPorNome(String nome);

}
