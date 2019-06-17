package Problema1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import us.lsi.bt.AlgoritmoBT;

public class TestBT {

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

//		listaBase.add(1);
//		listaBase.add(1);
//		listaBase.add(2);

		Collections.sort(listaBase, Collections.reverseOrder());

		System.out.println(listaBase);
		AlgoritmoBT.metricasOK = true;

		EstadoP1BT pBT = EstadoP1BT.create(0, listaBase, new ArrayList<>(), new ArrayList<>());

		var a = AlgoritmoBT.create(pBT);
		a.ejecuta();
		System.out.println(a.getSolucion().v1.toString());
		System.out.println(a.getSolucion().v2.toString());
		System.out.println(a.getSolucion().toString());
		System.out.println(AlgoritmoBT.metricas);

	}

}
