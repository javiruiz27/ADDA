package RecIt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ejercicio40 {

	// Buscar si el elemento e está contenido en lista ls.
	// a) Si la lista es sin ordenar
	// b) Si la lista está ordenada

	public static <T extends Comparable<T>> void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		List<Integer> lOrd = new ArrayList<>();

		l.add(2);
		l.add(5);
		l.add(8);
		l.add(1);
		l.add(3);
		l.add(2);
		l.add(9);

		lOrd.add(1);
		lOrd.add(2);
		lOrd.add(3);
		lOrd.add(4);
		lOrd.add(5);
		lOrd.add(6);
		lOrd.add(7);

		System.out.println(busqueda(l,185));
		System.out.println(buscaElem(l, 185, 0));
		System.out.println(busquedaB(lOrd, 185, 0, lOrd.size()-1, (0+lOrd.size()-1)/2));

	}
	
	/*
	 * COMPLEJIDAD DEL ALGORITMO RECURSIVO 
	 * Tamaño: l.size()
	 * T(n) = 1*T(n-1) + O(n)
	 * 
	 * COMPLEJIDAD DE LA BÚSQUEDA BINARIA
	 * Tamaño: n = l.size()
	 * T(n) = 1*T(n/2) + O(n*log(n))
	 * */
	
	public static Boolean busqueda(List<Integer> l, int e) {
		Boolean res = false;
		int i = 0;
		while(i<l.size()) {
			if(e == l.get(i)) {
				res = true;
				break;
			}
			i++;
		}
		
		return res;
	}

	public static Boolean buscaElem(List<Integer> l, int e, int i) {
		Boolean res;
		if(l.get(i).equals(e)) {
			res = true;
			
		}else if(i == l.size()-1){
			res = false;
		}else {
			res = buscaElem(l, e, i+1);
		}
	
		return res;
	}

	//Resolución con búsqueda binaria
	public static Boolean busquedaB(List<Integer> lOrd, int e, int i , int j, int k) {
		Boolean res;
		if(i == j) {
			res = false;
		}else if(lOrd.get(i)==e || lOrd.get(j)==e || lOrd.get(k) == e) {
			res = true;
		}else {
			if(lOrd.get(k)>e) {
				res = busquedaB(lOrd, e, i, k, (i+k)/2);
			}else {
			res = busquedaB(lOrd, e, k+1, j, (k+1+j)/2);	
				
			}
			
		}
		
		return res;
	}

}
