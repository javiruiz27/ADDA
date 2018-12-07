package PI11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ejercicio1 {

	// Dada una lista de String, buscar la cadena que tiene mayor número de
	// caracteres en minúsculas.
	

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("HOLaa");
		lista.add("HOLAa");
		lista.add("dE");
		lista.add("CONOCERte");
		lista.add("EncANtaDo");

		System.out.println("Solución iterativa Java: " + cadenaIterativoJava(lista));
		System.out.println("Solución Java 10: " + cadenaJava10(lista));
		System.out.println("Solución recursiva lineal final Java: " + cadenaRecursivoLinealFinalJava(lista, 0, ""));
		//System.out.println("Saca letras minúsculas recursivo final: " + sacaLetrasMinusculasRecFinal("JavIOer", 0, ""));

	}

	private static String cadenaRecursivoLinealFinalJava(List<String> lista, Integer i, String acum) {
		if (i > lista.size() - 1) {
			return acum;
		} else {
			if (sacaLetrasMinusculasRecFinal(acum, 0, "").length() < sacaLetrasMinusculasRecFinal(lista.get(i), 0, "")
					.length()) {
				acum = lista.get(i);

				return cadenaRecursivoLinealFinalJava(lista, i + 1, acum);
			} else {
				return cadenaRecursivoLinealFinalJava(lista, i + 1, acum);

			}

		}

	}

	private static String sacaLetrasMinusculasRecFinal(String palabra, Integer i, String ac) {
		if (i > palabra.length() - 1) {
			return ac;

		} else {
			Character c = palabra.charAt(i);
			if (Character.isLowerCase(c)) {
				return sacaLetrasMinusculasRecFinal(palabra, i + 1, ac + c);
			}
			return sacaLetrasMinusculasRecFinal(palabra, i + 1, ac);

		}

	}

	public static String cadenaJava10(List<String> s) {
		return s.stream().max(Comparator.comparing(x -> sacaNumeroLetras(x))).get();
	}

	private static Integer sacaNumeroLetras(String s) {
		List<Character> res = IntStream.range(0, s.length()).boxed().map(x -> s.charAt(x))
				.filter(x -> Character.isLowerCase(x)).collect(Collectors.toList());

		return res.size();
	}

	public static String cadenaIterativoJava(List<String> s) {
		String res = s.get(0);
		Integer contador = 1;
		while (contador < s.size()) {
			String palabra = s.get(contador);
			String s1 = sacaLetrasMinusculas(palabra);
			String s2 = sacaLetrasMinusculas(res);

			if (s1.length() > s2.length()) {
				res = palabra;
			}
			contador++;

		}

		return res;
	}

	private static String sacaLetrasMinusculas(String palabra) {
		String res = "";
		Integer contador = 0;
		while (contador < palabra.length()) {
			Character c = palabra.charAt(contador);
			if (Character.isLowerCase(c)) {
				res = res + c;
			}
			contador++;
		}

		return res;
	}

}
