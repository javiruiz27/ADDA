package Ejercicios;

import java.util.ArrayList;
import java.util.List;

import us.lsi.tiposrecursivos.BinaryTree;

public class Problema2 {

	/*
	 * Convertir un árbol binario en una lista que contiene sus etiquetas en
	 * recorrido en posorden. En este recorrido se añade primero las etiquetas de su
	 * hijo izquierdo, luego las del derecho y por último la etiqueta del árbol
	 * actual. (Java)
	 */

	public static void main(String[] args) {

		BinaryTree<String> bt2 = BinaryTree.binary("A",
				BinaryTree.binary("Z", BinaryTree.leaf("H"), BinaryTree.empty()),
				BinaryTree.binary("T", BinaryTree.leaf("B"), BinaryTree.leaf("C")));

		System.out.println("PostOrden de: " + bt2 + " = " + recorridoPostOrden(bt2));

	}

	private static <E> List<E> recorridoPostOrden(BinaryTree<E> bt2) {
		List<E> res = new ArrayList<>();
		switch (bt2.getType()) {
		case Empty:
			break;

		case Leaf:
			res.add(bt2.getLabel());
			break;

		case Binary:
			res.addAll(recorridoPostOrden(bt2.getLeft()));
			res.addAll(recorridoPostOrden(bt2.getRight()));

			res.add(bt2.getLabel());

			break;

		}

		return res;
	}

}
