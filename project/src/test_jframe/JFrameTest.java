package test_jframe;

import javax.swing.*;

public class JFrameTest extends JFrame{
	
	public JFrameTest () {
		super("Test");
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1400, 800);
		setVisible(true);
		setLocationRelativeTo(null);
		
	}
}
