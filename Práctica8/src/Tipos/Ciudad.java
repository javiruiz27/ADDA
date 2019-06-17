package Tipos;

public class Ciudad {

	private String nombre;
	private Double poblacion;

	public static Ciudad create(String[] s) {
		return new Ciudad(s[0], Double.parseDouble(s[1]));
	}
	
	public static Ciudad create(String nombre) {
		return new Ciudad(nombre, null);
	}
	
	public static Ciudad create() {
		return new Ciudad("", null);
	}

	public Ciudad(String nombre, Double poblacion) {
		super();
		this.nombre = nombre;
		this.poblacion = poblacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Double poblacion) {
		this.poblacion = poblacion;
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
		Ciudad other = (Ciudad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertice [nombre=" + nombre + "]";
	}

}
