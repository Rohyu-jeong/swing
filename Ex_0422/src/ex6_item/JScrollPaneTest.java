package ex6_item;

import java.awt.*;

import javax.swing.*;

import ex2_Frame.JFrameTest;

public class JScrollPaneTest {
	public static void main(String[] args) {
		// JScrollPane 클래스
		// 필요에 따라 패널에 수평이나 수직 스크롤바를 설정한다.
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(10,5));
		
		int cnt = 1;
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 5; j++) {
				jp.add(new JButton("버튼" + cnt++));
			}
		}
		
		// 수직, 수평 스크롤바를 설정하기 위한 상수
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
		JScrollPane js = new JScrollPane(jp, v, h);
		
		JFrameTest f = new JFrameTest();
		f.add(js);
		
	}
}
