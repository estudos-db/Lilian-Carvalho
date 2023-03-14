import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SuperSetTest {

    private static SuperSet superSet;
    private static Set<Integer> set;
    private static Set<Integer> setVazio;
    private static Set<Set<Integer>> setEsperado;
    private static Set<Set<Integer>> setEsperadoVazio;

    @BeforeAll
    static void init() {
        superSet = new SuperSet();
        set = new HashSet<Integer>(List.of(1, 2, 3));
        setVazio = new HashSet<Integer>();
        setEsperadoVazio = new HashSet<Set<Integer>>(List.of(Set.of()));
        setEsperado = new HashSet<Set<Integer>>(
                List.of(Set.of(), Set.of(1), Set.of(2), Set.of(3), Set.of(1, 2), Set.of(1, 3), Set.of(2, 3),
                        Set.of(1, 2, 3)));
    }

    @Test
    void gerarSuperSet() {
        assertEquals(setEsperado, superSet.gerarSuperSet(set));
    }

    @Test
    void gerarSuperSetVazioParaSetVazio() {
        assertEquals(setEsperadoVazio, superSet.gerarSuperSet(setVazio));
    }

}