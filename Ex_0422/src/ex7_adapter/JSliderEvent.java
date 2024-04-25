package ex7_adapter;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ex2_Frame.JFrameTest;

// 어댑터를 이용한 이벤트 처리
// 리스너 인터페이스를 구현하기 위해서는 메서드를 반드시 오버라이딩 해야 한다.
// 마우스리스너의 경우 메서드가 6개다. 필요없어도 다 구현해야 된다.
// 이러한 문제를 해결해주는 것이 어댑터 클래스이다.
// 어댑터 클래스는 리스너가 가지고 있는 메서드 중 필요한 것만 재정의하면 된다.
// KeyListener -> KeyAdapter
// MouseListener -> MouseAdapter, MouseMotionAdapter
// WindowListener -> WindowAdapter

// 원하는 어댑터가 없는 경우 직접 만들어서 사용할 수도 있습니다.
public class JSliderEvent {
	JLabel colorLabel;
	JSlider jsl;
	
	public void jSlider() {
		colorLabel = new JLabel("      SLIDER EXAMPLE       ");
		jsl = new JSlider(JSlider.HORIZONTAL, 0, 255, 50);
		jsl.setPaintLabels(true);
		jsl.setPaintTicks(true);
		jsl.setPaintTrack(true);
		jsl.setMajorTickSpacing(50);
		jsl.setMinorTickSpacing(10);
		
		jsl.addChangeListener(new MyChangeListener());
		
		jsl.setForeground(Color.RED);
		colorLabel.setOpaque(true);
		colorLabel.setBackground(new Color(0, jsl.getValue(), 0));
		
		JFrameTest f = new JFrameTest();
		f.setLayout(new FlowLayout());
		f.add(jsl);
		f.add(colorLabel);
	}
	
	public static void main(String[] args) {
		new JSliderEvent().jSlider();
	}
	
	// adapter
	class MyChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			colorLabel.setBackground(new Color(0, jsl.getValue(), 0));
		}
		
	}
	
}
