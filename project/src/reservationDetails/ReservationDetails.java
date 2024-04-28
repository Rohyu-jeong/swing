package reservationDetails;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import test_jframe.JFrameTest;

public class ReservationDetails {
	
	

	/*
	 * 예매내역 확인
	 *
	 * -------------------------
	 * (상단메뉴)     		 로그아웃
	 * 
	 *
	 *      이름
	 *      전화번호
	 *      항공사	항공편
	 *      출발지	도착지
	 *      날짜     인원 
	 * 		
	 *
	 *      다운로드	메인화면
	 *
	 * -------------------------
	 *
	 * 
	 *
	 * */

	JMenuBar jpBar;
	JPanel jpCon;
	JPanel jpCheck;
	
	public ReservationDetails () {
		
		// 상단 바 - 로그아웃
		jpBar = new JMenuBar ();
		jpBar.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		JButton logout = new JButton("로그아웃");
		logout.setPreferredSize(new Dimension(100, 35));

		jpBar.add(logout);
		
		// 예매내역
		jpCon = new JPanel();
		
		JLabel jl1 = new JLabel("이름");
		jl1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		jpCon.add(jl1);
		
		JLabel jl2 = new JLabel("전화번호");
		jl2.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		jpCon.add(jl2);
		
		JLabel jl3 = new JLabel("항공사");
		jl3.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		jpCon.add(jl3);
		
		JLabel jl4 = new JLabel("항공편");
		jl4.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		jpCon.add(jl4);
		
		JLabel jl5 = new JLabel("출발지");
		jl5.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		jpCon.add(jl5);
		
		JLabel jl6 = new JLabel("도착지");
		jl6.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		jpCon.add(jl6);
		
		JLabel jl7 = new JLabel("가는 날");
		jl7.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		jpCon.add(jl7);
		
		JLabel jl8 = new JLabel("탑승객 인원");
		jl8.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		jpCon.add(jl8);
		
		// 다운로드, 메인화면
		jpCheck = new JPanel();
		JButton donwload = new JButton("다운로드");
		donwload.setPreferredSize(new Dimension(200, 35));
		
		JButton main = new JButton("메인화면");
		main.setPreferredSize(new Dimension(200, 35));
				
		jpCheck.add(donwload);
		jpCheck.add(main);
		
		JFrameTest f = new JFrameTest();
		f.setJMenuBar(jpBar);
		f.add(jpCon, BorderLayout.CENTER);
		f.add(jpCheck, BorderLayout.SOUTH);
		
		f.setVisible(true);
		
		// 로그아웃 버튼 클릭 시 로그아웃 되고 로그인 페이지로 이동
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인 창 호출
				// new ();
				f.setVisible(false);
			}
		});
		
	}
	
	public static void main(String[] args) {
		
		ReservationDetails rd = new ReservationDetails();
		
	}
	
	
}
