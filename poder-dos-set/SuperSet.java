import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SuperSet {
    public static <T> Set<Set<T>> gerarSuperSet(Set<T> setInicial) {
        Set<Set<T>> sets = new HashSet<Set<T>>();

        if (setInicial.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }

        List<T> list = new ArrayList<T>(setInicial);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size()));

        for (Set<T> set : gerarSuperSet(rest)) {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }

        return sets;
    }

}