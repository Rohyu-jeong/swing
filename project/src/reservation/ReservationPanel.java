package reservation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import reservationDetails.ReservationDetails;
import test_jframe.JFrameTest;

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
	
	JMenuBar jpBar;
	JPanel jpCon;
	JPanel jpCheck;
	
	public ReservationPanel () {
		
		// 상단 바 - 예매내역, 로그아웃
		jpBar = new JMenuBar ();
		jpBar.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
		JButton reser = new JButton("예매내역");
		reser.setPreferredSize(new Dimension(100, 35));
		JButton logout = new JButton("로그아웃");
		logout.setPreferredSize(new Dimension(100, 35));
					
		jpBar.add(reser);
		jpBar.add(logout);
					
		// 항공권 조회
		jpCon = new JPanel ();

		// 출발지, 도착지
		JLabel jl1 = new JLabel("출발지");
		jl1.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		jl1.setBounds(332, 198, 219, 21);
		
		JLabel jl2 = new JLabel("도착지");
		jl2.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		jl2.setBounds(118, 198, 112, 21);

		jpCon.add(jl1);
		jpCon.add(jl2);
					
		// 출발지 고정, 목적지
		JTextPane start = new JTextPane();
		start.setFont(new Font("맑은 고딕", Font.BOLD, 40));
		start.setText("인천");
		start.setEditable(false);
		start.setBackground(Color.RED);
		start.setBounds(171, 101, 112, 80);

		String[] destList = {"목적지", "김포", "청주", "김해", "대구", "제주"};
		JComboBox<String> dest = new JComboBox <> (destList);
		dest.setPreferredSize(new Dimension(200, 40));
		dest.setFont(new Font("맑은 고딕", Font.PLAIN, 35));
		dest.setBackground(Color.white);
		dest.setBounds(366, 101, 185, 67);

		jpCon.add(start);
		jpCon.add(dest);
		
		ActionListener alDest = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String value = (String)dest.getSelectedItem();
				System.out.println("목적지 : " + value);
			}
		};
				
		dest.addActionListener(alDest);
		
		// 가는 날, 인원
		JLabel jl3 = new JLabel("가는 날");
		jl3.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		
		JLabel jl4 = new JLabel("탑승객 인원");
		jl4.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		
		jpCon.add(jl3);
		jpCon.add(jl4);
				
		// 날짜 선택
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
				
		// 인원 선택
		Integer[] num = {1, 2, 3, 4, 5};
		JComboBox<Integer> people = new JComboBox <>(num);
		people.setPreferredSize(new Dimension(200, 30));
		people.setBackground(Color.white);

		people.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
				
		jpCon.add(datePicker);
		jpCon.add(people);
				
		ActionListener alPeople = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int value = (Integer)people.getSelectedItem();
				System.out.println("인원 수 : " + value);
			}
		};
				
		people.addActionListener(alPeople);   
				
		// 조회 버튼
		jpCheck = new JPanel();
		JButton check = new JButton("항공권 조회하기");
		check.setPreferredSize(new Dimension(200, 35));
				
		jpCheck.add(check);
		
		JFrameTest f = new JFrameTest();
		f.setJMenuBar(jpBar);
		f.add(jpCon, BorderLayout.CENTER);
		f.add(jpCheck, BorderLayout.SOUTH);
		
		f.setVisible(true);

		// 예매내역 버튼 클릭 시 예매내역 페이지로 이동
		reser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 예매내역 창 호출
				new ReservationDetails();
				f.setVisible(false);
			}
		});
		
		
		// 로그아웃 버튼 클릭 시 로그아웃 되고 로그인 페이지로 이동
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그인 창 호출
				// new ();
				f.setVisible(false);
			}
		});
		
		
		// 조회하기 버튼 클릭 시 항공권 조회 페이지 이동
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 항공권 조회 정보
	            String selectedDest = (String) dest.getSelectedItem();
				if(!selectedDest.equals("목적지")) {
					int flightStartYear = model.getYear();
					int flightStartMonth = model.getMonth() + 1;
					int flightStartday = model.getDay();
					String startPoint = "인천";
					String destination = (String) dest.getSelectedItem();
					int countPeople = (int) people.getSelectedItem();
					
					// new (startPiont, destination, flightStartYear, flightStartMonth, flightStartDay, countPeople); // 항공권 조회 페이지
		            f.setVisible(false);
				}  else {
		            // 유효하지 않은 목적지인 경우
		            JOptionPane.showMessageDialog(f, "목적지를 선택해주세요.");
		        }
				
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		
		ReservationPanel rp = new ReservationPanel();
		
	}
	

	
}
