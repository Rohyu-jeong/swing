package ex6_item;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import ex2_Frame.JFrameTest;

public class ItemEventTest {
	public static void main(String[] args) {
		// 라디오버튼 객체 생성하기
		ButtonGroup rgroup = new ButtonGroup();
		JRadioButton r1 = new JRadioButton("선택1");
		JRadioButton r2 = new JRadioButton("선택2");
		JRadioButton r3 = new JRadioButton("선택3");
		
		rgroup.add(r1);
		rgroup.add(r2);
		rgroup.add(r3);
		
		// 패널에 라디오버튼 붙히기
		JPanel jp1 = new JPanel();
		
		jp1.add(r1);
		jp1.add(r2);
		jp1.add(r3);
		
		JPanel jp2 = new JPanel();
		JLabel txt1 = new JLabel("선택 항목 : ");
		JLabel txt2 = new JLabel();
		jp2.add(txt1);
		jp2.add(txt2);
		
		// 기능 정의
		ItemListener il = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (e.getSource() == r1) {
						txt2.setText("선택1");
					} else if (e.getSource() == r2) {
						txt2.setText("선택2");
					} else if (e.getSource() == r3) {
						txt2.setText("선택3");
					}
				}
			}
		};
		
		// 버튼에 기능 붙히기
		r1.addItemListener(il);
		r2.addItemListener(il);
		r3.addItemListener(il);
		
		JFrameTest f = new JFrameTest();
		f.setLayout(new BorderLayout());
		f.add(jp1, BorderLayout.CENTER);
		f.add(jp2, BorderLayout.SOUTH);
		
		
	}
}
