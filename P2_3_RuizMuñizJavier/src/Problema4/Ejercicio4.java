package Problema4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio4 {

	/*
	 * Dada una lista de palabras, ordenada alfabéticamente, se desea encontrar la
	 * posición de la palabra dada P y si no está devolverá -1. Se quiere diseñar un
	 * algoritmo que divida el vector en tres partes y seguir buscando en el tercio
	 * correspondiente.
	 * Determinar la posición i tal que a[i] = i
	 * Determinar la posicion p tal que lista.get(p) = p
	 */
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("casa");
		lista.add("coche");
		lista.add("perro");
		lista.add("hola");
		lista.add("adios");
		lista.add("gato");
		lista.add("musica");
		lista.add("que");
		lista.add("tal");
		lista.add("como");
		lista.add("estas");
		
		Collections.sort(lista);
		System.out.println(lista);
		
		System.out.println("Solución recursiva: " + posicionPalabra(lista, "hoola"));

	}

	public static Integer posicionPalabra(List<String> lista, String p) {
		
		return posicionPalabra(lista, p, 0, lista.size(), lista.size()/2);
	}

	private static Integer posicionPalabra(List<String> lista, String p, int i, int j, int k) {
		if(lista.get(k) == p) {
			return k;
		}else if(i == j){
			return -1;
		}else {
			System.out.println("i=" + i + "; j=" + j + "; k=" + k);
			if(lista.get(k).compareTo(p)>0) {
				return posicionPalabra(lista, p, i, k, (i+k)/2);
			}else {
				return posicionPalabra(lista, p, k+1, j, (k+j+1)/2);
			}
		}
	}

}
