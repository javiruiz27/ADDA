package PI14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ejercicioo4 {

	public static void main(String[] args) {

		List<Integer> lista1 = new ArrayList<>();
		List<Integer> lista2 = new ArrayList<>();

		lista1.add(2);
		lista1.add(3);
		lista1.add(4);
		lista1.add(6);
		lista1.add(5);

		lista2.add(1);
		lista2.add(2);
		lista2.add(3);
		lista2.add(4);
		lista2.add(66);
		lista2.add(7);
		lista2.add(9);
		lista2.add(2);

//		Comparator<Integer> c = Comparator.naturalOrder();
//		lista1.sort(c);
//		lista2.sort(c);
		
		Collections.sort(lista1);
		Collections.sort(lista2);

		System.out.println("Iterativo: " + fusionaListas(lista1, lista2));
		System.out.println("Java 10: " + fusionaListasJ10(lista1, lista2));
		System.out.println("Recursivo final: " + fusionaListasRecFinal(lista1, lista2, 0, 0, new ArrayList<Integer>()));

	}

	private static String fusionaListas(List<Integer> lista1, List<Integer> lista2) {
		List<Integer> res = new ArrayList<>();
		Integer c1 = 0;
		Integer c2 = 0;
		while (c1 != lista1.size() || c2 != lista2.size()) {
			if (c1 == lista1.size()) {
				res.add(lista2.get(c2));
				c2++;
			} else if (c2 == lista2.size()) {
				res.add(lista1.get(c1));
				c1++;
			} else if (lista1.get(c1) > lista2.get(c2)) {
				res.add(lista2.get(c2));
				c2++;

			} else if (lista1.get(c1) == lista2.get(c2)) {
				res.add(lista1.get(c1));
				res.add(lista2.get(c2));
				c1++;
				c2++;

			} else if (lista1.get(c1) < lista2.get(c2)) {
				res.add(lista1.get(c1));
				c1++;
			}
		}

		return res.toString();
	}

	private static String fusionaListasRecFinal(List<Integer> lista1, List<Integer> lista2, int c1, int c2,
			List<Integer> acum) {
		if (c1 == lista1.size() && c2 == lista2.size()) {
			return acum.toString();
		} else {
			if (c1 == lista1.size()) {
				acum.add(lista2.get(c2));
				return fusionaListasRecFinal(lista1, lista2, c1, c2 + 1, acum);

			} else if (c2 == lista2.size()) {
				acum.add(lista1.get(c1));
				return fusionaListasRecFinal(lista1, lista2, c1 + 1, c2, acum);

			} else if (lista1.get(c1) > lista2.get(c2)) {
				acum.add(lista2.get(c2));
				return fusionaListasRecFinal(lista1, lista2, c1, c2 + 1, acum);

			} else if (lista1.get(c1) == lista2.get(c2)) {
				acum.add(lista1.get(c1));
				acum.add(lista2.get(c2));
				return fusionaListasRecFinal(lista1, lista2, c1 + 1, c2 + 1, acum);

			} else if (lista1.get(c1) < lista2.get(c2)) {
				acum.add(lista1.get(c1));
				return fusionaListasRecFinal(lista1, lista2, c1 + 1, c2, acum);

			}
			return acum.toString();

		}

	}

	private static String fusionaListasJ10(List<Integer> lista1, List<Integer> lista2) {
		List<Integer> res = Stream.concat(lista1.stream(), lista2.stream()).sorted().collect(Collectors.toList());
		return res.toString();
	}

}
