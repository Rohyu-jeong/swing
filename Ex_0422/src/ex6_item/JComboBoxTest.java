package ex6_item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import ex2_Frame.JFrameTest;

public class JComboBoxTest {
	public static void main(String[] args) {
		// 콤보박스
		
		String[] title = {"C", "Java", "Python", "Kotlin"};
		JComboBox<String> jcm1 = new JComboBox<>(title);
		jcm1.setBounds(50, 50, 100, 30);
		
		ActionListener al = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String value = (String)jcm1.getSelectedItem();
				System.out.println("선택된 값 : " + value);
			}
		};
		
		jcm1.addActionListener(al);
		
		JFrameTest f = new JFrameTest();
		f.setLayout(null);
		f.add(jcm1);
	}
}
