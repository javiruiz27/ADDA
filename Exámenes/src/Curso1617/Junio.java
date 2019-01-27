package Curso1617;

public class Junio {

	public static void main(String[] args) {
		
		int[] v = {23, 56, 7, 33, 12};
		
		System.out.println(f(v, 1, 3, 0));

	}

	public static int f(int[] v, int a, int b, int ac) {
		int r;
		if (b <= a || v[b] == a * a) {
			r = ac;
		} else {
			int i = b - a;
			while (i >= 1) {
				int j = 0;
				while (j <= i) {
					ac = ac + v[j];
					j = j + 2;
				}
				i = i / 3;
			}
			r = f(v, a + 1, b - 1, ac);
		}
		return r;
	}

}
