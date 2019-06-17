package ejercicio1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.graphs.GraphView;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPD;

public class ProblemaBicicletasPD<V, E> implements ProblemaPD<String, Boolean, ProblemaBicicletasPD<V, E>> {

	private int i;
	private int j;
	private int k;
	private GraphView<V, E> grafo;

	private ProblemaBicicletasPD(int i, int j, int k, GraphView<V, E> grafo) {
		super();
		this.i = i;
		this.j = j;
		this.k = k;
		this.grafo = grafo;
	}

	//Create para el getSubProblema
	public static <V, E> ProblemaBicicletasPD<V, E> create(int i, int j, int k, GraphView<V, E> grafo) {
		return new ProblemaBicicletasPD<>(i, j, k, grafo);
	}

	//Create para el test
	public static <V, E> ProblemaBicicletasPD<V, E> create(int i, int j, GraphView<V, E> grafo) {
		return new ProblemaBicicletasPD<>(i, j, 0, grafo);
	}

	public Tipo getTipo() {
		return Tipo.Min;
	}

	public int size() {
		return grafo.getNumVertices() - k;
	}

	public boolean esCasoBase() {
		return i == j || k == grafo.getNumVertices();
	}

	public Sp<Boolean> getSolucionParcialCasoBase() {
		Sp<Boolean> result = null;

		if (i == j) {
			result = Sp.create(false, 0.0);
		} else if (grafo.isEdge(i, j)) {
			Double peso = grafo.getWeight(i, j);
			result = Sp.create(false, peso);
		}

		return result;
	}

	public ProblemaBicicletasPD<V, E> getSubProblema(Boolean a, int np) {

		ProblemaBicicletasPD<V,E> r = null;
		if(a==false) {
			r = ProblemaBicicletasPD.create(i,j,k+1,grafo);
		}else {
			if(np==0) {
				r= ProblemaBicicletasPD.create(i, k, k+1, grafo);
			}else if(np==1) {
				r= ProblemaBicicletasPD.create(k, j, k+1, grafo);
			}else {
				throw new IllegalArgumentException(
						"El número del subproblema no puede ser " +np);
			}
			 
		}
		return r;
	}

	public Sp<Boolean> getSolucionParcialPorAlternativa(Boolean a, List<Sp<Boolean>> ls) {
		Sp<Boolean> r = Sp.create(a, ls.get(0).propiedad);
		if(a==true) {
			r=Sp.create(true, ls.get(0).propiedad+ls.get(1).propiedad);
		}else {
			r=Sp.create(a,ls.get(0).propiedad);
		}
		return r;
	}

	public List<Boolean> getAlternativas() {
		List<Boolean> result = new ArrayList<>();

		if (i == k || k == j) {
			result.add(false);
		} else {
			result.add(false);
			result.add(true);
			// Si fuera Enum, sería Enumerado.values()
//			if(i==k || k==j) {
//				return Arrays.asList(false);
//			}else {
//				return Arrays.asList(false,true);
//			}
		}

		return result;
	}

	public int getNumeroSubProblemas(Boolean a) {
		if(a==false) {
			return 1;
		}else {
			return 2;
		}
	}

	public String getSolucionReconstruidaCasoBase(Sp<Boolean> sp) {
		return grafo.getVertice(i) + "<" + sp.propiedad + ">" + grafo.getVertice(j);
	}

	public String getSolucionReconstruidaCasoRecursivo(Sp<Boolean> sp, List<String> ls) {
		String result = "";
		if (sp.alternativa.equals(false)) {

			result = ls.get(0);

		} else if (sp.alternativa.equals(true)) {

			result = ls.get(0) + ", " + ls.get(1);

		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grafo == null) ? 0 : grafo.hashCode());
		result = prime * result + i;
		result = prime * result + j;
		result = prime * result + k;
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
		ProblemaBicicletasPD<?, ?> other = (ProblemaBicicletasPD<?, ?>) obj;
		if (grafo == null) {
			if (other.grafo != null)
				return false;
		} else if (!grafo.equals(other.grafo))
			return false;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		if (k != other.k)
			return false;
		return true;
	}

	public String toString() {
		return "ProblemaBicicletasPD [i=" + i + ", j=" + j + ", k=" + k + "]";
	}

}
