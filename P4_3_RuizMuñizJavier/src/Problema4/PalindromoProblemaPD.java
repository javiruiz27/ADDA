package Problema4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPD;

public class PalindromoProblemaPD implements ProblemaPD<String, Integer, PalindromoProblemaPD> {

	private String lista;
	private int i, j;

	public static PalindromoProblemaPD create(String lista, int i, int j) {
		return new PalindromoProblemaPD(lista, i, j);
	}

	private PalindromoProblemaPD(String lista, int i, int j) {
		super();
		this.lista = lista;
		this.i = i;
		this.j = j;
	}

	public String getLista() {
		return lista;
	}

	public Integer getI() {
		return i;
	}

	public Integer getJ() {
		return j;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
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
		PalindromoProblemaPD other = (PalindromoProblemaPD) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[lista=" + lista + ", i=" + i + ", j=" + j + "]";
	}

	public Tipo getTipo() {
		return Tipo.Min;
	}

	public int size() {
		return j - i;
	}

	public boolean esCasoBase() {
		return esPalindromo(lista.substring(i, j));
	}

	public Sp<Integer> getSolucionParcialCasoBase() {
		return Sp.create(j, 1.0);
	}

	// Posibles posiciones siguientes desde i a j
	public List<Integer> getAlternativas() {
		return IntStream.range(i + 1, j).boxed().collect(Collectors.toList());
	}

	public PalindromoProblemaPD getSubProblema(Integer a, int np) {
		PalindromoProblemaPD res = null;
		if (np == 0) {
			res = new PalindromoProblemaPD(lista, i, a);
		} else {
			res = new PalindromoProblemaPD(lista, a, j);
		}
		return res;
	}

	// Dos tipos: que se pretenda calcular el esPalindromo(i,a) o esPalindromo(a,j)
	public int getNumeroSubProblemas(Integer a) {
		return 2;
	}

	public String getSolucionReconstruidaCasoBase(Sp<Integer> sp) {

		return lista.substring(i, j);
	}

	public Sp<Integer> getSolucionParcialPorAlternativa(Integer a, List<Sp<Integer>> ls) {
		return Sp.create(a, ls.get(0).propiedad + ls.get(1).propiedad);
	}

	public String getSolucionReconstruidaCasoRecursivo(Sp<Integer> sp, List<String> ls) {
		return ls.get(0) + "|" + ls.get(1);
	}

	// ¿Es palíndromo?
	private static boolean esPalindromo(String cadena2) {
		Boolean res = true;
		int i = 0;
		while (i < cadena2.length() / 2) {
			res = res && cadena2.charAt(i) == cadena2.charAt(cadena2.length() - 1 - i);
			i++;
		}
		return res;
	}

}
