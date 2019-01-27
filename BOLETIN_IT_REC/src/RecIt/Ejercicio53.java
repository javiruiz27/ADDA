package RecIt;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio53 {

	/*
	 * 53. Dadas dos listas de reales del mismo tamaño decidir si para todas las
	 * casillas los incrementos de cada casilla con respecto a la anterior son mismo
	 * signo en ambas listas.
	 */

	public static void main(String[] args) {

		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();

		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(7);
		l1.add(9);
		l1.add(10);
		l1.add(11);

		l2.add(4);
		l2.add(5);
		l2.add(6);
		l2.add(10);
		l2.add(11);
		l2.add(12);
		l2.add(13);

		System.out.println(incrementos(l1, l1, 0, 0));
	}
	
	public static Boolean incrementos(List<Integer> l1, List<Integer> l2, int i, int j) {
		Boolean res;
		if(i+1 == l1.size()) {
			res = true;
		}else {
			if(l1.get(i+1)- l1.get(i) == l2.get(j+1) - l2.get(j)) {
				res = incrementos(l1, l2, i+1, j+1);
			}else {
				res = false;
			}
		}
		
		return res;
	}

}
