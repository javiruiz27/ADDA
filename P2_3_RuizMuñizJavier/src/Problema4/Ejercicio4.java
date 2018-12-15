package Problema4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio4 {

	/*
	 * Dada una lista de palabras, ordenada alfabéticamente, se desea encontrar la
	 * posición de la palabra dada P y si no está devolverá -1. Se quiere diseñar un
	 * algoritmo que divida el vector en tres partes y seguir buscando en el tercio
	 * correspondiente. Determinar la posición i tal que a[i] = i Determinar la
	 * posicion p tal que lista.get(p) = p
	 */
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("a");
		lista.add("b");
		lista.add("c");
		lista.add("d");
		lista.add("e");
		lista.add("f");
		lista.add("g");
		lista.add("h");
		lista.add("i");
		lista.add("j");
		lista.add("k");
		lista.add("l");
		lista.add("m");
		lista.add("n");
		lista.add("o");
		lista.add("p");
		lista.add("q");
		lista.add("r");
		lista.add("s");
		lista.add("t");
		lista.add("u");
		lista.add("v");
		lista.add("w");
		lista.add("x");
		lista.add("y");
		lista.add("z");

		Collections.sort(lista);
		System.out.println(lista);

		int i = 0;
		while (i < lista.size()-1) {
			System.out.println("Solución recursiva: " + busquedaPos(lista, lista.get(i)));
			i++;
		}
	}

	public static Integer busquedaPos(List<String> lista, String p) {

		return busquedaPos(lista, p, 0, (lista.size() / 3), (2 * (lista.size()) / 3), lista.size() - 1, -1);
	}

	private static Integer busquedaPos(List<String> lista, String p, int i, int j, int k, int k2, int res) {
		if(lista.get(i) == p) {
			return res = i;
		}else if(lista.get(j) == p) {
			return res = j;
		}else if(lista.get(k) == p) {
			return res = k;
		}else if(lista.get(k2) == p) {
			return res = k2;
		}else if(p.compareTo(lista.get(j))<0) {
			return busquedaPos(lista, p, i, ((j-i)/3) + i, (2*(j-i))/3, j, res);
		}else if(p.compareTo(lista.get(j))>0 && p.compareTo(lista.get(k))<0 ) {
			return busquedaPos(lista, p, j+1, ((k-(j+1))/3)+(j+1) ,  (2*(k-(j+1))/3)+(j+1), k , res);
		}else if(p.compareTo(lista.get(k))>0) {
			return busquedaPos(lista, p, k+1, (k2-(k+1))/3 + (k+1), (2*(k2-(1+k))/3) + (k+1), k2, res);
		}
		return res;
	}

}
