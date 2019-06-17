package Tipos;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Carretera extends DefaultWeightedEdge{

	private static int numObjs = 0;

	private Ciudad v1, v2;
	private String nombre;
	private Double kms;
	private int id;
	
	public static Carretera create(Ciudad c1, Ciudad c2, String[] tokens) {
		return new Carretera(c1, c2, tokens[2], Double.parseDouble(tokens[3]));
		
	}
	
	public static Carretera create(Ciudad origen, Ciudad destino) {
		return new Carretera(origen, destino, null, null);
	}
	
	public static Carretera create() {
		return new Carretera(null, null, null, null);
	}

	public Carretera(Ciudad v1, Ciudad v2, String nombre, Double kms) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.nombre = nombre;
		this.kms = kms;
		id = ++numObjs;
	}

	public Ciudad getV1() {
		return v1;
	}

	public Ciudad getV2() {
		return v2;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getKms() {
		return kms;
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
		if (getClass() != obj.getClass())
			return false;
		Carretera other = (Carretera) obj;
		if (v1 == null) {
			if (other.v1 != null)
				return false;
		} else if (!v1.equals(other.v1))
			return false;
		if (v2 == null) {
			if (other.v2 != null)
				return false;
		} else if (!v2.equals(other.v2))
			return false;
		return true;
	}
	
	public String toString() {
		return getNombre() + "(" + getKms() + "kms)";
	}

}
