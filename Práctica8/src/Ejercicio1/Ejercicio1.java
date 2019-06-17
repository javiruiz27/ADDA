package Ejercicio1;

import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleWeightedGraph;

import Tipos.Carretera;
import Tipos.Ciudad;
import us.lsi.graphs.GraphsReader;

public class Ejercicio1 {

	public static void main(String[] args) {
		Graph<Ciudad, Carretera> g = cargarGrafo("./ficheros/andalucia.txt");
		exportarGrafo(g, "/ficheros/Andalucia.gv");
	}

	private static void exportarGrafo(Graph<Ciudad, Carretera> g, String string) {
		
	}

	private static Graph<Ciudad, Carretera> cargarGrafo(String nombreFichero) {
		return GraphsReader.newGraph(nombreFichero, Ciudad::create, Carretera::create,
				() -> new SimpleWeightedGraph<>(Ciudad::create, Carretera::create));
	}

}
