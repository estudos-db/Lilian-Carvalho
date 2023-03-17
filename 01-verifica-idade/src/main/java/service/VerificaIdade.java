package service;

public class VerificaIdade {

  public static boolean verificaMaioridade(int idade) {
    final int idadeMinima = 18;
    if (idade >= idadeMinima) {
      return true;
    } else {
      return false;
    }
  }
}
