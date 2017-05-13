package pProduction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import pair.Pair;

public class Pproduction {
	
	ArrayList<Pair> p;
	
	public void product(ArrayList<Pair> filtered, Set<Character> ti, Set<Character> to) {
		p = new ArrayList<>();
		
		for(int i= 0 ; i < filtered.size(); i++){
			p.add(filtered.get(i).deepCopy());
		}
		
		Pair pair = new Pair();
		
		Iterator iterator = ti.iterator(); 
		
		while (iterator.hasNext()){
		   p.add(new Pair().put('I',(Character)iterator.next()));
		}
		

		iterator = to.iterator(); 
		
		while (iterator.hasNext()){
			p.add(new Pair().put((Character)iterator.next(),'O'));
		}
		printSet(p);
		
	}
	private void printSet(ArrayList<Pair> set){
		
		System.out.println("Pw:");
		System.out.print("{");
		for(int i= 0 ; i < set.size(); i++){
			System.out.print("({");
			
			for(int j = 0 ; j <set.get(i).left.size(); j++){
				System.out.print(set.get(i).left.get(j));
				if(j<set.get(i).left.size()-1)
					System.out.print(",");
			}
			System.out.print("},{");
			for(int j = 0 ; j <set.get(i).right.size(); j++){
				System.out.print(set.get(i).right.get(j));
				if(j<set.get(i).right.size()-1)
					System.out.print(",");
			}
			System.out.print("}");
			System.out.print(")");
			if(i < set.size() -1)
				System.out.print(",");
			if(i%10 == 0 && i != 0)
				System.out.println();
		}
		System.out.println("}");
		System.out.println("-----------------------------------");
	}

}
