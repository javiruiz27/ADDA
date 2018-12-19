package E2;

import java.util.List;

import us.lsi.common.Streams2;
import us.lsi.tiposrecursivos.Tree;

public class Ejercicio2 {

	/*
	 * Comprobar si dos árboles n-arios son iguales.
	 */

	public static <E> void main(String[] args) {

	}
	
	public static <E> Boolean iguales(Tree<E> a1, Tree<E> a2) {
		Boolean res = true;
		switch(a1.getType()) {
		case Empty:
			res = a2.isEmpty();
			break;
		
		case Leaf:
			res = a2.isLeaf() && a1.getLabel().equals(a2.getLabel());
			break;
		
		case Nary:
			res = a2.isNary() && a1.getLabel().equals(a2.getLabel()) && Streams2.zip(a1.getChildren().stream(),
					a2.getChildren().stream(), (ab1, ab2)-> iguales(ab1, ab2)).allMatch(x->x==true);
		}
		return res;
	}
	
	

}
