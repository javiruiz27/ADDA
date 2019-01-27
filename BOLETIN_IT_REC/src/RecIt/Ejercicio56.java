package RecIt;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio56 {

	/*
	 * 56. Decidir si los elementos de una lista de enteros forman una progresión
	 * aritmética
	 */
	
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		
		l1.add(0);
		l1.add(2);
		l1.add(4);
		l1.add(6);
		l1.add(8);
		l1.add(10);
		l1.add(11);
		
		System.out.println(eProgArit(l1, 0));
		
	}
	
	public static Boolean eProgArit(List<Integer> l, int i) {
		Boolean res;
		int n = l.get(1)-l.get(0);
		if(l.get(i+1) == l.size()) {
			res = true;
		}else {
			if(l.get(i+1)-l.get(i) == n) {
				res = eProgArit(l, i+1);
			}else {
				res = false;
			}
		}
		
		return res;
	}

}
