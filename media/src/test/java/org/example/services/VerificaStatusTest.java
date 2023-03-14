package org.example.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VerificaStatusTest {

	private static String verificaStatusMediaAprovado;
	private static String verificaStatusMediaReprovado;
	private static String verificaStatusMediaSuplementar;

	@BeforeEach
	void init() {
		verificaStatusMediaAprovado = VerificaStatus.verificarStatusDoAluno(6.43);
		verificaStatusMediaReprovado = VerificaStatus.verificarStatusDoAluno(2.34);
		verificaStatusMediaSuplementar = VerificaStatus.verificarStatusDoAluno(4.14);
	}

	@Test
	void DeveVerificarStatusDoAlunoDeAcordoComSuaMedia() {
		assertEquals("Aprovado", verificaStatusMediaAprovado);
		assertEquals("Reprovado", verificaStatusMediaReprovado);
		assertEquals("Verificação Suplementar", verificaStatusMediaSuplementar);
	}
}