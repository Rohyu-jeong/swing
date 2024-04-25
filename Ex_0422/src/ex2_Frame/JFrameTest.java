package ex2_Frame;

import javax.swing.JFrame;

public class JFrameTest extends JFrame{
	
	public JFrameTest() {
		super("제목");
		
		// setBounds(x, y, width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 200, 200);
		setVisible(true);
	}
}
