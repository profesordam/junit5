package segundaevaluacion.colecciones;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Colecciones {

	public static void main(String[] args) {
		System.out.println("prueba eliminar las de longitud par");
		Set<String> set1 = Set.of("aa", "bbb", "ccc", "dddd", "eeeee");
		Set<String> set2 = new HashSet<>(set1);
		eliminarLasDeLongitudPar(set2);
		System.out.println(set2);
		
		System.out.println("Prueba contiene impares");
		System.out.println(contieneImpares(Set.of(1, 2, 3, 4, 5, 6)));
		System.out.println(contieneImpares(Set.of(2,  4, 6)));
		
		System.out.println("prueba negativos abajo positivos arriba");
		Deque<Integer> pila = new ArrayDeque<>();
		List.of(3, 1, -5, 4, -2, 7).forEach(n -> pila.push(n));
		System.out.println(pila);
		negativosAbajoPositivosArriba(pila);
		System.out.println(pila);
				
		System.out.println("prueba eliminar si mayores encima");
		pila.clear();
		pila.addAll(List.of(2, 7, 12, 5, 14, 9, 7, 10, 17, 17, 22, 6));
		System.out.println(pila);
		eliminarSiMayoresEncima(pila);
		System.out.println(pila);
		
		System.out.println("prueba duplicar");
		pila.clear();
		pila.addAll(List.of(5, 9, 2, 6, 7));
		System.out.println(pila);
		duplicar(pila);
		System.out.println(pila);
		
		System.out.println("prueba colapsar pares");
		pila.clear();
		pila.addAll(List.of(2, 13, -42, 21, 4, 9, 14, -3, 11, 5));
		System.out.println(pila);
		colapsar(pila);
		System.out.println(pila);
		
		System.out.println("prueba colapsar impares");
		pila.clear();
		pila.addAll(List.of(2, 13, -42, 21, 4, 9, 14, -3, 11));
		System.out.println(pila);
		colapsar(pila);
		System.out.println(pila);
	}
	
	/*
	 * Método llamado eliminarLasDeLongitudPar que acepte un conjunto de cadenas y elimine del
	 * mismo todas aquellas cadenas de una longitud par.
	 * No se permite el uso de ninguna otra estructura de datos auxiliar.
	 */

	static void eliminarLasDeLongitudPar(Set<String> set) {
//		Iterator<String> i = set.iterator();
//		while (i.hasNext()) {
//			if (i.next().length() % 2 == 0)
//				i.remove();
//		}
		
		set.removeIf(s -> s.length() % 2 == 0);
	}
	
	/*
	 * Método llamado contieneImpares que acepte un conjunto de números enteros y retorne true si
	 * contiene al menos un número impar o false en caso contrario.
	 */
	
	static boolean contieneImpares(Set<Integer> set) {
//		for (int n: set)
//			if (n % 2 == 1)
//				return true;
//		return false;
		
		return set.stream().anyMatch(n -> n % 2 == 1);
	}
	
	/*
	 * Método llamado valoresUnicos que acepte un mapa de cadenas a cadenas y retorne false si dos
	 * o más claves se asocian a un mismo valor o true en caso contrario.
	 */
	
	static boolean valoresUnicos(Map<String, String> map) {
		return new HashSet<>(map.values()).size() != map.values().size();
	}
	
	static boolean valoresUnicos2(Map<String, String> map) {
		return map.values().stream().distinct().count() != map.values().size();
	}
	
	/*
	 * Método llamado algunaSeRepiteAlMenos3Veces que acepte una lista de cadenas como parámetro
	 * y retornoe verdadero si alguna cadena se repite al menos 3 veces en la lista o falso en caso
	 * contrario.
	 * Resolver el problema utilizando un mapa como almacenamiento auxiliar.
	 */
	
	static boolean algunaSeRepiteAlMenos3Veces(List<String> list) {
		
		return false;
	}
	
	/*
	 * Método llamado negativosAbajoPositivosArriba que acepte una pila de números enteros como
	 * parámetro y la reorganice para que se queden debajo los negativos y encima los positivos.
	 * Usa una cola como estructura de datos auxiliar para realizar el proceso.
	 */
	
	static void negativosAbajoPositivosArriba(Deque<Integer> pila) {
//		Deque<Integer> colaPos = new LinkedList<>();
//		Deque<Integer> colaNeg = new LinkedList<>();
//		while (!pila.isEmpty()) {
//			int n = pila.pop();
//			if (n < 0)
//				colaNeg.push(n);
//			else
//				colaPos.push(n);
//		}
//		
//		while (!colaNeg.isEmpty())
//			pila.push(colaNeg.pop());
//		while (!colaPos.isEmpty())
//			pila.push(colaPos.pop());
		
		Queue<Integer> cola = new LinkedList<>();
		while (!pila.isEmpty())
			cola.offer(pila.pop());

		int n = cola.size();
		for (int i=0; i<n; i++) {
			int numero = cola.poll();
			if (numero >= 0)
				cola.offer(numero);
			else
				pila.push(numero);
		}
		while (!cola.isEmpty())
			pila.push(cola.poll());
	}
	
	static void eliminarSiMayoresEncima(Deque<Integer> stack) {
		Deque<Integer> aux = new ArrayDeque<>();
		aux.push(stack.pop());
		while (!stack.isEmpty()) {
			int n = stack.pop();
			if (n > aux.peek())
				aux.push(n);
		}
		while (!aux.isEmpty())
			stack.push(aux.pop());
	}
	
	static void duplicar(Deque<Integer> pila) {
		Deque<Integer> aux = new ArrayDeque<>();
		while (!pila.isEmpty()) {
			aux.push(pila.peek());
			aux.push(pila.pop());
		}
		while (!aux.isEmpty())
			pila.push(aux.pop());
	}
	
	static void colapsar(Deque<Integer> pila) {
		Deque<Integer> aux = new ArrayDeque<>();
		while (!pila.isEmpty()) {
			int n = pila.pop();
			if (pila.isEmpty())
				aux.push(n);
			else
				aux.push(n + pila.pop());
		}
		while (!aux.isEmpty())
			pila.push(aux.pop());
	}
	
}
