package Problema2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P2 {

	/*
	 * P2 - (Ej53): Dadas dos listas de reales del mismo tamaño decidir si los
	 * incrementos del valor almacenado en cada posición con respecto a la anterior
	 * sin del mismo signo en ambas listas para todas las posiciones.
	 */

	public static void main(String[] args) {
		List<Double> lista1 = new ArrayList<>();
		List<Double> lista2 = new ArrayList<>();

		lista1.add(2.);
		lista1.add(1.);
		lista2.add(2.);
		lista2.add(1.);

		System.out.println("Resuelto con algoritmo iterativo: " + tamanyoIncrementosWhile(lista1, lista2));
		System.out.println("Resuelto con Java 10: " + tamanyoIncrementosJ10(lista1, lista2));
		System.out.println("Resuelto con algoritmo recursivo final: " + tamanyoIncrementosRecFinal(lista1, lista2, 0));
	}

	public static Boolean tamanyoIncrementosWhile(List<Double> lista1, List<Double> lista2) {
		Boolean res = false;
		Integer contador = 0;
		while (contador <= lista1.size() && contador <= lista2.size()) {
			Double resta1 = lista1.get(contador + 1) - lista1.get(contador);
			Double resta2 = lista2.get(contador + 1) - lista2.get(contador);
			if (resta1 < 0 && resta2 < 0 || resta1 > 0 && resta2 > 0 || resta1 == 0 && resta2 == 0) {
				res = true;
				contador++;
				break;

			} else {
				res = false;

			}

		}

		return res;
	}

	public static Boolean tamanyoIncrementosJ10(List<Double> lista1, List<Double> lista2) {
		Integer i = 0;
		List<Double> restas1 = lista1.stream().filter(x -> x <= lista1.size())
				.mapToDouble(x -> lista1.get(i + 1) - lista1.get(i)).boxed().collect(Collectors.toList());
		List<Double> restas2 = lista2.stream().filter(x -> x <= lista2.size())
				.mapToDouble(x -> lista2.get(i + 1) - lista2.get(i)).boxed().collect(Collectors.toList());

		Boolean res = restas1.equals(restas2);

		return res;
	}

	public static Boolean tamanyoIncrementosRecFinal(List<Double> lista1, List<Double> lista2, Integer i) {
		return null;
		
	}

}
