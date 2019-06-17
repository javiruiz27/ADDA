package Problema2;

public class Oportunidades {

	private Integer beneficio, capital;
	
	public static Oportunidades create(String s) {
		return new Oportunidades(s);
	}
	private Oportunidades(String s) {
		String[] t = s.split(",");
		capital = Integer.parseInt(t[0]);
		beneficio= Integer.parseInt(t[1]);
	}
	
	public Integer getBeneficio() {
		return beneficio;
	}
	public Integer getCapital() {
		return capital;
	}
}
