package E3;

import java.util.Comparator;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio3 {

	/* Obtener la menor etiqueta de un árbol binario respecto a un orden. */

	public static void main(String[] args) {

	}

	public static <E> E etiquetaMenor(BinaryTree<E> arbol, Comparator<E> cmp) {
		E res = null;
		switch (arbol.getType()) {
		case Empty:
			break;

		case Leaf:
			res = arbol.getLabel();
			break;

		case Binary:
			E a1 = etiquetaMenor(arbol.getLeft(), cmp);
			E a2 = etiquetaMenor(arbol.getRight(), cmp);
			res = menor(arbol.getLabel(), menor(a1, a2, cmp), cmp);

		}

		return res;
	}

	private static <E> Object menor(E a1, E a2, Comparator<E> cmp) {
		if (a1 == null) {
			return a2;
		} else if (a2 == null) {
			return a1;
		} else {
			return cmp.compare(a1, a2) <= 0 ? a1 : a2;
		}
	}

}
