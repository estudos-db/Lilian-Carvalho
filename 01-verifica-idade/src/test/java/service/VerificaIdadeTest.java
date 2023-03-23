package service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.Pessoa;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class VerificaIdadeTest {

  private static Pessoa pessoaMenorDeIdade;
  private static Pessoa pessoaMaiorDeIdade;
  private static Pessoa pessoaDezoitoAnos;

  @BeforeAll
  static void init() {
    pessoaMenorDeIdade = new Pessoa(15);
    pessoaMaiorDeIdade = new Pessoa(25);
    pessoaDezoitoAnos = new Pessoa(18);

  }

  @Test
  void deveRetornarFalseCasoAPessoaSejaMenorDeIdade() {
    assertFalse(VerificaIdade.verificaMaioridade(pessoaMenorDeIdade.getIdade()));
  }

  @Test
  void deveRetornarTrueCasoAPessoaSejaMaiorDeIdade() {
    assertTrue(VerificaIdade.verificaMaioridade(pessoaMaiorDeIdade.getIdade()));
  }

  @Test
  void deveRetornarTrueCasoAPessoaTenha18Anos() {
    assertTrue(VerificaIdade.verificaMaioridade(pessoaDezoitoAnos.getIdade()));
  }
}