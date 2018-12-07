package Problemas;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.ListMultimap;
import us.lsi.geometria.Punto2D;
import us.lsi.geometria.Punto2D.Cuadrante;

public class Ejercicio2 {
	
	public static void main(String[] args) {
		List<Punto2D> puntos = creaPuntos();
		System.out.println(separaPuntosWhile(puntos));
		System.out.println(separaPuntosJava10(puntos));

	}
	

	public static ListMultimap<Cuadrante, List<Punto2D>> separaPuntosJava10(List<Punto2D> puntos) {
		ListMultimap<Cuadrante, List<Punto2D>> res = new ListMultimap<Cuadrante, List<Punto2D>>();
		var contador = 0;
		while(puntos.size()>contador) {
			if(res.containsKey(puntos.get(contador).getCuadrante())) {
				res.get(puntos.get(contador).getCuadrante());
			}else {
				List<Punto2D> nueva = new ArrayList<Punto2D>();
				nueva.add(puntos.get(contador));
				res.put(puntos.get(contador).getCuadrante(), nueva);
			}
			contador++;
		}
		

		return res;
	}

	
	public static ListMultimap<Cuadrante, Punto2D> separaPuntosWhile(List<Punto2D> ptos) {
		return null;
	}

	public static List<Punto2D> creaPuntos() {
		List<Punto2D> res = new ArrayList<>();
		res.add(Punto2D.create(-2.0, -4.5));
		res.add(Punto2D.create(2.0, 4.5));
		res.add(Punto2D.create(2.0, -4.5));
		res.add(Punto2D.create(-2.0, 4.5));

		return res;
	}


}
