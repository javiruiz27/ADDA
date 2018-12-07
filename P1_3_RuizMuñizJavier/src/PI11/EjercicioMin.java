package PI11;

import java.util.ArrayList;
import java.util.List;

public class EjercicioMin {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("Hola");
		l.add("JaJAJA");
		l.add("ReSult");
		String res;
		
		res = calcula(l);
		System.out.println("Cadena con más minúsculas (calcula): "+res);
		
		res = calculaR(l,"");
		System.out.println("Cadena con más minúsculas (calculaR): "+res);
	}
	
	private static String calcula(List<String> l){
		Integer i = 0;
		String res = null;
		Integer nres = 0;
		while (i < l.size()){
			if (res == null || minusculas(l.get(i)) > nres){
				res = l.get(i);
				nres = minusculas(l.get(i));
			}
			i++;
		}
		return res;
	}
	private static String calculaR(List<String> l, String s){
		if (l.size() == 0){
			return s;
		} else {
			List<String> l2 = new ArrayList<>(l);
			l2.remove(0);
			if (minusculas(l.get(0)) > minusculas(s)){
				return calculaR(l2,l.get(0));
			} else {
				return calculaR(l2,s);
			}
		}
	}
	
	private static Integer minusculas(String s){
		Integer res = 0;
		for(int i = 0; i < s.length(); i++)
			if(s.charAt(i) >= 97 && s.charAt(i) <= 122)
				res++;
		return res;
	}

}
