package yProduction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import pair.Pair;

public class Fproduction {
	
	ArrayList<Pair> f;
	ArrayList<String> places;
	Set<Character> ti;
	Set<Character> to;
	
	public void product(ArrayList<Pair> p, Set<Character> ti, Set<Character> to, ArrayList<String> places) {
		f = new ArrayList<>();
		this.places = places;
		this.ti = ti;
		this.to = to;
		
		for(int i= 0 ; i < p.size(); i++){
			f.add(p.get(i).deepCopy());
		}
		
		
//		Iterator iterator = ti.iterator(); 
//		
//		while (iterator.hasNext()){
//		   f.add(new Pair().put('i',(Character)iterator.next()));
//		}
//		
//
//		iterator = to.iterator(); 
//		
//		while (iterator.hasNext()){
//			f.add(new Pair().put((Character)iterator.next(),'o'));
//		}
//		
		printSet(f);
		
	}
	
	private void printSet(ArrayList<Pair> set){

		System.out.println("Fw:");
		System.out.print("{");
		for(int i= 0 ; i < set.size(); i++){

			for(int j = 0 ; j <set.get(i).left.size(); j++){
				System.out.print("(");
				System.out.print(set.get(i).left.get(j));
				System.out.print(",");
				System.out.print(places.get(i));
				System.out.print(")");
				System.out.print(",");
			}

			for(int j = 0 ; j <set.get(i).right.size(); j++){
				System.out.print("(");
				System.out.print(places.get(i));
				System.out.print(",");
				System.out.print(set.get(i).right.get(j));
				System.out.print(")");
				if(j<set.get(i).right.size()-1)
					System.out.print(",");
			}

			if(i < set.size() -1)
				System.out.print(",");
			if(i%2 == 0 && i != 0)
				System.out.println();
		}
		
		Iterator iterator = ti.iterator(); 
		System.out.print(",");
		while (iterator.hasNext()){
			System.out.print("(p(i),");
			System.out.print(iterator.next());
			System.out.print("),");
		}
		
		
		iterator = to.iterator(); 
		
		while (iterator.hasNext()){
			System.out.print("(");
			System.out.print(iterator.next());
			System.out.print(", p(o))");
			if(iterator.hasNext())
				System.out.print(",");
		}
		
		System.out.println("}");
		System.out.println("-----------------------------------");
	}

}
