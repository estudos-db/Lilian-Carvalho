package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.alura.tdd.modelo.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BonusServiceTest {

  private BonusService bonusService;
  private Funcionario funcionarioSalarioMaior;
  private Funcionario funcionarioSalario1000;
  private Funcionario funcionarioSalarioMenor;

  @BeforeEach
  void init() {
    bonusService = new BonusService();
    funcionarioSalarioMaior = new Funcionario("Lilian", LocalDate.now(), new BigDecimal(13000));
    funcionarioSalario1000 = new Funcionario("Rogerio", LocalDate.now(), new BigDecimal(10000));
    funcionarioSalarioMenor = new Funcionario("Marcio", LocalDate.now(), new BigDecimal(1300));

  }

  @Test
  void deveriaRetornarUmaExceçãoParaFuncionarioComSalarioMaiorQue10000() {
    assertThrows(IllegalArgumentException.class,
        () -> bonusService.calcularBonus(funcionarioSalarioMaior));
  }

  @Test
  void bonusDeveriaSerDeDezPorCentoDoSalario() {
    BigDecimal expect = new BigDecimal("130.00");
    BigDecimal actual = bonusService.calcularBonus(funcionarioSalarioMenor);

    assertEquals(expect, actual);
  }

  @Test
  void bonusDeveriaSerDe1000ParaSalarioDe10000() {
    BigDecimal expect = new BigDecimal("1000.00");
    BigDecimal actual = bonusService.calcularBonus(funcionarioSalario1000);

    assertEquals(expect, actual);
  }
}