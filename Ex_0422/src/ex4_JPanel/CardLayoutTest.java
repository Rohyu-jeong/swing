package ex4_JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class CardLayoutTest extends JPanel{
	
	public CardLayoutTest() {
		// 패널들을 붙힐 패널
		JPanel cards = new JPanel(new CardLayout());
		
		// 패널1
		JPanel card1 = new JPanel();
		JButton nextButton = new JButton("Next");
		card1.setBounds(100, 100, 200, 200);
		card1.setBackground(Color.BLACK);
		card1.add(nextButton);
		
		// 패널2
		JPanel card2 = new JPanel();
		JButton prevButton = new JButton("Prev");
		card2.setBounds(100, 100, 200, 200);
		card2.setBackground(Color.ORANGE);
		card2.add(prevButton);
		
		cards.add(card1, "Panel1");
		cards.add(card2, "Panel2");
		
		add(cards);
		
		CardLayout cl = (CardLayout)cards.getLayout();
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.next(cards);
			}
		});

		prevButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cl.previous(cards);
			}
		});
}
	
	private static void createGUI() {
		JFrame f = new JFrame();
		CardLayoutTest cardDemo = new CardLayoutTest();
		f.setBounds(100, 100, 300, 300);
		f.add(cardDemo);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		createGUI();
	}
}
