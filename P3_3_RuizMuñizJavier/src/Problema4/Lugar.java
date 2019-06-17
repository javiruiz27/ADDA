package Problema4;


public class Lugar {
	
	private String nombre;
	
	public static Lugar create(String nombre) {
		return new Lugar(nombre);
	}
	public static Lugar create(String[] formato) {
		return new Lugar(formato[0]);
	}
	public static Lugar create() {
		return new Lugar("");
	}

	public Lugar(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Lugar other = (Lugar) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	public String toString() {
		return "" + nombre;
	}

}
