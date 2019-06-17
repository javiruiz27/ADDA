package Problema4;

import us.lsi.pd.AlgoritmoPD;

public class TestPalindromo {

	public static void main(String[] args) {
		AlgoritmoPD.isRandomize = false;
		AlgoritmoPD.metricasOK = true;

		//String cadena = "ababbbabbababa";
		String cadena = "abbbababbbbaaaabbbabab";

		PalindromoProblemaPD p = PalindromoProblemaPD.create(cadena, 0, cadena.length());

		var a = AlgoritmoPD.createPD(p);
		a.ejecuta();

		// Ejecuci�n de algoritmo
		System.out.println("La soluci�n es: " + a.getSolucion());
		
	}

}
