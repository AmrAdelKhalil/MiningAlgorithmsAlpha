package ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Input extends Window{
	
	private String[] alphabitical = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	private JLabel inputLable;
	private JTextField inputTextField;
	private JButton[] alpha;
	private JButton addBtn;
	private JButton del;
	private JTextArea textArea;
	private JScrollPane scroll;
	
	public Input(){
		
		setLayout( new FlowLayout() );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 400, 700 );
		initUI();
		setVisible(true);
	}
	
	
	@Override
	protected void initUI() {

		initLabels();
		initTextFields();
		initBtns();
		initTextAreas();
		addingComponent();
	}
	
	private void addingComponent(){
		add(scroll);
		add(inputLable);
		add(inputTextField);
		for(int i= 0 ; i < alpha.length ; i++)
			add(alpha[i]);
		add(addBtn);
		add(del);
		add(next_prev_btn);
	}
	
	private void initLabels(){
		inputLable = new JLabel("Enter alphabitical string(ex. ABC)");
	}

	private void initTextFields(){
		inputTextField = new JTextField(32);
		inputTextField.setEditable(false);
	}
	

	private void initBtns(){
		
		alpha = new JButton[26];
		for(int i= 0 ; i<alpha.length ; i++)
			alpha[i] = new JButton(alphabitical[i]);
		
		ButtonHandler handler = new ButtonHandler();
		
		for(int i= 0 ; i < alpha.length ; i++)
			alpha[i].addActionListener(handler);
		
		addBtn = new JButton("Add");
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(inputTextField.getText().length() > 0){
					
					if(textArea.getText().length() == 0)
						textArea.setText(inputTextField.getText());
					else
						textArea.setText(textArea.getText() + "\n" + inputTextField.getText());
		
					inputTextField.setText("");
				}
			}
		});
		
		del = new JButton("Delete");
		del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				StringBuilder currentInput = new StringBuilder(inputTextField.getText());
				String newInput = "";
				if(currentInput.length()>0)
					newInput = currentInput.substring(0, currentInput.length()-1);
				inputTextField.setText(newInput);
			}
		});
		
		next_prev_btn = new JButton("GO");
		next_prev_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				run();
			}
		});
	}
	
	private void initTextAreas(){
		 textArea = new JTextArea();
		 textArea.setColumns(30);
		 textArea.setRows(25);
		 textArea.setEditable(false);
		 textArea.setText("ABDEH\nADCEG\nACDEFBDEG\nADBEH\nACDEFDCEFCDEH\nACDEG");//remove this
		 initScroll();
	}
	
	private void initScroll(){
		scroll = new JScrollPane (textArea, 
				   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	}
	
	@Override
	protected void run() {
		this.setVisible(false);
		
		String []inputArray = textArea.getText().split("\n");
		
		Window output = new Output(inputArray);
		
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			inputTextField.setText(inputTextField.getText()+((JButton)e.getSource()).getText());
		}
		
	}

}
