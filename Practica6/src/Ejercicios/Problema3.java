package Ejercicios;

import java.util.stream.IntStream;

public class Problema3 {

	/*
	 * Encontrar la raíz cuadrada de un número (la raíz cuadrada de un entero a es
	 * el mayor valor de un entero n tal que a≥n 2 ). (Java) (Iterativo, Recursivo y
	 * Funcional)
	 */

	public static void main(String[] args) {
		Integer n = 9;

		System.out.println("Resolución recursiva: " + raizRecFinal(n, n));
		System.out.println("Resolución iterativa: " + raizIte(n));
		System.out.println("Resolución en Java 10: " + raizJava10(n));
	}
	
	

	public static Integer raizJava10(Integer n) {
		return IntStream.range(0, n).boxed().filter(x->x*x==n).findFirst().orElse(null);
	}



	public static Integer raizIte(Integer n) {
		Integer res = null;
		Integer c = n;
		while (c >= 0) {
			if (c * c == n) {
				res = c;
				break;
			}
			c--;
		}
		return res;
	}

	public static Integer raizRecFinal(Integer n, Integer c) {
		if (c * c == n) {
			return c;
		}else if(c<=0) {
			return null;
		} else {
			return raizRecFinal(n, c - 1);
		}
	}

}
