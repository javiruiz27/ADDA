package E2;

import java.time.Duration;

public interface Cancion {

	void setNombre(String nombre);

	void setDuracion(Duration duracion);

	String getNombre();

	Duration getDuracion();

	int hashCode();

	boolean equals(Object obj);

}