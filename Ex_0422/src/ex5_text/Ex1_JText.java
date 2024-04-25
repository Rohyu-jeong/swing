package ex5_text;

import java.awt.*;

import javax.swing.*;

import ex2_Frame.JFrameTest;

public class Ex1_JText {
	public static void main(String[] args) {
		JLabel lb1, lb2, lb3;
		
		lb1 = new JLabel("이름");
		lb2 = new JLabel("나이");
		lb3 = new JLabel("비밀번호");
		
		JTextField tf = new JTextField(20);
		JTextArea ta = new JTextArea(7, 20);
		JPasswordField pf = new JPasswordField(20);
		
		JFrameTest f = new JFrameTest();
		f.setLayout(new FlowLayout());
		f.setBounds(400, 400, 300, 250);
		f.add(lb1);
		f.add(tf);
		f.add(lb2);
		f.add(ta);
		f.add(lb3);
		f.add(pf);
		
		// label에서 제공하는 메서드
		// setText(String s)
		// getText(String s)
		
		// TextField에서 제공하는 메서드
		// setEditable(boolean b) : 수정 가능한지 불가능한지 설정
		
		
		
	}
}
