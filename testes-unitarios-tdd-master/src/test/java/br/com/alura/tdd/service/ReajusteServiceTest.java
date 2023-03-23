package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReajusteServiceTest {

  private ReajusteService reajusteService;
  private Funcionario funcionario;

  @BeforeEach
  void init() {
    reajusteService = new ReajusteService();
    funcionario = new Funcionario("George", LocalDate.now(), new BigDecimal(1000.00));
  }

  @Test
  public void reajusteDeveriaSerDeTresPorCentoParaFuncionairoComDesempenhoADesejar() {
    reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);

    BigDecimal expect = new BigDecimal("1030.00");
    BigDecimal actual = funcionario.getSalario();

    assertEquals(expect, actual);
  }

  @Test
  public void reajusteDeveriaSerDeQuinzePorCentoParaFuncionairoComDesempenhoBom() {
    reajusteService.concederReajuste(funcionario, Desempenho.BOM);

    BigDecimal expect = new BigDecimal("1150.00");
    BigDecimal actual = funcionario.getSalario();

    assertEquals(expect, actual);
  }

  @Test
  public void reajusteDeveriaSerDeVintePorCentoParaFuncionairoComDesempenhoOtimo() {
    reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);

    BigDecimal expect = new BigDecimal("1200.00");
    BigDecimal actual = funcionario.getSalario();

    assertEquals(expect, actual);
  }


}
