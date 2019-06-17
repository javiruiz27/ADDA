package Problema1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import us.lsi.common.Tuple;
import us.lsi.common.Tuple2;
import us.lsi.pd.AlgoritmoPD;

public class TestParticionPD {

	public static void main(String[] args) throws Exception {

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

		AlgoritmoPD.isRandomize = false;

		ParticionPD p = ParticionPD.createInitial(listaBase);

		var a = AlgoritmoPD.createPDR(p);
		a.ejecuta();

		System.out.println("Solucion: " + a.getSolucion());

	}

}
