package Curso1617;

public class ll {

	public static void main(String[] args) {
		
		System.out.println(plants(2,3));

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
