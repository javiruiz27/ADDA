package puzzlegv;

import us.lsi.astar.AStarGraph;
import us.lsi.graphs.SimpleEdge;
import us.lsi.graphs.SimpleVirtualGraph;

public class GrafoPuzzle
	extends SimpleVirtualGraph<VerticePuzzle, SimpleEdge<VerticePuzzle>>
	implements AStarGraph<VerticePuzzle, SimpleEdge<VerticePuzzle>>{

	private GrafoPuzzle(VerticePuzzle... vertexSet) {
		super(vertexSet);
		// TODO Auto-generated constructor stub
	}
	
	public static GrafoPuzzle create(VerticePuzzle... vertexSet) {
		return new GrafoPuzzle(vertexSet);
	}
	
	

}
