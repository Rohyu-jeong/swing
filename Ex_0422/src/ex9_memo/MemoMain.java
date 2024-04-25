package ex9_memo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

import javax.swing.*;

public class MemoMain {
	public static void main(String[] args) {
		
		// 컴포넌트를 붙힐 패널
		JPanel jp = new JPanel(); 
		jp.setBackground(Color.CYAN);
		jp.setLayout(null);
		
		Font font = new Font("", Font.PLAIN, 20);
		
		// 한 줄을 입력할 수 있는 텍스트 필드
		JTextField tf = new JTextField();
		tf.setBounds(10, 15, 180, 30);
		tf.setFont(font);
		
		// 텍스트 필드에 적힌 내용을 TextArea로 보내주는 버튼
		JButton btn_input = new JButton("확인");
		btn_input.setBounds(190, 15, 60, 30);
		
		// TextField 아무것도 안 적혀있으면 비활성화
		btn_input.setEnabled(false);
		
		// 텍스트파일 형식으로 저장할 내용이 있는 TextArea
		JTextArea ta = new JTextArea();
		ta.setBounds(10, 70, 230, 280);
		ta.setEditable(false);
		
		// 텍스트 파일로 저장하기 위한 버튼
		JButton btnSave = new JButton("저장");
		
		// 프로그램 종료 버튼
		JButton btnClose = new JButton("종료");
		btnSave.setBounds(10, 356, 110, 30);
		
		// 패널에 컴포넌트 붙히기
		jp.add(tf);
		jp.add(btn_input);
		jp.add(ta);
		jp.add(btnSave);
		jp.add(btnClose);
		
		// 기능
		
		// TextField에 값이 들어가 있는지 확인하여 '확인' 버튼을 활성화 또는 비활성화
		tf.getDocument().addDocumentListener(new TextAdapter(tf, btn_input));
		
		// 확인버튼 클릭시 TextField의 값을 TextArea로 전달
		btn_input.addActionListener(new InputButtonAdapter(tf, ta));
		
		JFrame f = new JFrame();
		
		// 저장버튼 눌렀을 때 TextArea의 내용을 텍스트파일로 저장
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileWriter fw= null;
				// 경로를 설정하는 FileDialog
				FileDialog fd = new FileDialog(f, "버튼1", FileDialog.SAVE);
				fd.setVisible(true);
				
				// TestArea에 쓰여진 내용을 읽어오고
				String message = ta.getText();
				
				String path = fd.getDirectory()+fd.getFile();
				System.out.println(path);
				
				try {
					fw = new FileWriter(path);
					fw.write(message);
				} catch (Exception e2) {
					// TODO: handle exception
				} finally {
					try {
						if(fw != null) {
							fw.close();
						}
					} catch (Exception e3) {
						// TODO: handle exception
					}
				}
			}
			
		});
		
		// 종료버튼 눌렀을 때 프로그램 종료
		btnClose.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose(); // 현재 프레임 종료
			}
			
		});
		
		f.add(jp);
		
		f.setBounds(700, 200, 270, 440);
		
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
}
