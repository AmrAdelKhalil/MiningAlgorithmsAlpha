package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pProduction.Pproduction;
import xProduction.Xproduction;
import yProduction.Fproduction;
import yProduction.Yproduction;

public class Output extends Window{

	String []inputArray;
	
	/*
	 * -1 - for causality inverse
	 * 0 - for nothing
	 * 1 - causality
	 * 2 - parallelism
	 * 3 - exclusiveness
	 */
	int [][] relationMatrix;
	Set<Character> Ti;
	Set<Character> To;
	Xproduction xProduction;
	Yproduction yProduction;
	Pproduction pProduction;
	Fproduction fProduction;
	JLabel message;
	
	public Output(){
		
	}
	
	public Output(String []inputArray){
		this.inputArray = inputArray;
		message = new JLabel("Look at the console to see the result");
		setLayout( new FlowLayout() );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 400, 700 );
		initUI();
		setVisible(true);
		Ti = new HashSet<>();
		To = new HashSet<>();
		xProduction = new Xproduction();
		yProduction = new Yproduction();
		pProduction = new Pproduction();
		fProduction = new Fproduction();
		relationMatrix = new int[26][26];
		run();
	}
	
	@Override
	protected void run() {
		
		prepareRelationMatrix();
		prepareTi();
		prepareTo();
		prepareX();
		prepareY();
		prepareP();
		prepareF();
	}

	private void prepareTi(){
		for(int i = 0 ; i<inputArray.length; i++)
			Ti.add(inputArray[i].charAt(0));
		
		Iterator iterator = Ti.iterator(); 
		
		System.out.println("Ti:");
		System.out.print("{");
		while (iterator.hasNext()){
		   System.out.print(iterator.next()); 
		   if(iterator.hasNext()){
			   System.out.print(", ");
		   }
		}
		System.out.println("}");
		System.out.println("-----------------------------------");
		
	}
	private void prepareTo(){
		for(int i = 0 ; i<inputArray.length; i++)
			To.add(inputArray[i].charAt(inputArray[i].length()-1));
		
		Iterator iterator = To.iterator(); 
		
		System.out.println("To:");
		System.out.print("{");
		while (iterator.hasNext()){
		   System.out.print(iterator.next()); 
		   if(iterator.hasNext()){
			   System.out.print(", ");
		   }
		}
		System.out.println("}");
		System.out.println("-----------------------------------");
	}
	private void prepareX(){
		xProduction.goWork(relationMatrix);
	}
	private void prepareY(){
		yProduction.product(xProduction.set);
	}
	private void prepareP(){
		pProduction.product(yProduction.filtered);
	}
	private void prepareF(){
		fProduction.product(pProduction.p, Ti, To, pProduction.places);
	}
	
	private void prepareRelationMatrix(){

		for(int i = 0 ; i < inputArray.length; i++){
			String element = inputArray[i];

			for(int j = 0 ; j< element.length() - 1 ; j++){
				if(relationMatrix[element.charAt(j)-'A'][element.charAt(j+1)-'A'] == 0){
					relationMatrix[element.charAt(j)-'A'][element.charAt(j+1)-'A'] = 1;
					relationMatrix[element.charAt(j+1)-'A'][element.charAt(j)-'A'] = -1;
				}
				else if(relationMatrix[element.charAt(j)-'A'][element.charAt(j+1)-'A'] == -1){
					relationMatrix[element.charAt(j)-'A'][element.charAt(j+1)-'A'] = 2;
					relationMatrix[element.charAt(j+1)-'A'][element.charAt(j)-'A'] = 2;
				}
			}
		}
		for(int i = 0; i < 26; i++)
			for(int j =0 ; j<26; j++)
				if(relationMatrix[i][j]==0)
					relationMatrix[i][j]=3;
		

				
	}

	@Override
	protected void initUI() {
		next_prev_btn = new JButton("Back");
		next_prev_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getBack();
			}
		});
		add(message);
		add(next_prev_btn);
	}
	
	private void getBack(){
		this.setVisible(false);
		Window w = new Input();
	}

}
