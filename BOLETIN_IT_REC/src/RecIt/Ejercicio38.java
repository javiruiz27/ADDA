package RecIt;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio38 {

	// Dado un entero n obtener una lista con sus divisores

	public static void main(String[] args) {

		Integer n = 155;
		System.out.println("Divisor del número " + n + " es:" + divisores(n));
		System.out.println("Divisor del número " + n + " es:" + divisoresRec(n, n, new ArrayList<>()));
	}

	public static List<Integer> divisoresRec(Integer n, int i, List<Integer> res) {
		if(i == 0) {
			return res;
		}else {
			if(n%i == 0) {
				res.add(i);
			}
			divisoresRec(n, i-1, res);
		}
		return res;
	}

	public static List<Integer> divisores(Integer n) {
		List<Integer> res = new ArrayList<>();
		int i = n;
		while (i > 1) {
			if (n % i == 0) {
				res.add(i);
			}
			i--;
		}
		res.add(1);
		return res;
	}



	
}