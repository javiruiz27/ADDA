package Curso1617;

public class ll {

	public static void main(String[] args) {

		// System.out.println(plants(2,3));

		// Merge
		String p1 = "himno";
		String p2 = "flor";
		System.out.println(Merge(p1, 0, p2, 0));
		System.out.println(7/2);

	}

	public static String Merge(String p1, int i, String p2, int j) {
		String res = "";
		if (p2 == "") {
			res = p2;
		} else if (p1 == "") {
			res = p1;
		} else if (i == p1.length() && j == p2.length()) {
			res = "";
		} else if (i == p1.length()) {
			res = p2.charAt(j) + Merge(p1, i, p2, j + 1);
		} else if (j == p2.length()) {
			res = p1.charAt(i) + Merge(p1, i + 1, p2, j);
		} else if (p1.charAt(i) > p2.charAt(j)) {
			res = p1.charAt(i) + Merge(p1, i + 1, p2, j);
		} else if (p2.charAt(j) > p1.charAt(i)) {
			res = p2.charAt(j) + Merge(p1, i, p2, j + 1);
		}

		return res;
	}

	public static long plants(long a, long b) {
		long r = 0;
		if (a == 0) {
			r = b;
		} else {
			a = a - 1;
			b = b - 1;
			for (int i = 1; i < a; i *= 2) {
				r++;
			}
			r = plants(a, b);
			r = r * (a + b);
		}
		return r;
	}

}
