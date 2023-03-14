import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numeros = new HashSet<>();
        numeros.add(1);
        numeros.add(85);
        numeros.add(5);
        numeros.add(21);
        numeros.add(4);
        numeros.add(13);
        int valorEsperado = 9;

        Elementos elementos = new Elementos(numeros, valorEsperado);
        System.out.println(elementos.verifica());

    }
}
