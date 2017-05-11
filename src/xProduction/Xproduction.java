package xProduction;

import java.util.ArrayList;

import pair.Pair;

public class Xproduction {
	
	public ArrayList<Pair> set;
	public int[][] relationMatrix;
	
	public Xproduction(){
		set = new ArrayList<Pair>();
	}
	
	public void goWork(int [][] relationMatrix){
		this.relationMatrix = relationMatrix;
		prepareSet();
		boolean goOneMore = true;

		ArrayList<Character> c1 = new ArrayList<>();
		ArrayList<Character> c2 = new ArrayList<>();
		Pair p;
		int start = 0, lastSize = 0;
		while(start<set.size()){
			
			lastSize = set.size();

			for(int i = start; i < lastSize ; i++,start++){
				for(int j = 0 ; j < lastSize ; j++){
					if(i == j)
						continue; 

					if(checkExclu(set.get(i).left, set.get(j).left) && checkExclu(set.get(i).right, set.get(j).right)){
						//System.out.println(i + " " + j);
						c1 = combineLists(set.get(i).left, set.get(j).left);
						c2 = combineLists(set.get(i).right, set.get(j).right);
						p = new Pair();
						p.left = c1;
						p.right = c2;
						//System.out.println(checkCaus(c1,c2) + " "+i + " "+j);
						if(checkCaus(c1,c2) && notExits(set, p)){
//							for(int  k = 0 ; k < p.left.size(); k++)
//								System.out.println(p.left.get(k));
//
//							for(int  k = 0 ; k < p.right.size(); k++)
//								System.out.println(p.right.get(k));
//							
//							System.out.println("yes");
							set.add(p.deepCopy());
						}
					}
				}
			}
//			printSet(set);
//			System.out.println(set.size() + " "+lastSize);
//			if(start>22)
//			break;
		}
//		System.out.println(set.size());
//		System.out.println("3mltha walla a");

	}
	
	private void printSet(ArrayList<Pair> set){
		
		for(int i= 0 ; i < set.size(); i++){
			for(int j = 0 ; j <set.get(i).left.size(); j++){
				System.out.print(set.get(i).left.get(j)+ ",");
			}
			System.out.println();
			for(int j = 0 ; j <set.get(i).right.size(); j++){
				System.out.print(set.get(i).right.get(j)+ ",");
			}
			System.out.println();
			System.out.println("***********************");
		}
	}
	
	private boolean notExits(ArrayList<Pair> newSets, Pair p){
		
		for(int i = 0 ; i < newSets.size(); i++){
			
			if(isEqual(newSets.get(i).left, p.left) && isEqual(newSets.get(i).right, p.right))
				return false;

		}
		
		return true;
	}
	
	private boolean isEqual(ArrayList<Character> a, ArrayList<Character>b){
		
		if(a.size() != b.size())
			return false;
		
		for(int i = 0 ; i < a.size() ; i++){
			if(!b.contains(a.get(i)))
				return false;
		}
		
		return true;
	}
	
	private void prepareSet(){
		for(int i=0; i<26; i++){
			for(int j=0 ; j<26; j++){
				if(relationMatrix[i][j] == 1){
					Pair p = new Pair();
					p.left.add((char) ('A'+i));
					p.right.add((char) ('A'+j));
					set.add(p);
				}
			}
		}
	}
	
	private boolean checkExclu(ArrayList<Character> a1, ArrayList<Character> a2){
//		for(int  k = 0 ; k < a1.size(); k++)
//			System.out.println(a1.get(k));
//		System.out.println("------------------");
//		for(int  k = 0 ; k < a2.size(); k++)
//			System.out.println(a2.get(k));
//		System.out.println("*****************"+" "+relationMatrix[a1.get(0)-'A'][a2.get(0)-'A']);
//		
		
		for(int i=0 ; i < a1.size(); i++){
			for(int j=0 ; j<a2.size() ; j++){
				if(relationMatrix[a1.get(i)-'A'][a2.get(j)-'A'] != 3)
					return false;
			}
		}
		return true;
	}
	
	private boolean checkCaus(ArrayList<Character> a1, ArrayList<Character> a2){
		
		for(int i=0 ; i < a1.size(); i++){
			for(int j=0 ; j<a2.size() ; j++){
				if(relationMatrix[a1.get(i)-'A'][a2.get(j)-'A'] != 1)
					return false;
			}
		}
		return true;
	}
	
	private ArrayList<Character> combineLists(ArrayList<Character> a1, ArrayList<Character> a2){
		ArrayList<Character> combined = new ArrayList<>();
		
		for(int i=0 ; i < a1.size(); i++)combined.add(a1.get(i));

		for(int i=0 ; i < a2.size(); i++)if(!a1.contains(a2.get(i)))combined.add(a2.get(i));
		
		return combined;
	}
	
	private ArrayList<Pair> combineSets(ArrayList<Pair> s1, ArrayList<Pair> s2){
		ArrayList<Pair> combined = new ArrayList<Pair>();
		
		for(int i = 0 ; i < s1.size() ; i++)
			combined.add(s1.get(i).deepCopy());
		
		for(int i = 0 ; i < s2.size() ; i++)
			combined.add(s2.get(i).deepCopy());
		
		return combined;
	}
}
