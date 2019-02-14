package Árboles;

import us.lsi.tiposrecursivos.Tree;

public class cuentaXRep {

	public static <E> Integer cuentaXRep(Tree<E> t, E x) {
		Integer res = 0;
		if (t.isLeaf()) {

			if (t.getLabel().equals(x) && !t.isEmpty()) {
				res++;
			} else {
				if (t.getLabel().equals(x) && !t.isEmpty()) {
					res++;
				} else {
					for(int i = 1; i<t.getNumOfChildren(); i++) {
						//res = res + cuentaXRep(t.getElement(i), x);
					}
				}
			}
		}
		return res;
	}

}
