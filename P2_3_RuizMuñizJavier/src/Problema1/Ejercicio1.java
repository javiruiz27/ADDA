package Problema1;

import us.lsi.tiposrecursivos.BinaryTree;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio1 {

	/* Decidir si un �rbol binario es equilibrado */
	/*
	 * Un �rbol equilibrado es un �rbol binario de b�squeda en el que para cada nodo
	 * el n�mero de niveles de sus sub�rboles izquierdo y derecho no debe diferir en
	 * m�s de una unidad.
	 */

	// 1.- Crear un �rbol binario de b�squeda.
	/*
	 * Sea h el n�mero de niveles, la condici�n que se debe cumplir para que sea
	 * equilibrado es que 2^(h-1) sea igual al n�mero de nodos
	 */

	public static <E> void main(String[] args) {

		BinaryTree<Integer> t1 = BinaryTree.leaf(1);
		BinaryTree<Integer> t2 = BinaryTree.leaf(2);
		BinaryTree<Integer> t3 = BinaryTree.leaf(3);
		BinaryTree<Integer> t4 = BinaryTree.leaf(4);
		BinaryTree<Integer> t6 = BinaryTree.binary(27,BinaryTree.binary(42,t1,t2),BinaryTree.binary(59,t3,t4));
		System.out.println(t6);
		
		

		 System.out.println(esAVL(t6));

	}

	public static boolean esAVL(BinaryTree<Integer> t6) {
		
		return true;
	}



}
