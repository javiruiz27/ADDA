package Problema1;

import java.util.Arrays;
import java.util.List;

public class Barrios {

	private String nombre;
	private List<String> vecinos;
	
	public Barrios(String nombre, List<String> vecinos) {
		super();
		this.nombre = nombre;
		this.vecinos = vecinos;
	}

	// Create de Barrios
	public static Barrios create(String s) {
		String[] t = s.split(",");
		String nombre = t[0];
		List<String> vecinos = Arrays.asList(t);
		return new Barrios(nombre,vecinos);
	}
//		numBarrio = Integer.parseInt(t[0]);
//		for (int i = 1; i < t.length - 1; i++) {
//			colindantes.add(Integer.parseInt(t[i]));
//		}

	@Override
	public String toString() {
		return "Barrios [nombre=" + nombre + ", vecinos=" + vecinos + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((vecinos == null) ? 0 : vecinos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Barrios other = (Barrios) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (vecinos == null) {
			if (other.vecinos != null)
				return false;
		} else if (!vecinos.equals(other.vecinos))
			return false;
		return true;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<String> getVecinos() {
		return vecinos;
	}

	public void setVecinos(List<String> vecinos) {
		this.vecinos = vecinos;
	}

	

	
}
