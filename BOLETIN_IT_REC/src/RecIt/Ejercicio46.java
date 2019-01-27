package RecIt;

public class Ejercicio46 {
	/*
	 * 46. Dado un número ?, compruebe que es el número es Stella Octangula o no. Un
	 * número es Stella Octangula si es de la forma ? = ?(2?2 − 1) donde ? es un
	 * número entero. Usar búsqueda binaria
	 */
	
	public static void main(String[] args) {
		
		System.out.println(stellaOctangula(14, 1, 14, 7));

	}
	
	public static Integer stellaOctangula(Integer m, int i, int j, int n) {
		Integer res;
		
		if(m == n*(2*(n*n) - 1)) {
			res = n;
		}else {
			if(m < n*(2*(n*n) - 1)) {
				res = stellaOctangula(m, i, n, (i+n)/2);
			}else{
				res = stellaOctangula(m, n, j, (n+j)/2);
			}
		}
		return res;
	}

}
