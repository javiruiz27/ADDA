package Problema4;


public class Camino {
	
	
	public static Camino create() {
		return new Camino();
	}

	public static Camino create(Lugar c1, Lugar c2) {
		return new Camino(c1,c2);
	}

	public static Camino create(Lugar c1, Lugar c2, String[] formato) {
		return new Camino(c1,c2,formato);
	}

	public static Camino create(Lugar c1, Lugar c2, Double tiempo) {
		return new Camino(c1, c2, tiempo);
	}
	
	private static Integer num = 0;
	private Lugar comienzo;
	private Lugar destino;
	private Double tiempo;
	private Integer id;
	

	private Camino(Lugar com, Lugar dest) {
		this.comienzo = com;
		this.destino = dest;
		this.tiempo = 0.;
		this.id = num;
		num++;
	}
	
	private Camino() {
		this.comienzo = null;
		this.destino = null;
		this.tiempo = 0.;
		this.id = num;
		num++;
	} 
	private Camino(Lugar c1, Lugar c2, Double tiempo) {
		this.comienzo = c1;
		this.destino = c2;
		this.tiempo = tiempo;
		this.id = num;
		num++;
	}
	
	private Camino(Lugar c1, Lugar c2, String[] nombre) {
		this.comienzo = c1;
		this.destino = c2;
		this.tiempo = Double.parseDouble(nombre[2]);
		this.id = num;
		num++;
	}
	
	
	
	public Lugar getComienzo() {
		return comienzo;
	}
	public Lugar getDestino() {
		return destino;
	}
	public Double getTiempo() {
		return tiempo;
	}
	
	@Override
	public String toString() {
		return "Camino [comienzo=" + comienzo + ", destino=" + destino + ", tiempo=" + tiempo + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Camino))
			return false;
		Camino other = (Camino) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	

}
