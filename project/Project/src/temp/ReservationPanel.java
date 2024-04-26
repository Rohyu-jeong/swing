package temp;

import java.awt.FlowLayout;

import javax.swing.*;

public class ReservationPanel {

	/*
	 * 항공권 조회 화면
	 *
	 * -------------------------
	 * (상단메뉴)     예매내역 로그아웃
	 * 
	 *
	 *      출발지   도착지
	 *      날짜     인원 
	 * 		
	 *
	 *        조회하기 버튼
	 *
	 * -------------------------
	 *
	 * ! 
	 *
	 * */
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		// 상단 바 - 예매내역, 로그아웃
		JMenuBar jmb = new JMenuBar();
		
		JButton reser = new JButton("예매내역");
		JButton logout = new JButton("로그아웃");
		
		jmb.add(reser);
		jmb.add(logout);
		
		f.setJMenuBar(jmb);
		
		// 항공권 조회
		JLabel jl1 = new JLabel("출발지");
		JLabel jl2 = new JLabel("도착지");
		
		
		
		
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setBounds(300,200,300,200);
		f.setVisible(true);
	}
	

	
}
