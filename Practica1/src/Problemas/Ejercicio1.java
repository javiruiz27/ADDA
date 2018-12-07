package Problemas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ejercicio1 {

	public static void main(String[] args) {
		System.out.println("Lista de divisores de n resuelto con while: " + divisoresWhile(3548946));
		System.out.println("Java 8: " + divisoresJ8(16));

	}

	// Dado un entrero n, obtener una lista con sus divisores.

	// While
	public static List<Integer> divisoresWhile(Integer n) {
		List<Integer> res = new ArrayList<>();
		Integer div = 2;
		res.add(1);

		while (1 < div && div < n) {
			if (n % div == 0) {
				res.add(div);
			}
			div++;
		}
		res.add(n);
		return res;
	}

	// Java 8

	public static List<Integer> divisoresJ8(Integer n) {

		IntStream a = IntStream.rangeClosed(1, n);
		return a.filter(x -> n % x == 0).boxed().collect(Collectors.toList());
	}

}
