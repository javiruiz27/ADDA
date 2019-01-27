package RecIt;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio41 {

	/*
	 * 41. Dada una lista de enteros encontrar el valor más cercano a un número
	 * dado. 
	 * a. Asumir que la lista no está ordenada
	 * b. Asumir que la lista está ordenada
	 */

	public static void main(String[] args) {
		
		List<Integer> l = new ArrayList<>();
		List<Integer> lOrd = new ArrayList<>();

		l.add(2);
		l.add(5);
		l.add(8);
		l.add(3);
		l.add(2);
		l.add(9);

		lOrd.add(2);
		lOrd.add(3);
		lOrd.add(4);
		lOrd.add(5);
		lOrd.add(6);
		lOrd.add(7);
		
		System.out.println(valorCercano(lOrd, 7, 0, lOrd.size()-1));

	}
	
	
	public static List<Integer> valorCercano(List<Integer> l, int e, int i, int j){
		List<Integer> res = new ArrayList<>();
		if(j-e == e-i) {
			res.add(i);
			res.add(j);
		}else if(j-e >e-i) {
			res.add(i);
		}else if(j-e<e-i){
			res.add(j);
		}else {
			valorCercano(l, e, i+1, j-1);
			
		}
		
		return res;
	}

}
