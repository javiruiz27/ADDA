package Curso1718;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Junio {

	/*
	 * - Implemente el algoritmo recursivo no final en base a la definición
	 * anterior. - Transforme el algoritmo a recursivo final, dando la definición y
	 * la implementación. - Implemente la versión iterativa del algoritmo recursivo
	 * final.
	 */

	public static void main(String[] args) {

//		List<Integer> lista = new ArrayList<>();
//		lista.add(1);
//		lista.add(2);
//		lista.add(4);
//		lista.add(8);
//
//		System.out.println("Solución recursiva no final: " + esProgGeoRecNoFinal(lista));
//		System.out.println("Solución iterativa: " + esProgGeoIt(lista));
//		

		System.out.println(9/2);
		
		

	}

	public static Boolean esProgGeoIt(List<Integer> lista) {
		Boolean res = false;
		if (lista.size() < 2) {
			res = false;
		} else {
			Boolean ac = true;
			Integer r = lista.get(1) / lista.get(0);
			Integer i = lista.size() - 1;
			while (i > 1) {
				ac = ac && (lista.get(i) == lista.get(i - 1) * r);
				i--;
			}
			res = ac;

		}
		return res;
	}

	// Resolución iterativa no final

	public static Boolean esProgGeoRecNoFinal(List<Integer> l) {
		Boolean res;
		if (l.size() < 2) {
			res = false;
		} else {
			res = pg(l, l.get(1) / l.get(0));
		}
		return res;
	}

	private static Boolean pg(List<Integer> l, int r) {

		return pgi(l, r, l.size() - 1);
	}

	private static Boolean pgi(List<Integer> l, int r, int i) {
		Boolean res = true;
		if (i == 1) {
			res = true;
		} else {
			return pgi(l, r, i - 1) && (l.get(i) == l.get(i - 1) * r);
		}

		return res;
	}

	/*
	 * Sea una secuencia de elementos que forma una bandera portuguesa, es decir,
	 * los primeros elementos (consecutivos) cumplen una propiedad (color verde) y
	 * los restantes (consecutivos) cumplen la propiedad complementaria (color
	 * rojo). Se desea obtener la posición r del primer elemento en la secuencia dt
	 * (de tamaño N) que cumple la propiedad complementaria (el primer elemento de
	 * color rojo). (Si todos los elementos son verdes, ? = ? y si todos son rojos,
	 * ? = 0) Se desea diseñar un algoritmo de Divide y Vencerás que obtenga dicha
	 * posición en un tiempo logarítmico
	 */

	public static <T> int fronteraBanderaPortuguesa(List<T> dt, Predicate<T> p) {
		return fbp(dt, p, 0, dt.size());
	}

	private static <T> int fbp(List<T> dt, Predicate<T> p, int i, int j) {
		int r;
		if (i == j)
			r = i;
		else {
			int m = (i + j) / 2;
			if (p.test(dt.get(m)))
				r = fbp(dt, p, m + 1, j);
			else
				r = fbp(dt, p, i, m);
		}
		return r;
	}

}
