package E1;

import java.util.List;

import us.lsi.tiposrecursivos.Tree;

public class Ejercicio1 {

	// Determinar si un árbol n-ario contiene una etiqueta dada

	public static void main(String[] args) {

		Tree<Integer> t1 = Tree.empty();
		Tree<Integer> t2 = Tree.leaf(2);
		Tree<Integer> t3 = Tree.leaf(3);
		Tree<Integer> t4 = Tree.leaf(4);
		Tree<Integer> t5 = Tree.nary(27, t1, t2, t3, t4);
		System.out.println("Resolución: " + contieneEtiqueta(t5, 2, t5.size() - 1));
		System.out.println(t5);

	}

	private static boolean contieneEtiqueta(Tree<Integer> tree, int etq, int c) {
		boolean res = false;
		Tree<Integer> r = tree.getChild(c);
		switch (r.getType()) {
		case Empty:
			res = false;
			break;

		case Leaf:
			return r.getLabel().equals(etq);
		

		case Nary:
			return contieneEtiqueta(tree, etq, c - 1);

		}
		return res;

	}
}
