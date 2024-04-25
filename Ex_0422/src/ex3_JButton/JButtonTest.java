package ex3_JButton;

import java.awt.FlowLayout;

import javax.swing.JButton;

import ex2_Frame.JFrameTest;

public class JButtonTest {
	public static void main(String[] args) {
		JButton jbtn1, jbtn2, jbtn3;
		
		jbtn1 = new JButton("1");
		jbtn2 = new JButton("2");
		jbtn3 = new JButton("3");
		
		JFrameTest f = new JFrameTest();
		
		// setLayout()
		// 프레임 안에 요소를 어떻게 배치할 것인가
		f.setLayout(new FlowLayout());
		
		f.add(jbtn1);
		f.add(jbtn2);
		f.add(jbtn3);
		
		
	}
}
