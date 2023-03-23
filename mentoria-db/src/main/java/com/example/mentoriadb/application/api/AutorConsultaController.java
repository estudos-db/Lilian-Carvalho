package com.example.mentoriadb.application.api;

import com.example.mentoriadb.application.dto.AutorResponse;
import com.example.mentoriadb.application.service.IAutorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController public class AutorConsultaController {

    private final IAutorService autorService;

    public AutorConsultaController(IAutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("v1/autores")
    @ResponseStatus(HttpStatus.OK)
    public List<AutorResponse> obterAutorPorNome(@RequestParam String nome) {
        return this.autorService.obterAutorPorNome(nome);
    }

}
