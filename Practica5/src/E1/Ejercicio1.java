package E1;

import java.util.List;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio1 {
	
	//Determinar si un �rbol n-ario contiene una etiqueta dada
	
	public static void main(String[] args) {
		 
		
		Tree<Integer> t1 = Tree.empty();
		Tree<Integer> t2 = Tree.leaf(2);
		Tree<Integer> t3 = Tree.leaf(3);
		Tree<Integer> t4 = Tree.leaf(4);
		Tree<Integer> t5 = Tree.nary(27,t1,t2,t3,t4);
		System.out.println("Resoluci�n: " + contieneEtiqueta(t5, 2, 0));
		
	}

	private static boolean contieneEtiqueta(Tree<Integer> tree, int etq, int c) {
		boolean res = false;
		switch(tree.getType()) {
		case Empty: 
			res = false;
			break;
		case Leaf:
			res = tree.getLabel() == etq;
			break;
		
		case Nary:

		}
		
		return res;
	}

}
