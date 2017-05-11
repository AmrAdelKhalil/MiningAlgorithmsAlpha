package yProduction;

import java.util.ArrayList;

import pair.Pair;

public class Yproduction {
	
	ArrayList<Pair> set;
	ArrayList<Integer> isSubset;
	ArrayList<Pair> filtered;
	
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

	}
	
	private boolean isSub(Pair a1, Pair a2){
		
		for(int i = 0; i<a1.left.size(); i++)if(!a2.left.contains(a1.left.get(i)))return false;
		
		for(int i = 0; i<a1.right.size(); i++)if(!a2.right.contains(a1.right.get(i)))return false;
		
		return true;
	}
}
