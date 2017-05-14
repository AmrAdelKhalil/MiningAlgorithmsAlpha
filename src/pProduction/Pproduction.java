package pProduction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import pair.Pair;

public class Pproduction {
	
	public ArrayList<Pair> p;
	public ArrayList<String> places;
	
	public void product(ArrayList<Pair> filtered) {
		p = new ArrayList<>();
		places = new ArrayList<>();

		for(int i= 0 ; i < filtered.size(); i++){
			p.add(filtered.get(i).deepCopy());
		}
		

		printSet(p);
		
	}
	private void printSet(ArrayList<Pair> set){
		
		System.out.println("Pw:");
		System.out.print("{");
		String place = "";
		for(int i= 0 ; i < set.size(); i++){
			place = "";
			System.out.print("p(");
			place += "p(";
			for(int j = 0 ; j <set.get(i).left.size(); j++){
				System.out.print(set.get(i).left.get(j));
				place += set.get(i).left.get(j);
			}
			System.out.print(",");
			place += ",";
			for(int j = 0 ; j <set.get(i).right.size(); j++){
				System.out.print(set.get(i).right.get(j));
				place += set.get(i).right.get(j);
			}
			System.out.print(")");
			place += ")";
			if(i < set.size() -1)
				System.out.print(",");
			places.add(place);
		}
		System.out.print(",p(i),p(o)");
		System.out.println("}");
		System.out.println("-----------------------------------");
	}

}
