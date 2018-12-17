package Curso1718;

import java.util.ArrayList;
import java.util.List;

public class Septiembre {

	public static void main(String[] args) {
		// EJERCICIO 1
		List<Integer> l = new ArrayList<>();
		l.add(0);
		l.add(2);
		l.add(4);
		l.add(6);
		l.add(8);
		l.add(10);

		System.out.println("Resolución recursiva no final: " + esECreciente(l, l.size() - 1));
		System.out.println("Resolución recursiva no final: " + esECrecienteF(l));
		/*
		 * =============================================================================
		 * =
		 */

		// EJERCICIO 2

		List<Integer> l2 = new ArrayList<>();
		l2.add(0);
		l2.add(1);
		l2.add(3);
		l2.add(2);
		l2.add(1);

		System.out.println("Solución recursiva: " + pMaxBit(l2));

		/*
		 * =============================================================================
		 * =
		 */

	}

	// EJERCICIO 2: DIVIDE Y VENCERÁS

	public static Integer pMaxBit(List<Integer> l2) {
		return pMaxBit(l2, 0, l2.size());
	}

	private static Integer pMaxBit(List<Integer> l2, int i, int j) {
		Integer res = null;
		if (j == i + 1) {
			res = i;
		} else {
			int m = (i + j) / 2;
			if (l2.get(m - 1) < l2.get(m)) {
				res = pMaxBit(l2, m, j);
			} else {
				res = pMaxBit(l2, i, m);
			}
		}
		return res;
	}

	// EJERCICIO 1: RECURSIVIDAD
	public static Boolean esECrecienteF(List<Integer> l) {
		return esECrecienteF(l, l.size() - 1, true);
	}

	private static Boolean esECrecienteF(List<Integer> l, int c, boolean res) {
		if (c <= 0) {
			return res;
		} else {
			if (l.get(c) % 2 != 0 || l.get(c) / l.get(c - 1) != 0) {
				return res = false;

			}
			return esECrecienteF(l, c - 1, res);
		}
	}

	public static Boolean esECreciente(List<Integer> l, int c) {
		Boolean res = true;
		if (c <= 0) {
			return res;
		} else {
			if (l.get(c) % 2 != 0 || l.get(c) / l.get(c - 1) != 0) {
				return res = false;

			}
			return esECreciente(l, c - 1);
		}
	}

}
