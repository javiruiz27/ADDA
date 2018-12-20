package E1;



import us.lsi.tiposrecursivos.Tree;

public class Ejercicio1 {

	// Determinar si un árbol n-ario contiene una etiqueta dada

	public static void main(String[] args) {

		Tree<Integer> t1 = Tree.empty();
		Tree<Integer> t2 = Tree.leaf(2);
		Tree<Integer> t3 = Tree.leaf(3);
		Tree<Integer> t4 = Tree.leaf(4);
		Tree<Integer> t5 = Tree.nary(27, t1, t2, t3, t4);
		System.out.println("Resolución: " + contieneEtiqueta(t5, 2));
		System.out.println(t5);

	}

	public static <E> Boolean contieneEtiqueta(Tree<Integer> tree, E etq) {
		Boolean res = null;
		switch (tree.getType()) {
		case Empty:
			res = false;
			break;

		case Leaf:
			res = tree.getLabel().equals(etq);
			break;

		case Nary:
			res = tree.getLabel().equals(etq) || tree.getChildren().stream().anyMatch(x -> contieneEtiqueta(x, etq));

		}
		return res;

	}
}
