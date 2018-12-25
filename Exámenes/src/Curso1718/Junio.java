package Curso1718;

import java.util.ArrayList;
import java.util.List;

public class Junio {

	/*
	 * - Implemente el algoritmo recursivo no final en base a la definición
	 * anterior. - Transforme el algoritmo a recursivo final, dando la definición y
	 * la implementación. - Implemente la versión iterativa del algoritmo recursivo
	 * final.
	 */

	public static void main(String[] args) {

		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(4);
		lista.add(8);

		System.out.println("Solución recursiva no final: " + esProgGeoRecNoFinal(lista));
		System.out.println("Solución iterativa: " + esProgGeoIt(lista));

	}

	public static Boolean esProgGeoIt(List<Integer> lista) {
		Boolean res = false;
		if(lista.size()<2) {
			res = false;
		}else {
			Boolean ac = true;
			Integer r = lista.get(1)/lista.get(0);
			Integer i = lista.size()-1;
			while(i>1) {
				ac = ac && (lista.get(i) == lista.get(i-1)*r);
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

}
