package Problema1;

import java.util.Map;

import us.lsi.ag.ValuesInRangeChromosome;
import us.lsi.ag.ValuesInRangeProblemAG;
import us.lsi.ag.agchromosomes.AlgoritmoAG;
import us.lsi.ag.agchromosomes.ChromosomeFactory.ChromosomeType;
import us.lsi.ag.agstopping.StoppingConditionFactory;
import us.lsi.ag.agstopping.StoppingConditionFactory.StoppingConditionType;

public class TestProblema1Genetico {
	
	public static void main(String[] args) {
		setCondiciones();
		ValuesInRangeProblemAG<Integer, Map<Barrios2, Integer>>problema = new Problema1Genetico();
		
		AlgoritmoAG<ValuesInRangeChromosome<Integer>> alg = AlgoritmoAG.<ValuesInRangeChromosome<Integer>>create(ChromosomeType.Binary, problema);
		
		alg.ejecuta();
		
		ValuesInRangeChromosome<Integer> mejorSolucion = alg.getBestChromosome();
		System.out.println("Best solution " + mejorSolucion);

	}

	private static void setCondiciones() {
		//Condiciones "evolutivas"
				AlgoritmoAG.ELITISM_RATE = 0.2;
				AlgoritmoAG.CROSSOVER_RATE = 0.8;
				AlgoritmoAG.MUTATION_RATE = 0.0;
				AlgoritmoAG.POPULATION_SIZE = 300;
				
		//Condiciones de parada
				StoppingConditionFactory.NUM_GENERATIONS = 1000;
				StoppingConditionFactory.SOLUTIONS_NUMBER_MIN = 3;
				StoppingConditionFactory.FITNESS_MIN = 0.;
				StoppingConditionFactory.stoppingConditionType = StoppingConditionType.SolutionsNumber;
	}

}
