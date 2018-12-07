package E1;

import java.util.stream.Stream;

public class Ejercicio1 {

	/*
	 * Sea a un array de n elementos de tipo entero ordenados en orden estrictamente
	 * creciente. Encontrar un algoritmo de complejidad Θ(log n) en el caso peor,
	 * para determinar la posición i tal que a[i] = i. (Se supone que dicha posición
	 * existe)
	 */

	// La búsqueda binaria reduce la complejidad del algoritmo a log2N.
	// Ejemplo: Si n = 10 ---> Log2 10 = 4 iteraciones.

	public static void main(String[] args) {
		Integer[] numeros = { -1, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15 };
		System.out.println("Resolución iterativa: " + busquedaBinariaIt(numeros));
		System.out.println("Resolución recursiva: " + busquedaBinariaRec(numeros));
		System.out.println("Resolución funcional: " + busquedaBinariaF(numeros));
	}



	// Solución iterativa
	public static Integer busquedaBinariaIt(Integer[] numeros) {
		int i = 0;
		int j = numeros.length;
		int k = numeros.length / 2;
		while (numeros[k] != k && i != j) {
			System.out.println("i=" + i + "; j=" + j + "; k=" + k);
			if (numeros[k] > k) {
				j = k;
			} else {
				i = k + 1;
			}
			k = (i + j) / 2;
		}
		if (numeros[k] != k) {
			k = -1;
		}
		return k;
	}

	// Solución recursiva
	public static Integer busquedaBinariaRec(Integer[] numeros) {
		return busquedaBinariaRec(numeros, 0, numeros.length, numeros.length / 2);
	}

	private static Integer busquedaBinariaRec(Integer[] numeros, int i, int j, int k) {
		if (numeros[k] == k) {
			return k;
		} else if (i == j) {
			return -1;
		} else {
			if (numeros[k] > k) {
				return busquedaBinariaRec(numeros, i, k, (i + k) / 2);
			} else {
				return busquedaBinariaRec(numeros, k + 1, j, (k + 1 + j) / 2);
			}
		}

	}

	// Solución en Java 10
	
	private static class Tupla {
		public int i, j, k;

		public Tupla(int a, int b, int c) {
			i = a;
			j = b;
			k = c;
		};
	}

	public static Integer busquedaBinariaF(Integer[] numeros) {
		Integer maxPasos = 1 + (int) (Math.log(numeros.length) / Math.log(2));
		Tupla semilla = new Tupla(0, numeros.length, numeros.length / 2);
		return Stream.iterate(semilla, tupla -> siguiente(tupla, numeros)).limit(maxPasos)
				.dropWhile(t -> t.k != numeros[t.k]).findFirst().orElse(new Tupla(0,0,-1)).k;
	}

	private static Tupla siguiente(Tupla t, Integer[] numeros) {
		if (numeros[t.k] > t.k) {
			return new Tupla(t.i, t.k, (t.i + t.k) / 2);
		} else {
			return new Tupla(t.k + 1, t.j, (t.k + 1 + t.j) / 2);
		}

	}

}
