package com.example.mentoriadb.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity @Table(name = "AUTOR") @NoArgsConstructor(access = AccessLevel.PROTECTED) @Getter public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotBlank
    @Column(name = "TXT_NOME")
    private String nome;

    @NotBlank
    @Size(min = 8, max = 9)
    @Column(name = "TXT_TELEFONE")
    private String telefone;

    @NotNull
    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    public Autor(String nome, String telefone, LocalDate dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

}
