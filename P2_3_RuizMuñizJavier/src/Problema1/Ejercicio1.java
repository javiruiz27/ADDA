package Problema1;

import java.util.List;

import us.lsi.common.Comparator2;
import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio1 {

	/* Decidir si un árbol binario es equilibrado */
	/*
	 * Un árbol equilibrado es un árbol binario de búsqueda en el que para cada nodo
	 * el número de niveles de sus subárboles izquierdo y derecho no debe diferir en
	 * más de una unidad.
	 */

	// 1.- Crear un árbol binario de búsqueda.
	/*
	 * Sea h el número de niveles, la condición que se debe cumplir para que sea
	 * equilibrado es que 2^(h-1) sea igual al número de nodos
	 */

	public static <E> void main(String[] args) {

		BinaryTree<Integer> t1 = BinaryTree.leaf(1);
		BinaryTree<Integer> t2 = BinaryTree.leaf(2);
		BinaryTree<Integer> t3 = BinaryTree.leaf(3);
		BinaryTree<Integer> t4 = BinaryTree.leaf(4);
		BinaryTree<Integer> t5 = BinaryTree.empty();
		BinaryTree<Integer> t6 = BinaryTree.binary(56, t1,t2);
		BinaryTree<Integer> t7 = BinaryTree.binary(27, BinaryTree.binary(42, t1, t2), BinaryTree.binary(59, t3, t4));
		BinaryTree<Integer> t8 = BinaryTree.binary(85, BinaryTree.binary(54, BinaryTree.binary(35, t1, t2), t3), t4);
		
		System.out.println(t6);
		System.out.println(t7);
		System.out.println(t8);
		System.out.println(t6.getRight());

		System.out.println(esAVL(t8));

	}

	public static boolean esAVL(BinaryTree<Integer> tree) {
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
			if (altizq - altder < 1 && altizq - altder > 0
					|| altder - altizq < 1 && altder - altder > 0 || altizq == altder) {
				
				return esAVL(tree.getLeft()) && esAVL(tree.getRight());

			}else {
				return false;
			}

		}

		return res;
	}

}
