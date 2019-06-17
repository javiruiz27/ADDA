package ejercicio1;

import java.util.Arrays;
import java.util.List;

import us.lsi.graphs.GraphView;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPD;

public class ProblemaBicicletaPD<V, E>
		implements ProblemaPD<String, ProblemaBicicletaPD.Alternativas, ProblemaBicicletaPD<V, E>> {

	public enum Alternativas {
		YES, NO
	};

	private Integer i;
	private Integer j;
	private Integer k;
	private GraphView<V, E> grafo;

	public ProblemaBicicletaPD(Integer i, Integer j, Integer k, GraphView<V, E> grafo) {
		super();
		this.i = i;
		this.j = j;
		this.k = k;
		this.grafo = grafo;
	}

	public static <V, E> ProblemaBicicletaPD create(int i, int j, int k, GraphView<V, E> grafo) {
		return new ProblemaBicicletaPD<V, E>(i, j, k, grafo);
	}

	public static <V, E> ProblemaBicicletaPD create(int i, int j, GraphView<V, E> grafo) {
		return new ProblemaBicicletaPD<V, E>(i, j, 0, grafo);
	}

	@Override
	public Tipo getTipo() {
		return Tipo.Min;
	}

	@Override
	public int size() {
		return this.grafo.getNumVertices() - k;
	}

	@Override
	public boolean esCasoBase() {
		return (i == k) || (grafo.getNumVertices() == k);
	}

	@Override
	public Sp<Alternativas> getSolucionParcialCasoBase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProblemaBicicletaPD<V, E> getSubProblema(Alternativas a, int np) {
		ProblemaBicicletaPD<V, E> res = null;
		switch (a) {
		case NO:
			res = ProblemaBicicletaPD.create(i, j, k + 1, grafo);
			break;
		case YES:
			switch (np) {
			case 0:
				res = ProblemaBicicletaPD.create(i, j, k + 1, grafo);

				break;

			case 1:
				res = ProblemaBicicletaPD.create(i, j, k + 1, grafo);
				break;
			default:
				throw new IllegalArgumentException("El nº del " + "subproblema no puede ser:" + np);
			}
			break;
		}
		return res;
	}

	@Override
	public Sp<Alternativas> getSolucionParcialPorAlternativa(Alternativas a, List<Sp<Alternativas>> ls) {
		Sp<Alternativas> res = Sp.create(a, ls.get(0).propiedad);
		switch (a) {
		case NO:
			break;
		case YES:
			res.propiedad += ls.get(1).propiedad;
			break;
		}
		return res;
	}

	@Override
	public List<Alternativas> getAlternativas() {
		List<Alternativas> res = null;
		if (i == k || k == j) {
			res = Arrays.asList(Alternativas.NO);
		} else {
			res = Arrays.asList(Alternativas.values());
		}
		return res;
	}

	@Override
	public int getNumeroSubProblemas(Alternativas a) {
		return a.equals(Alternativas.NO) ? 1 : 2;
	}

	@Override
	public String getSolucionReconstruidaCasoBase(Sp<Alternativas> sp) {
		return grafo.getVertice(i) + "<" + sp.propiedad + ">" + grafo.getVertice(j);
	}

	@Override
	public String getSolucionReconstruidaCasoRecursivo(Sp<Alternativas> sp, List<String> ls) {
		String res = "";
		switch (sp.alternativa) {
		case NO:
			res = ls.get(0);
			break;
		case YES:
			res = ls.get(0) + ", " + ls.get(1);
			break;
		}
		return res;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((i == null) ? 0 : i.hashCode());
		result = prime * result + ((j == null) ? 0 : j.hashCode());
		result = prime * result + ((k == null) ? 0 : k.hashCode());
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
		ProblemaBicicletaPD other = (ProblemaBicicletaPD) obj;
		if (i == null) {
			if (other.i != null)
				return false;
		} else if (!i.equals(other.i))
			return false;
		if (j == null) {
			if (other.j != null)
				return false;
		} else if (!j.equals(other.j))
			return false;
		if (k == null) {
			if (other.k != null)
				return false;
		} else if (!k.equals(other.k))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProblemaBicicletaPD [i=" + i + ", j=" + j + ", k=" + k + "]";
	}

}