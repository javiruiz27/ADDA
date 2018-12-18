package Ejercicios;

import us.lsi.tiposrecursivos.BinaryTree;

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
		return sumaEtqPares(tree, tree.size());
	}

	private static Integer sumaEtqPares(BinaryTree<Integer> tree, int acum) {
		BinaryTree<Integer> treeAnt = tree;
		switch (tree.getType()) {
		case Empty:

		case Leaf:
			if (tree.getLabel() % 2 != 0) {
			
				return sumaEtqPares(tree, acum-1);
			}
			

		case Binary:
			int root = tree.getLabel();
			if (root % 2 != 0) {
				return sumaEtqPares(tree.getLeft(), acum) - sumaEtqPares(tree.getRight(), acum-1);
			}
		}
		return acum;
	}

}
