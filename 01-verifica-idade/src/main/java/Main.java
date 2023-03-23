import model.Pessoa;
import service.VerificaIdade;

public class Main {

  public static void main(String[] args) {

    Pessoa pessoa = new Pessoa(18);
    Pessoa pessoa1 = new Pessoa(8);
    Pessoa pessoa2 = new Pessoa(28);

    System.out.println(VerificaIdade.verificaMaioridade(pessoa.getIdade()));
    System.out.println(VerificaIdade.verificaMaioridade(pessoa1.getIdade()));
    System.out.println(VerificaIdade.verificaMaioridade(pessoa2.getIdade()));

  }
}
