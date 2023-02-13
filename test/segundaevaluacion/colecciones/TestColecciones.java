package segundaevaluacion.colecciones;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class TestColecciones {

	@Test
	void testEliminarLasDeLongitudPar() {
		Set<String> set = new HashSet<>(Set.of("aa", "bbb", "ccc", "dddd", "eeeee"));
		Colecciones.eliminarLasDeLongitudPar(set);
		assertEquals(Set.of("bbb", "ccc", "eeeee"), set);
		
		assertThrows(NullPointerException.class, () -> Colecciones.eliminarLasDeLongitudPar(null));
		
		set.clear();
		Colecciones.eliminarLasDeLongitudPar(set);
		assertEquals(0, set.size());
		
		set = new HashSet<>(Set.of("aa", "bbbb", "cccccc"));
		Colecciones.eliminarLasDeLongitudPar(set);
		assertEquals(0, set.size());
		
		set = new HashSet<>(Set.of("a", "bbb", "ccccc"));
		Colecciones.eliminarLasDeLongitudPar(set);
		assertEquals(Set.of("a", "bbb", "ccccc"), set);
	}


}
