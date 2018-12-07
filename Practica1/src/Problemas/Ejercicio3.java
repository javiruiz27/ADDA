package Problemas;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ejercicio3 {

	// Encontrar la inversa de una cadena de caracteres

	public static void main(String[] args) {
		System.out.println("Resuelto con while: " + invierteCadenaWhile("Javier"));
		System.out.println("Resuelto con Java 8: " + invierteCadenaJ8("Javier"));
	}

	public static String invierteCadenaJ8(String palabra) {
		return IntStream.rangeClosed(1, palabra.length()).boxed()
				.map(i -> String.valueOf(palabra.charAt(palabra.length() - i))).collect(Collectors.joining());
	}

//	public static String invierteCadenaJ8(String s) {
//		List<Character> res = IntStream.range(0, s.length()).boxed().map(x -> s.charAt(x)).collect(Collectors.toList());
//
//		Collections.reverse(res);
//
//		String res1 = res.stream().map(n -> n.toString()).collect(Collectors.joining());
//
//		return res1;
//	}

	public static String invierteCadenaWhile(String s) {
		// List<Character> res = new ArrayList<>();
		String res = "";
		Integer c = s.length() - 1;
		while (c != 0) {
			Character t = s.charAt(c);
			// res.add(t);
			res = res + t;
			c--;

		}

		// res.add(s.charAt(0));
		res = res + s.charAt(0);
		return res;
	}

}
