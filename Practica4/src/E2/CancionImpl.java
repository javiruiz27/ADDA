package E2;

import java.time.Duration;

public class CancionImpl implements Cancion {
	
	private String nombre;
	private Duration duracion;
	public CancionImpl(String nombre, Duration duracion) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
	}
	/* (non-Javadoc)
	 * @see E2.Cancion#setNombre(java.lang.String)
	 */
	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/* (non-Javadoc)
	 * @see E2.Cancion#setDuracion(java.time.Duration)
	 */
	@Override
	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}
	/* (non-Javadoc)
	 * @see E2.Cancion#getNombre()
	 */
	@Override
	public String getNombre() {
		return nombre;
	}
	/* (non-Javadoc)
	 * @see E2.Cancion#getDuracion()
	 */
	@Override
	public Duration getDuracion() {
		return duracion;
	}
	/* (non-Javadoc)
	 * @see E2.Cancion#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duracion == null) ? 0 : duracion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see E2.Cancion#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CancionImpl other = (CancionImpl) obj;
		if (duracion == null) {
			if (other.duracion != null)
				return false;
		} else if (!duracion.equals(other.duracion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	

}
