package Árboles;

import java.util.ArrayList;
import java.util.List;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejer117 {

	/*
	 * Convertir un árbol binario en una lista que contiene sus etiquetas en
	 * recorrido en anchura o por niveles. En este recorrido se añade primero la
	 * etiqueta del árbol actual, luego las de sus hijos, posteriormente los hijos
	 * de estos y así sucesivamente. Es decir, se añaden por niveles: 0, 1, ...
	 */

	public static void main(String[] args) {

		BinaryTree<String> bt2 = BinaryTree.binary("A",
				BinaryTree.binary("Z", BinaryTree.leaf("H"), BinaryTree.leaf("B")),
				BinaryTree.binary("T", BinaryTree.leaf("B"), BinaryTree.leaf("C")));

		System.out.println("Recorrido en anchura de: " + bt2 + " = " + recorridoAnchura(bt2));

	}

	public static <E> List<E> recorridoAnchura(BinaryTree<E> bt2) {
		List<E> res = new ArrayList<>();

		switch (bt2.getType()) {
		case Empty:
			break;

		case Leaf:
			res.add(bt2.getLabel());
			break;
		case Binary:
		
		}

		return res;
	}

}
