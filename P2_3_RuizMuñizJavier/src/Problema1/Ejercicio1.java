package Problema1;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio1 {

	/* Decidir si un �rbol binario es equilibrado */
	/*
	 * Un �rbol equilibrado es un �rbol binario de b�squeda en el que para cada nodo
	 * el n�mero de niveles de sus sub�rboles izquierdo y derecho no debe diferir en
	 * m�s de una unidad.
	 */

	/*
	 * Sea h el n�mero de niveles, la condici�n que se debe cumplir para que sea
	 * equilibrado es que 2^(h-1) sea igual al n�mero de nodos
	 */

	public static <E> void main(String[] args) {

		BinaryTree<Integer> t1 = BinaryTree.leaf(1);
		BinaryTree<Integer> t2 = BinaryTree.leaf(2);
		BinaryTree<Integer> t3 = BinaryTree.leaf(3);
		BinaryTree<Integer> t4 = BinaryTree.leaf(4);
		BinaryTree<Integer> t5 = BinaryTree.empty();
		BinaryTree<Integer> t6 = BinaryTree.binary(56, t1, t2);
		BinaryTree<Integer> t7 = BinaryTree.binary(27, BinaryTree.binary(42, t1, t2), BinaryTree.binary(59, t3, t4));
		BinaryTree<Integer> t8 = BinaryTree.binary(85, BinaryTree.binary(54, BinaryTree.binary(35, t1, t2), t3), t4);

		System.out.println("�rbol vac�o: " + t5);
		System.out.println("�rbol binario equilibrado: "+ t7);
		System.out.println("�rbol binario desequilibrado: " + t8);
		
		System.out.println("=======================================");
		
		System.out.println("SOLUCIONES");
		System.out.println("Soluci�n para �rbol vac�o: " + esAVL(t5));
		System.out.println("Soluci�n para �rbol equilibrado: " + esAVL(t7));
		System.out.println("Soluci�n para �rbol no equilibrado: " + esAVL(t8));
		

	}

	public static <E extends Comparable<E>> boolean esAVL(BinaryTree<E> tree) {
		boolean res = false;
		switch (tree.getType()) {
		case Empty:
			res = true;
			break;
		case Leaf:
			res = true;
			break;
		case Binary:
			int altizq = tree.getLeft().getHeight();
			int altder = tree.getRight().getHeight();
			if (altizq - altder < 1 && altizq - altder > 0 || altder - altizq < 1 && altder - altder > 0
					|| altizq == altder) {

				res = esAVL(tree.getLeft()) && esAVL(tree.getRight());

			} else {
				res = false;
			}

		}

		return res;
	}

}
