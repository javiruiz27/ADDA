package E3;

import java.util.HashMap;
import java.util.List;

public class Ejercicio {

	public static void main(String[] args) {
		System.out.println("(30, 7) = " + combi(30, 7));

	}

	public static Long combi(Integer n, Integer k) {
		return combiR(n, k, new HashMap<List<Integer>, Long>());

	}

	private static Long combiR(Integer n, Integer k, HashMap<List<Integer>, Long> m) {
		Long res = null;
		if (m.containsKey(List.of(n, k))) {
			res = m.get(List.of(n, k));
		}

		else if (k == 1 || k == n - 1) {
			res = n + 0L;
		} else if (k == 1 || k == n) {
			res = 1L;
		} else {
			res = combiR(n - 1, k - 1, m) + combiR(n - 1, k, m);
		}
		m.put(List.of(n, k), res);
		return res;
	}

}
