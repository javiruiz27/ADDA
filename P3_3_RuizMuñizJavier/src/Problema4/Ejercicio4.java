package Problema4;

import java.io.PrintWriter;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.jgrapht.DirectedGraph;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DirectedWeightedMultigraph;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.io.DOTExporter;
import org.jgrapht.io.IntegerComponentNameProvider;



import us.lsi.common.Files2;
import us.lsi.graphs.EdgeArrayStringFactory;
import us.lsi.graphs.EdgeWeight;
import us.lsi.graphs.GraphsReader;
import us.lsi.graphs.VertexArrayStringFactory;

public class Ejercicio4 {

	private static VertexArrayStringFactory<Lugar> factoriaVertices = Lugar::create;
	private static EdgeArrayStringFactory<Lugar, Camino> factoriaAristas = Camino::create;
	private static Supplier<Graph<Lugar, Camino>> factoriaGrafos = () -> new SimpleWeightedGraph<Lugar, Camino>(
			Lugar::create, Camino::create);
	private static EdgeWeight<Camino> ew = Camino::getTiempo;
	private static Supplier<Graph<Lugar, Camino>> factoriaDigrafo = () -> new DirectedWeightedMultigraph<Lugar, Camino>(
			Camino.class);
	private static Supplier<Graph<Lugar, Camino>> factoriaDigrafoPeso = () -> new DirectedWeightedMultigraph<Lugar, Camino>(
			Camino.class);

	public static void main(String[] args) {

		// Creación de grafos desde ficheros

		Graph<Lugar, Camino> grafo = GraphsReader.newGraph("ficheros/P41.txt", factoriaVertices, factoriaAristas,
				factoriaGrafos, ew);

		Graph<Lugar, Camino> grafo2 = GraphsReader.newGraph("ficheros/P42.txt", factoriaVertices, factoriaAristas,
				factoriaDigrafo);

		Graph<Lugar, Camino> grafo3 = GraphsReader.newGraph("ficheros/P41.txt", factoriaVertices, factoriaAristas,
				factoriaGrafos, ew);

		// Exportar fichero a gv
		DOTExporter<Lugar, Camino> de = new DOTExporter<Lugar, Camino>(new IntegerComponentNameProvider<>(),
				vertice -> vertice.getNombre(), arista -> arista.getComienzo() + "-" + arista.getDestino()
						+ String.format(" (%.1f minutos)", arista.getTiempo()));

		PrintWriter pw = Files2.getWriter("ficheros/P42.gv"); // Del Proyecto Parte Comun
		de.exportGraph(grafo, pw);

		// Soluciones
		System.out.println("============ SOLUCIÓN APARTADO A =============");
		System.out.println("¿Es el grafo conexo?");
		esConexo(grafo);

		System.out.println("============ SOLUCIÓN APARTADO B =============");
		System.out.println("Sitios que pueden visitarse sin haber visitado otros antes:");
		primerosEnVisitar(grafo2);

		System.out.println("============ SOLUCIÓN APARTADO C =============");
		Lugar origen = Lugar.create("Sitio0");
		Lugar destino = Lugar.create("Sitio5");
		caminoMinimo(grafo3, origen, destino);

	}

	// Apartado 3: Camino Mínimo
//	private static void caminoMinimo(Graph<Lugar, Camino> grafo3, Lugar origen, Lugar destino) {
//
//		ShortestPathAlgorithm<Lugar, Camino> algoritmo = new DijkstraShortestPath<Lugar, Camino>(grafo3);
//		GraphPath<Lugar, Camino> gp = algoritmo.getPath(origen, destino);
//		Double distancia = algoritmo.getPathWeight(origen, destino);
//		if (gp == null) {
//			System.out.println("No hay camino posible entre el monumento " + origen + " al monumento " + destino);
//		} else {
//			System.out.println(
//					String.format("\nCamino mas corto entre Sitio0 y Sitio1 es: " + distancia.intValue() + " minutos"));
//			System.out.println("\tCamino: " + gp);
//		}
//	}
	//Apartado 3
	private static void caminoMinimo(Graph<Lugar, Camino> grafo, Lugar origen, Lugar destino) {
		Graph<Lugar,Camino> directedG = GraphsReader.newGraph("ficheros/P41.txt", Lugar::create, Camino::create, 
				()-> new DirectedWeightedMultigraph<Lugar, Camino>(Lugar::create, Camino::create)
				,Camino::getTiempo);
		DijkstraShortestPath<Lugar, Camino> cam = new DijkstraShortestPath<>(grafo);
		DijkstraShortestPath<Lugar, Camino> camD = new DijkstraShortestPath<>(directedG);
		Double tiempo = 0.;
		if(cam.getPath(origen, destino)!=null && camD.getPath(origen, destino)!=null ) {
			System.out.println("Se cumple la precedencia, asi que: ");
			System.out.println("El camino minimo desde " + origen + " hasta " + destino + " es: ");
			
			for(int i = 0; i< camD.getPath(origen, destino).getVertexList().size()-1;i++) {
				Lugar origen1 = camD.getPath(origen, destino).getVertexList().get(i);
				Lugar destino1 = camD.getPath(origen, destino).getVertexList().get(i+1);
				System.out.println(camD.getPath(origen1, destino1));
				tiempo += cam.getPathWeight(origen1, destino1);
			}
			System.out.println("Tiempo empleado: " + tiempo + " min");
		}else {
			System.out.println("No existe un camino que una los dos certices cumpliendo la precedencia.");
		}
	}


	// Apartado 2: Lugares que se pueden visitar sin haber visitado otros antes
	private static void primerosEnVisitar(Graph<Lugar, Camino> grafo2) {
		Set<Lugar> res = grafo2.vertexSet().stream().filter(x -> grafo2.incomingEdgesOf(x).isEmpty())
				.collect(Collectors.toSet());
		System.out.println(res);

	}

	// Apartado 1: ¿Es el grafo conexo?
	private static void esConexo(Graph<Lugar, Camino> grafo) {
		ConnectivityInspector<Lugar, Camino> alg = new ConnectivityInspector<Lugar, Camino>(grafo);
		Boolean res = alg.isConnected();
		if (res == true) {
			System.out.println("El grafo es conexo");
		} else {
			System.out.println("El grafo no es conexo, y las componentes conexas son: " + alg.connectedSets());
		}

	}

}
