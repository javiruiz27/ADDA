package Problema2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.common.Streams2;
import us.lsi.lpsolve.solution.AlgoritmoPLI;
import us.lsi.lpsolve.solution.SolutionPLI;

public class Ejercicio2 {
	private static final Integer MAX_INV=65, VM=1;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Oportunidades> escenario = cargarDatos("./ficheros/p2.txt");
		String def = definirProblema(escenario);//Lo usaremos para generalizarlo para más valores.
		
		SolutionPLI alg = AlgoritmoPLI.getSolution(def);
		System.out.println("Valor resultante de la función objetivo: "+ alg.getGoal());
		System.out.println("Valores variables:"+ Arrays.toString(alg.getSolution()));
	}
	
	private static String definirProblema(List<Oportunidades> escenario) {
		String res = defFuncObj(escenario);
		res = res + resInvMax(escenario);
		return res + resVbles(escenario.size());
	}
	private static String resVbles(int n) {
		// TODO Auto-generated method stub
		return IntStream.range(0,n).boxed()
				.map(i->"x"+i+"<="+VM)
				.collect(Collectors.joining(";\n", "", ";"));
	}

	private static String resInvMax(List<Oportunidades> lo) {
		// TODO Auto-generated method stub
		return IntStream.range(0,lo.size()).boxed()
				.map(i->String.format("%dx%d", lo.get(i).getCapital(),i))
				.collect(Collectors.joining("+", "", "<="+MAX_INV+";\n"));
	}

	private static String defFuncObj(List<Oportunidades> lo) {
		// TODO Auto-generated method stub
		return IntStream.range(0,lo.size()).boxed()
				.map(i->String.format("%dx%d", lo.get(i).getBeneficio(),i))
				.collect(Collectors.joining("+", "max: ", ";\n"));
	}

	//Método para cargar los datos del fichero
	private static List<Oportunidades> cargarDatos(String f) {
		return Streams2.fromFile(f).map(Oportunidades::create).collect(Collectors.toList());
	}

}
