package E4;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio4 {
	
	/*Obtener la copia simétrica de un árbol binario*/
	
	public static <E> BinaryTree<E> copiaSimetrica(BinaryTree<E> arbol){
		BinaryTree<E> res = null;
		switch(arbol.getType()) {
		case Empty:
			res = BinaryTree.empty();
			break;
		
		case Leaf:
			res = BinaryTree.leaf(arbol.getLabel());
			break;
		
		case Binary:
			res = BinaryTree.binary(arbol.getLabel(), copiaSimetrica(arbol.getRight()), copiaSimetrica(arbol.getLeft()));
			
			
		}
		
		return res;
	}

}
