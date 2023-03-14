import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ElementosTest {

	private static Elementos elementosTestTrue;
	private static Elementos elementosTestFalse;

	@BeforeAll
	static void init() {
		Set<Integer> testTrue = new HashSet<>();
		testTrue.add(11);
		testTrue.add(2);
		testTrue.add(23);
		testTrue.add(5);

		elementosTestTrue = new Elementos(testTrue, 7);

		Set<Integer> testFalse = new HashSet<>();
		testFalse.add(11);
		testFalse.add(2);
		testFalse.add(23);
		testFalse.add(5);

		elementosTestFalse = new Elementos(testFalse, 17);
	}

	@Test
	void DeveRetornarTrueCasoAlgumaSomaEntreDoisElementosDoArraySejaOValorEsperado() {
		assertTrue(elementosTestTrue.verifica());
	}

	@Test
	void DeveRetornarFalseCasoNenhumaSomaEntreDoisElementosDoArraySejaOValorEsperado() {
		assertFalse(elementosTestFalse.verifica());
	}


}
