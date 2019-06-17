package Problema1;

import java.util.Arrays;

import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionPLI alg = AlgoritmoPLI.getSolutionFromFile(".ficheros/Ejercicio.txt");
		System.out.println("Valor resultante de la función objetivo: "+ alg.getGoal());
		System.out.println("Valores variables:"+ Arrays.toString(alg.getSolution()));
	}

}
