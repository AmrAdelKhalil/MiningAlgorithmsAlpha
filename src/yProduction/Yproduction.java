package yProduction;

import java.util.ArrayList;

import pair.Pair;

public class Yproduction {
	
	public ArrayList<Pair> set;
	public ArrayList<Integer> isSubset;
	public ArrayList<Pair> filtered;
	
	public Yproduction(){
		isSubset = new ArrayList<>();
	}
	
	public void product(ArrayList<Pair> set){
		this.set = set;
		boolean notSubset = true;
		for(int i = 0 ; i < set.size() ; i++){
			notSubset = true;
			for(int j = 0 ; j<set.size(); j++){
				if(i == j)
					continue;
				if(isSub(set.get(i), set.get(j))){
					notSubset = false;
					isSubset.add(new Integer(0));
					break;
				}
			}
			if(notSubset){
				isSubset.add(new Integer(1));
			}
		}
		filtered = new ArrayList<>();
		for(int i = 0 ; i < isSubset.size() ; i++){
			if(isSubset.get(i) == 1){
				filtered.add(set.get(i).deepCopy());
			}
		}
		printSet();
	}
	
	private boolean isSub(Pair a1, Pair a2){
		
		for(int i = 0; i<a1.left.size(); i++)if(!a2.left.contains(a1.left.get(i)))return false;
		
		for(int i = 0; i<a1.right.size(); i++)if(!a2.right.contains(a1.right.get(i)))return false;
		
		return true;
	}
	
	private void printSet(){
		
		System.out.println("Yw:");
		System.out.print("{");
		int newLine = 0;
		for(int i= 0 ; i < set.size(); i++){
			
			if(isSubset.get(i) == 1){
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
				if(newLine%10 == 0 && newLine != 0)
					System.out.println();
				newLine++;
				
			}
		}
		System.out.println("}");
		System.out.println("-----------------------------------");
	}
}
