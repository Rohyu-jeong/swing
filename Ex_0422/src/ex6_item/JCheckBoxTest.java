package ex6_item;

import javax.swing.*;

import ex2_Frame.JFrameTest;

public class JCheckBoxTest {
	public static void main(String[] args) {
		JCheckBox jcb1, jcb2, jcb3;
		JRadioButton jrb1, jrb2;
		
		JPanel jp1 = new JPanel();
		jcb1 = new JCheckBox("음악감상", true);
		jcb2 = new JCheckBox("등산", false);
		jcb3 = new JCheckBox("조깅", false);
		
		jp1.add(jcb1);
		jp1.add(jcb2);
		jp1.add(jcb3);
		
		JPanel jp2 = new JPanel();
		ButtonGroup bt = new ButtonGroup();
		jrb1 = new JRadioButton("결혼", true);
		jrb2 = new JRadioButton("미혼", false);
		
		bt.add(jrb1);
		bt.add(jrb2);
		
		jp2.add(jrb1);
		jp2.add(jrb2);
		
		JFrameTest f = new JFrameTest();
		
		f.add(jp1, "North");
		f.add(jp2, "South");
	}
}
