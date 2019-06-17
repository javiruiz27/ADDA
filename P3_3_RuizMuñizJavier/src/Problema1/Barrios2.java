package Problema1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import us.lsi.common.Streams2;

public class Barrios2 {

	private String nombre;
	private List<Barrios2> vecinos;


	public static Barrios2 create(String fichero) {
		String nombre = fichero.split(",")[0];
		return create(nombre);
	}

	public Barrios2(String nombre) {
		this.nombre = nombre;
		this.vecinos = new ArrayList<Barrios2>();
	}

	public String getNombre() {
		return nombre;
	}

	public List<Barrios2> getVecinos() {
		return vecinos;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setVecinos(List<Barrios2> vecinos) {
		this.vecinos = vecinos;
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
		Barrios2 other = (Barrios2) obj;
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

	@Override
	public String toString() {
		return "Barrios2 [nombre=" + nombre + ", vecinos=" + vecinos + "]";
	}

}
