package ex4_JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ex2_Frame.JFrameTest;

public class JPanelTest {
	public static void main(String[] args) {
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.CYAN);
		// p1.setLayout(new FlowLayout());
		// p1.setLayout(new GridLayout(행, 열));
		// p1.add(new JButton("1"));
		// p1.add(new JButton("2"));
		// p1.add(new JButton("3"));
		// p1.add(new JButton("4"));
		// p1.add(new JButton("5"));
		
		p1.setLayout(new BorderLayout());
		p1.add("North", new JButton("1"));
		p1.add("West", new JButton("2"));
		p1.add("Center", new JButton("3"));
		p1.add("East", new JButton("4"));
		p1.add("South", new JButton("5"));
		
		JFrameTest f = new JFrameTest();
		
		f.add(p1);
	}
}
