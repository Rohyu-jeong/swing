package ex6_item;

import javax.swing.*;

import ex2_Frame.JFrameTest;

public class JMenuBarTest {
	public static void main(String[] args) {
		// JMenuBar 클래스
		// 메뉴바를 생성한다.
		JMenuBar jmb = new JMenuBar();
		
		// JMenu 클래스
		// 메뉴바에 들어갈 메뉴
		JMenu jmu1 = new JMenu("파일");
		JMenu jmu2 = new JMenu("편집");
		JMenu jmu3 = new JMenu("보기");
		
		
		// JMenuItem 클래스
		// JMenu에 들어갈 메뉴
		JMenuItem jmi1 = new JMenuItem("새로 만들기");
		JMenuItem jmi2 = new JMenuItem("열기");
		JMenuItem jmi3 = new JMenuItem("저장");
		
		jmu1.add(jmi1);
		jmu1.add(jmi2);
		jmu1.add(jmi3);
		
		JMenuItem jmi4 = new JMenuItem("잘라내기");
		JMenuItem jmi5 = new JMenuItem("복사");
		JMenuItem jmi6 = new JMenuItem("붙혀넣기");
		
		jmu2.add(jmi4);
		jmu2.add(jmi5);
		jmu2.add(jmi6);
		
		jmb.add(jmu1);
		jmb.add(jmu2);
		jmb.add(jmu3);
		
		JFrameTest f = new JFrameTest();
		f.setJMenuBar(jmb);
		
	}
}
