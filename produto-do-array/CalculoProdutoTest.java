import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculoProdutoTest {

  private static ArrayList<Integer> arrayNumeros;
  private static ArrayList<Integer> arrayNumerosExpect;
  private static ArrayList<Integer> calculoProduto;
  private static ArrayList<Integer> produtoDoArrayVazio;

  @BeforeAll
  static void init() {
    arrayNumeros = new ArrayList<>(List.of(1, 2, 3, 4, 5));
    arrayNumerosExpect = new ArrayList<>(List.of(120, 60, 40, 30, 24));
    calculoProduto = CalculoProduto.calcularProdutos(arrayNumeros);
    produtoDoArrayVazio = CalculoProduto.calcularProdutos(new ArrayList<>());
  }

  @Test
  void deveCalcularProdutoDosValoresDoArray() {
    assertNotNull(calculoProduto);
    assertEquals(arrayNumerosExpect, calculoProduto);
  }

  @Test
  void deveRetornarUmArrayVazioCasoOArrayPassadoComoParametroSejaVazio() {
    assertEquals(new ArrayList<>(), produtoDoArrayVazio);
  }

}