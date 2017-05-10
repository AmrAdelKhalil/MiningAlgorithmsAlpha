package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Output extends Window{

	String []inputArray;
	
	/*
	 * 0 - for nothing
	 * 1 - causality
	 * 2 - parallelism
	 * 3 - exclusiveness
	 */
	int [][] relationMatrix = new int[26][26];
	
	public Output(){
		
	}
	
	public Output(String []inputArray){
		this.inputArray = inputArray;
		setLayout( new FlowLayout() );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 400, 700 );
		initUI();
		setVisible(true);
		run();
	}
	
	@Override
	protected void run() {
		
		
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
		add(next_prev_btn);
	}
	
	private void getBack(){
		this.setVisible(false);
		Window w = new Input();
	}

}
