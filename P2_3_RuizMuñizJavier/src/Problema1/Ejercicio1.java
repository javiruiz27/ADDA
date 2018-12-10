package Problema1;

import us.lsi.tiposrecursivos.BinaryTree;

public class Ejercicio1 {

	/* Decidir si un árbol binario es equilibrado */
	/*
	 * Un árbol equilibrado es un árbol binario de búsqueda en el que para cada nodo el número de niveles
	 * de sus subárboles izquierdo y derecho no debe diferir en más de una unidad.
	 */
	
	//1.- Crear un árbol binario de búsqueda.
	/*Sea h el número de niveles, la condición que se debe cumplir para que sea equilibrado es que 2^(h-1) 
	 * sea igual al número de nodos*/

	public static <E> void main(String[] args) {
		
		System.out.println(esEquilibrado());

	}

	private static <E> Boolean esEquilibrado(BinaryTree<E> tree) {
		
		return null;
	}
	
	

}
