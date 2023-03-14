import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> arrayNumeros =  new ArrayList<>(List.of(1, 2, 3, 4, 5));

        ArrayList<Integer> calculoProduto =  CalculoProduto.calcularProdutos(arrayNumeros);
        System.out.println(calculoProduto);
    }
}
