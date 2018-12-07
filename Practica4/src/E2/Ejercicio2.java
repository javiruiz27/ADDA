package E2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ejercicio2 {

	public static void main(String[] args) {
		List<Cancion> canciones = cancionesTest();
		Cancion c = ProblemasDeListas.getKesimo(canciones, 3, Comparator.comparing(Cancion::getDuracion));
		System.out.println("La canci�n enposici�n 3 seg�n duraci�n ser�a: " + c);

	}

	private static List<Cancion> cancionesTest() {
		List<Cancion> res = new ArrayList<>();
		res.add(new CancionImpl("Canci�n 1", Duration.ofSeconds(200)));
		res.add(new CancionImpl("Canci�n 2", Duration.ofSeconds(100)));
		res.add(new CancionImpl("Canci�n 3", Duration.ofSeconds(80)));
		res.add(new CancionImpl("Canci�n 4", Duration.ofSeconds(300)));
		res.add(new CancionImpl("Canci�n 5", Duration.ofSeconds(220)));
		res.add(new CancionImpl("Canci�n 6", Duration.ofSeconds(150)));
		res.add(new CancionImpl("Canci�n 7", Duration.ofSeconds(60)));
		
		return res;
	}

}
