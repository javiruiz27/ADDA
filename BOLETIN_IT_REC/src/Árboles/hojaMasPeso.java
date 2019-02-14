package Árboles;

import us.lsi.tiposrecursivos.Tree;

public class hojaMasPeso {

	public static <E> void main(String[] args) {
		Tree<Integer> t4 = Tree.leaf(4);
		Tree<Integer> t5 = Tree.leaf(5);
		Tree<Integer> t6 = Tree.leaf(56);
		Tree<Integer> t7 = Tree.leaf(66);
		Tree<Integer> t8 = Tree.empty();
		Tree<Integer> t3 = Tree.nary(7, t7, t8);
		Tree<Integer> t2 = Tree.nary(8, t5, t6);
		Tree<Integer> t = Tree.nary(12, t2, t3, t4);
		
		System.out.println(etqMasPesada(t));
	}

	public static Tree<Integer> etqMasPesada(Tree<Integer> t) {
		
		Tree<Integer> res = t;

		switch (t.getType()) {
		case Empty:
			break;
		case Leaf:
			res = t;
		case Nary:
			Integer n = t.getNumOfChildren();
			while(!(n==0)) {
			for(int i = 0; i<=n; i++) {
				Integer m = t.getChild(n).getChild(i).getLabel();
				Integer m1 = t.getChild(n).getChild(i+1).getLabel();
				if(m>m1 && m>res.getLabel()) {
					res = t.getChild(n).getChild(i);
				}
				
			}
			n--;
			}
			
		}
		return res;
	}

}
