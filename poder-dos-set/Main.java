
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>(List.of(1, 2, 3, 4, 5));
        SuperSet superSet = new SuperSet();

        System.out.println(superSet.gerarSuperSet(set));
    }
}