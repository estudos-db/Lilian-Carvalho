import java.util.ArrayList;


public class CalculoProduto {

    public static ArrayList<Integer> calcularProdutos(ArrayList<Integer> arrayNumeros) {
        ArrayList<Integer> produtosCalculados = new ArrayList<>();

        arrayNumeros.forEach(numero -> produtosCalculados.add(arrayNumeros.stream().reduce(1, (a, b) -> a * b) / numero));
        return produtosCalculados;
    }

}
