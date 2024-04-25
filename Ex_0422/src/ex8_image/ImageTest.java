package ex8_image;

import javax.swing.*;

import ex2_Frame.JFrameTest;

public class ImageTest {
	public static void main(String[] args) {
		ImageIcon back = new ImageIcon("src/img/cat.jpg");
		JLabel ji_back = new JLabel(back);
		ji_back.setBounds(0, 0, 200, 200);
		
		JFrameTest f = new JFrameTest();
		f.setLayout(null);
		f.add(ji_back);
	}
}
