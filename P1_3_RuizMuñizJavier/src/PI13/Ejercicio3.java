package PI13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import us.lsi.common.Files2;

public class Ejercicio3 {

	/*
	 * Obtener una List<Integer> a partir de un fichero de texto que contiene en
	 * cada línea una lista de números enteros separados por comas.
	 */

	public static void main(String[] args) {

		List<String> lista = Files2.getLines("C:\\Users\\Javier\\Desktop\\practica\\PracticaIndividual.txt");
		System.out.println(lista);
		System.out.println("Resultado con while: " + listaEnterosWhile(lista));
		System.out.println("Resuelto con Java 10: " + listaEnterosJ10(lista));
		System.out.println("Resuelto con recursividad final: " + listaEnterosRecFinal(lista));
	}

	private static List<Integer> listaEnterosRecFinal(List<String> lista) {
		return null;

	}

	private static List<Integer> listaEnterosJ10(List<String> lista) {
		List<Integer> res = lista.stream().flatMap(x -> Stream.of(x.split(","))).map(x -> Integer.parseInt(x))
				.collect(Collectors.toList());
		return res;
	}

	private static List<Integer> listaEnterosWhile(List<String> lista) {
		List<Integer> res = new ArrayList<>();
		Integer filas = 0;
		Integer indice = 0;
		while (filas <= lista.size() - 1) {
			String[] partes = lista.get(filas).split(",");
			if (indice < partes.length) {
				String num = partes[indice];
				Integer num2 = Integer.parseInt(num);
				res.add(num2);
				indice++;
			} else if (indice == partes.length) {
				filas++;
				indice = 0;
			}
		}

		return res;
	}

}
