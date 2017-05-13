package pair;

import java.util.ArrayList;

public class Pair {
	
	public ArrayList<Character> left = new ArrayList();
	public ArrayList<Character> right = new ArrayList<>();
	
	public Pair deepCopy(){
		
		Pair p = new Pair();
		
		for(int i = 0 ; i < left.size(); i++)
			p.left.add(new Character(left.get(i)));

		for(int i = 0 ; i < right.size(); i++)
			p.right.add(new Character(right.get(i)));
		
		return p;
	}
	
	public Pair put(Character input, Character firstHead){
		left = new ArrayList<>();
		right = new ArrayList<>();
		
		left.add(input);
		right.add(firstHead);
		
		return this;
	}
}
