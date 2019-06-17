package Problema1;

import java.util.ArrayList;
import java.util.List;

import us.lsi.bt.EstadoBT;
import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;

public class EstadoP1BT implements EstadoBT<Tuple2<List<Integer>, List<Integer>>, Boolean, EstadoP1BT> {

	public static EstadoP1BT create(Integer index, List<Integer> lista, List<Integer> listaSolucion1,
			List<Integer> listaSolucion2) {
		return new EstadoP1BT(index, lista, listaSolucion1, listaSolucion2);
	}

	private Integer index;
	private List<Integer> lista;
	private List<Integer> listaSolucion1;
	private List<Integer> listaSolucion2;

	private EstadoP1BT(Integer index, List<Integer> lista, List<Integer> listaSolucion1, List<Integer> listaSolucion2) {
		super();
		this.index = index;
		this.lista = lista;
		this.listaSolucion1 = listaSolucion1;
		this.listaSolucion2 = listaSolucion2;
	}

	public Integer getIndex() {
		return index;
	}

	public List<Integer> getLista() {
		return lista;
	}

	public List<Integer> getListaSolucion1() {
		return listaSolucion1;
	}

	public List<Integer> getListaSolucion2() {
		return listaSolucion2;
	}

	public Tipo getTipo() {
		return Tipo.Min;
	}

	public EstadoP1BT getEstadoInicial() {
		if(calculaCapacidad(lista)%2!=0) {
			throw new IllegalArgumentException("La suma debe ser par");
		}
		return EstadoP1BT.create(0, lista, new ArrayList<Integer>(0), new ArrayList<Integer>(0));
	}

	public EstadoP1BT avanza(Boolean a) {
		List<Integer> copia1 = new ArrayList<Integer>(this.listaSolucion1);
		List<Integer> copia2 = new ArrayList<Integer>(this.listaSolucion2);

		if (a) {
			copia1.add(this.lista.get(this.index));
			this.index = this.index + 1;
		} else if (!a) {
			copia2.add(this.lista.get(this.index));
			this.index = this.index + 1;
		}
		
		this.listaSolucion1 = copia1;
		this.listaSolucion2 = copia2;
		return new EstadoP1BT(index, lista, listaSolucion1, listaSolucion2);
	}

	public EstadoP1BT retrocede(Boolean a) {
		List<Integer> copia1 = new ArrayList<Integer>(this.listaSolucion1);
		List<Integer> copia2 = new ArrayList<Integer>(this.listaSolucion2);
		if (a) {
			copia1.remove(this.lista.get(this.index-1));
			this.index = this.index - 1;
		} else if (!a) {
			copia2.remove(this.lista.get(this.index-1));
			this.index = this.index - 1;
		}

		this.listaSolucion1 = copia1;
		this.listaSolucion2 = copia2;
		return new EstadoP1BT(index, lista, listaSolucion1, listaSolucion2);
	}

	public int size() {
		return lista.size() - index;
	}

	public boolean esCasoBase() {

		return lista.size() == index;
	}

	public List<Boolean> getAlternativas() {
		List<Boolean> res = new ArrayList<>();
		if ((calculaCapacidad(listaSolucion1) + this.lista.get(index)) <= calculaCapacidad(lista) / 2) {
			res.add(true);
		} else {
			res.add(false);
		}
		return res;
	}

	@Override
	public Tuple2<List<Integer>, List<Integer>> getSolucion() {
		return Tuple.create(this.listaSolucion1, this.listaSolucion2);
	}

	public Double getObjetivo() {
		return (double) calculaCapacidad(listaSolucion1) == calculaCapacidad(lista)/2 ? 
				(double) calculaCapacidad(listaSolucion1):
			null;
	}



	///////////////////////////////////////////////////////////////////////

//	public Boolean comparaCapacidad(List<Integer> l) {
//		Boolean res = false;
//		if (calculaCapacidad(l) + lista.get(index) <= calculaCapacidad(lista) / 2) {
//			res = true;
//		}
//		return res;
//	}

	public static Integer calculaCapacidad(List<Integer> res) {
		return res.stream().mapToInt(x -> x).sum();
	}

	public static void main(String[] args) {
		List<Integer> listaBase = new ArrayList<Integer>();
		listaBase.add(1);
		listaBase.add(3);
		listaBase.add(1);
		listaBase.add(1);
		listaBase.add(2);
		listaBase.add(5);
		listaBase.add(8);
		listaBase.add(10);
		listaBase.add(6);
		listaBase.add(11);

		System.out.println(calculaCapacidad(listaBase) / 2);
	}

}
