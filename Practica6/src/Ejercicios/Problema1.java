package Ejercicios;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class Problema1 {

	/*
	 * Suma de las etiquetas del árbol (binario / n-ario) que son pares (asumiendo
	 * que son de tipo entero)
	 */

	public static void main(String[] args) {

		BinaryTree<Integer> t3 = BinaryTree.leaf(8);
		BinaryTree<Integer> t4 = BinaryTree.leaf(14);
		BinaryTree<Integer> t5 = BinaryTree.leaf(15);
		BinaryTree<Integer> t6 = BinaryTree.leaf(9);
		BinaryTree<Integer> tree3 = BinaryTree.binary(83, t4, t5);
		BinaryTree<Integer> tree2 = BinaryTree.binary(12, t3, t6);
		BinaryTree<Integer> tree = BinaryTree.binary(15, tree2, tree3);

		System.out.println("Resolución recursiva: " + sumaEtqPares(tree));

	}

	public static Integer sumaEtqPares(BinaryTree<Integer> tree) {
		Integer res = 0;
		switch (tree.getType()) {

		case Empty:
			break;

		case Leaf:
			if (tree.getLabel() % 2 == 0) {
				res = tree.getLabel();

			}
			break;

		case Binary:
			if (tree.getLabel() % 2 == 0) {
				res = tree.getLabel();

			}
			res = res + sumaEtqPares(tree.getLeft()) + sumaEtqPares(tree.getRight());
			break;

		}

		return res;
	}

	public static Integer sumaEtqPares(Tree<Integer> tree) {
		Integer res = 0;
		switch (tree.getType()) {

		case Empty:
			break;

		case Leaf:
			if (tree.getLabel() % 2 == 0) {
				res = tree.getLabel();

			}
			break;

		case Nary:
			if (tree.getLabel() % 2 == 0) {
				res = tree.getLabel();

			}
			res = res + tree.getChildren().stream().mapToInt(x -> sumaEtqPares(x)).sum();

			break;

		}

		return res;
	}



}
