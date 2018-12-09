package Curso1617;

public class Septiembre {

	public static void main(String[] args) {

	}

	/*
	 * PROBLEMA 1: Dada una funci�n recursiva SE PIDE: 1.- Soluci�n recursiva y
	 * recursiva final en Java 2.- Soluci�n iterativa en Java 3.- Definir los
	 * tama�os en el mejor y el peor caso, y calcular los T(n).
	 * 
	 */

	// Funci�n recursiva no final
	public static Integer func(int[] aux, Integer m, Integer n) {
		Integer res = 0;
		if (m == 0) {
			res = aux[m];
		} else {
			if (m > 0 && n == 0) {
				res = func(aux, m - 1, aux[m]);
			} else if (m > 0 && n > 0) {
				res = func(aux, m - 1, aux[m]) + aux[m];
			}
		}
		return res;

	}

	// Funci�n recursiva final
	public static Integer funcRecFinal(int[] aux, int m, int n, int res) {
		if (m == 0) {
			return funcRecFinal(aux, m, n, aux[m]);
		} else {
			if (m > 0 && n == 0) {
				return funcRecFinal(aux, m - 1, aux[m], res);
			} else if (m > 0 && n > 0) {
				return funcRecFinal(aux, m - 1, aux[m], res + aux[m]);
			}
			return funcRecFinal(aux, m, n, res);
		}

	}

	// Funci�n iterativa
	public static Integer funcIt(int[] aux, Integer m, Integer n) {
		Integer res = 0;
		while (m >= 0) {
			if (n > 0) {
				res = res + aux[m];
			}
			n = aux[m];
			m--;
		}
		return res + aux[m];
	}

}
