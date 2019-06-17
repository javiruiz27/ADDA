package Problema1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;
import us.lsi.pd.AlgoritmoPD.Sp;
import us.lsi.pd.AlgoritmoPD.Tipo;
import us.lsi.pd.ProblemaPDR;

public class ParticionPD implements ProblemaPDR<Tuple2<List<Integer>, List<Integer>>, Boolean, ParticionPD> {

	public static ParticionPD createInitial(List<Integer> listaOrig) {
		if (listaOrig.stream().mapToInt(x -> x).sum() % 2 != 0) {
			return null;
		}
		lista = listaOrig;
		return create(0, Tuple.create(new ArrayList<>(), new ArrayList<>()),
				listaOrig.stream().mapToInt(x -> x).sum() / 2);
	}

	////////////////////////////////////////////////////////////////////////////////////
	public static List<Integer> lista;

	private int index;
	private Tuple2<List<Integer>, List<Integer>> listasSolucion;

	private final Integer capacidadTotalInicial;
	
	////////////////////////////////////////////////////////////////////////////////////

	private ParticionPD(Integer index, Tuple2<List<Integer>, List<Integer>> listasSolucion,
			Integer capacidadTotalInicial) {
		super();
		this.index = index;
		this.listasSolucion = listasSolucion;
		this.capacidadTotalInicial = sumaElementosLista(lista) / 2;
	}

	public static ParticionPD create(Integer index, Tuple2<List<Integer>, List<Integer>> listasSolucion,
			Integer capacidadTotalInicial) {
		return new ParticionPD(index, listasSolucion, capacidadTotalInicial);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////

	public Tipo getTipo() {
		return Tipo.Min;
	}

	public int size() {
		return lista.size() - this.index;
	}

	public boolean esCasoBase() {
		return this.index == lista.size();
	}

	public Sp<Boolean> getSolucionParcialCasoBase() {
		Sp<Boolean> res = null;
		if (checkSumasIguales()) {
			return Sp.create(null, (double) Math.min(this.listasSolucion.v1.size(), this.listasSolucion.v2.size()));
		}
		return res;
	}

	public Sp<Boolean> getSolucionParcialPorAlternativa(Boolean a, Sp<Boolean> s) {
		return Sp.create(a,
				(double) Math.min(this.listasSolucion.v1.size(), this.listasSolucion.v2.size() + s.propiedad));
	}

	public ParticionPD getSubProblema(Boolean a) {

		Tuple2<List<Integer>, List<Integer>> copiaListasSolucion = this.listasSolucion;
		Integer copiaCapacidadTotalInicial = this.capacidadTotalInicial;

		if (a) {
			if (checkCapacidadSuficiente(copiaListasSolucion.v1)) {
				copiaListasSolucion.v1.add(lista.get(index));
			}
		} else if (!a) {
			if (checkCapacidadSuficiente(copiaListasSolucion.v2)) {
				copiaListasSolucion.v2.add(lista.get(index));
			}
		}
		this.listasSolucion = copiaListasSolucion;
		return new ParticionPD(index + 1, listasSolucion, copiaCapacidadTotalInicial);
	}

	public List<Boolean> getAlternativas() {
		List<Boolean> res = new ArrayList<Boolean>();
		if (checkCapacidadSuficiente(this.listasSolucion.v1)) {
			res.add(true);
		} else if (checkCapacidadSuficiente(this.listasSolucion.v2)) {
			res.add(false);
		}
		return res;
	}

	public Tuple2<List<Integer>, List<Integer>> getSolucionReconstruidaCasoBase(Sp<Boolean> sp) {
		return Tuple.create(new ArrayList<Integer>(), new ArrayList<Integer>());
	}

	public Tuple2<List<Integer>, List<Integer>> getSolucionReconstruidaCasoRecursivo(Sp<Boolean> sp,
			Tuple2<List<Integer>, List<Integer>> s) {
		Tuple2<List<Integer>, List<Integer>> res = s == null ? this.listasSolucion : s;
		if (sp.alternativa && checkCapacidadSuficiente(listasSolucion.v1)) {
			res.v1.add(lista.get(this.index));
		} else if (!sp.alternativa && checkCapacidadSuficiente(listasSolucion.v2)) {
			res.v2.add(lista.get(this.index));
		}
		return res;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////

	public Boolean checkSumasIguales() {
		return sumaElementosLista(this.listasSolucion.v1) == sumaElementosLista(this.listasSolucion.v2);
	}

	public Boolean checkCapacidadSuficiente(List<Integer> l) {
		return this.capacidadTotalInicial - sumaElementosLista(l) - getElementoActual() >= 0;
	}

	public Integer sumaElementosLista(List<Integer> l) {
		return l.stream().mapToInt(x -> x).sum();
	}

	public Integer getElementoActual() {
		return lista.get(this.index);
	}

}
