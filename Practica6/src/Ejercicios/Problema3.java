package Ejercicios;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problema3 {

	/*
	 * Encontrar la raíz cuadrada de un número (la raíz cuadrada de un entero a es
	 * el mayor valor de un entero n tal que a≥n 2 ). (Java) (Iterativo, Recursivo y
	 * Funcional)
	 */

	public static void main(String[] args) {
		Integer n = 226;

		System.out.println("Resolución recursiva: " + raizRecFinal(n));
		System.out.println("Resolución iterativa: " + raizI(n));
		System.out.println("Resolución en Java 10: " + raizJava10(n));
	}

	public static Integer raizRecFinal(Integer a) {

		return raizRecFinal(a, 0, 0);
	}

	private static Integer raizRecFinal(Integer a, int r, int n) {
		int res = 0;
		if ((n * n) > a) {
			res = r;
		} else {
			res = raizRecFinal(a, n, n + 1);

		}
		return res;
	}

	public static Integer raizI(Integer a) {
		Integer res = 0;
		Integer n = 0;
		while (n * n <= a) {
			res = n;
			n = n + 1;
		}
		return res;
	}

	public static Integer raizJava10(Integer a) {
		List<Integer> ls = IntStream.rangeClosed(0, a).filter(n -> n * n <= a).boxed().collect(Collectors.toList());

		return ls.get(ls.get(ls.size() - 1));
	}

	public static Integer binario(Integer a) {
		Integer i = 1;
		Integer j = a;
		Integer r = 1;
		while (!(j - 1 <= 0)) {
			int n = (j - i) / 2;
			if (n * n <= a) {
				r = n;
				i = n + 1;
			} else {
				j = n;

			}

		}
		return r;

	}

}
