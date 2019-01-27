package Árboles;

import java.util.ArrayList;
import java.util.List;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejer114 {

	/*
	 * Convertir un árbol binario en una lista que contiene sus etiquetas en
	 * recorrido en preorden. En este recorrido se añade primero la etiqueta del
	 * árbol actual, luego las de su hijo izquierdo y por último las del derecho
	 */

	public static void main(String[] args) {

		BinaryTree<String> bt2 = BinaryTree.binary("A",
				BinaryTree.binary("Z", BinaryTree.leaf("H"), BinaryTree.empty()),
				BinaryTree.binary("T", BinaryTree.leaf("B"), BinaryTree.leaf("C")));

		System.out.println("PostOrden de: " + bt2 + " = " + recorridoPreOrden(bt2));
	}

	public static <E> List<E> recorridoPreOrden(BinaryTree<E> bt2) {
		List<E> res = new ArrayList<>();
		switch (bt2.getType()) {
		case Empty:
			break;
		case Leaf:
			res.add(bt2.getLabel());
			break;
		case Binary:
			res.add(bt2.getLabel());
			res.addAll(recorridoPreOrden(bt2.getLeft()));
			res.addAll(recorridoPreOrden(bt2.getRight()));
		}

		return res;
	}

}
