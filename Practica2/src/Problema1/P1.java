package Problema1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1 {

	/*
	 * P1 - (EJ 60): Generar la lista de los cuadrados de los números primos hasta
	 * un número dado.
	 */

	public static void main(String[] args) {

		System.out.println("Solución con iterativa: " + cuadradoPrimosWhile(5));
		System.out.println("Solución con Java 10: " + cuadradoPrimosJ10(5));
		System.out.println("Solución recursiva final: " + cuadradoPrimosRec(5));

	}

	public static List<Integer> cuadradoPrimosRec(Integer n) {

		return cuadradoPrimosRecFinal(1, n, new ArrayList<Integer>());
	}

	private static List<Integer> cuadradoPrimosRecFinal(int i, Integer n, ArrayList<Integer> lista) {
		if (i > n) {
			return lista;
		} else {
			if (esPrimo(i)) {
				lista.add(i * i);
			}
			cuadradoPrimosRecFinal(i + 1, n, lista);
			return lista;
		}

	}

	public static List<Integer> cuadradoPrimosJ10(Integer i) {

		List<Integer> res = IntStream.rangeClosed(1, i).filter(x -> esPrimo2(x)).boxed().map(x -> x * x)
				.collect(Collectors.toList());
		return res;
	}

	public static List<Integer> cuadradoPrimosWhile(Integer i) {
		List<Integer> res = new ArrayList<>();

		Integer contador = 1;
		while (contador <= i) {
			if (esPrimo(contador)) {
				res.add(contador * contador);

			}
			contador++;
		}
		return res;
	}

	private static Boolean esPrimo2(Integer n) {
		Integer sqrt = (int) Math.sqrt((double) n);
		return IntStream.rangeClosed(2, sqrt).allMatch(x -> n % x != 0);
	}

	private static Boolean esPrimo(Integer contador) {
		Boolean res = true;
		Integer i = 2;
		while (i < contador) {
			if (contador % i == 0) {
				res = false;
				break;
			}
			i++;
		}

		return res;
	}

}
