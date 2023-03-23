package com.example.mentoriadb.application.api;

import com.example.mentoriadb.application.dto.AutorRequest;
import com.example.mentoriadb.application.service.IAutorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController public class AutorController {

    private final IAutorService autorService;

    public AutorController(IAutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping("v1/autores")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAutor(@RequestBody @Valid AutorRequest autorRequest) {
        this.autorService.criarAutor(autorRequest);
    }

}
