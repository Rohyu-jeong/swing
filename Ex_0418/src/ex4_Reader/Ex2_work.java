package ex4_Reader;

import java.io.FileReader;

public class Ex2_work {
	public static void main(String[] args) {
		// test.txt에 아무 내용이나 적는다. 한글, 영어 대문자, 소문자, 숫자
		// test.txt의 내용을 읽어서 알파벳 대문자와 소문자의 개수를 출력
		
		// 대문자 : X개
		// 소문자 : X개
		
		FileReader fr = null;
		
		try {
			fr = new FileReader("D:\\web1500_RYJ\\1.java/test.txt");
			int read = 0;
			int Ucount = 0, Lcount = 0;
			
			while((read = fr.read()) != -1) {
				if (read >= 'A' && read <= 'Z') {
					Ucount++;
				} else if (read >= 'a' && read <= 'z') {
					Lcount++;
				}
			}
			
			System.out.printf("대문자 : %d개\n소문자 : %d개", Ucount, Lcount);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
}
