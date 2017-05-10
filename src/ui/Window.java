package ui;

import javax.swing.JButton;
import javax.swing.JFrame;

public abstract class Window extends JFrame{
	
	protected JButton next_prev_btn;
	
	protected abstract void run();
	protected abstract void initUI();
}
