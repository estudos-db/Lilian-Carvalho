package com.example.mentoriadb.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor public class AutorRequest {

    @NotBlank
    public String nome;

    @NotBlank
    @Size(min = 8, max = 9)
    public String telefone;

    @NotNull
    public LocalDate dataNascimento;

}
