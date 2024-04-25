package ex3_JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ex2_Frame.JFrameTest;

public class Ex1_JButton {
	public static void main(String[] args) {
		// JButton jbtn1, jbtn2, jbtn3, jbtn4;
		// jbtn1 = new JButton("입력");
		// jbtn2 = new JButton("확인");
		// jbtn3 = new JButton("옵션");
		// jbtn4 = new JButton("메시지");
		
		String[] msg = {"입력", "확인", "옵션", "메시지"};
		JButton[] btn = new JButton[4];
		
		// 버튼 생성
		for(int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(msg[i]);
		}
		
		// 프레임 생성
		JFrameTest f = new JFrameTest();
		f.setLayout(new FlowLayout());
		for (int i = 0; i < btn.length; i++) {
			f.add(btn[i]);
		}
		
		// 이벤트 생성
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// getActionCommand()
				// 버튼에 쓰여져 있는 문자열을 반환
				switch(e.getActionCommand()) {
				case "입력":
					String name = JOptionPane.showInputDialog(f, "이름을 입력하세요");
					System.out.println(name);
					break;
				case "확인":
					int con = JOptionPane.showConfirmDialog(f, "확인?");
					System.out.println(con);
					break;
				case "옵션":
					String[] option = {"검색", "추가", "취소"};
					JOptionPane.showOptionDialog(f, "원하는 직업 선택", "옵션 대화상자", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, null);
					break;
				case "메시지":
					JOptionPane.showMessageDialog(f, "메시지 대화상자");
					break;
				}
			}
		};
		
		// 버튼에 이벤트 부착
		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(al);
		}
		
		
	}
}
