package Problema1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.common.Streams2;
import us.lsi.common.Tuple;

public class Problema1Genetico implements ValuesInRangeProblemAG<Integer, Map<Barrios2, Integer>> {
	
	public static List<Barrios2> barrios = null;//cargarDatos("ficheros/datos.txt");


	
//	public static List<Barrios2> cargarDatos(String s) {
//		return Streams2.fromFile(s).map(x -> Barrios.create(x)).collect(Collectors.toList());
//	}

	public Integer getVariableNumber() {
		return 4;
	}

	public Integer getMax(Integer i) {
		return 2;
	}

	public Integer getMin(Integer i) {
		return 0;
	}

	public Double fitnessFunction(ValuesInRangeChromosome<Integer> cr) {
		Double res = 0.0;
		Double estaciones = (double) cr.decode().stream().filter(x -> x.equals(1)).count();

		Set<Barrios2> ls = IntStream.range(0, cr.decode().size()).boxed()
				.map(x -> Tuple.create(barrios.get(x), cr.decode().get(x))).filter(i -> i.equals(1))
				.map(y -> y.v1.getVecinos()).flatMap(s -> s.stream()).collect(Collectors.toSet());

		Double sinCubrir = (double) barrios.size() - ls.size();

		res = -estaciones - 1000000000l * sinCubrir;

		return res;
	}

	public Map<Barrios2, Integer> getSolucion(ValuesInRangeChromosome<Integer> cr) {
		Map<Barrios2, Integer> s = new HashMap<>();
		List<Integer> ls = cr.decode();
		IntStream.range(0, cr.decode().size()).boxed().forEach(x -> s.put(barrios.get(x), ls.get(x)));
		return null;
	}

}
