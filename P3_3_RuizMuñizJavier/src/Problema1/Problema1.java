package Problema1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.common.Streams2;
import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class Problema1 {		


	public static void main(String[] args) {
		SolutionPLI sol = AlgoritmoPLI.getSolutionFromFile("./ficheros/p1.txt");
		System.out.println("Valor resultante de la función objetivo: " + sol.getGoal());
		System.out.println("Valores variables:");
		for (int j = 0; j < sol.getNumVar(); j++) {
			System.out.println(sol.getName(j) + " = " + sol.getSolution()[j]);
		}
		System.out.println("---------Fin---------");

		System.out.println("SOLUCIÓN SACANDO LOS DATOS DE UN FICHERO");

		SolutionPLI alg = AlgoritmoPLI.getSolution(definirProblema("./ficheros/datos.txt"));
		System.out.println("Valor resultante de la función objetivo: " + alg.getGoal());
		System.out.println("Valores variables:" + Arrays.toString(alg.getSolution()));

		System.out.println("-----------------------");
	}

	private static String definirProblema(String fichero) {
		String res = "";
		List<Barrios> datos = cargarDatos(fichero);
		res = defFuncObj(datos);
		return res + resVbles(datos);
	}

	private static List<Barrios> cargarDatos(String s) {
		return Streams2.fromFile(s).map(x -> Barrios.create(x)).collect(Collectors.toList());
	}

	private static String resVbles(List<Barrios> datos) {
		return datos.stream().map(x -> x.getVecinos().stream().collect(Collectors.joining("+x", "x", ">=1;\n")))
				.collect(Collectors.joining());
	}

	private static String defFuncObj(List<Barrios> datos) {
		return "min:" + datos.stream().map(x -> x.getNombre()).collect(Collectors.joining("+x", "x", ";\n"));
	}

}
