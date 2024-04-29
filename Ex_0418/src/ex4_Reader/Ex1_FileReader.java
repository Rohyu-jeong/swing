package ex4_Reader;

import java.io.FileReader;

public class Ex1_FileReader {
	public static void main(String[] args) {
		// 자바에서는 char 형을 통해 문자를 저장할 수 있다.
		// 1byte 단위로 처리하는 바이트 기반 스트림은 모든 파일을 다룰 수 있으나 문자를 처리하는
		// char 형의 크기는 2byte로 별도의 처리를 하지 않으면 정상적으로 읽지 못하는 경우가 있다.
		// 이 때 문자 기반의 스트림을 사용하면 간단하게 문자를 처리할 수 있다.
		FileReader fr = null;
		try {
			fr = new FileReader("D:\\web1500_RYJ\\1.java/test.txt");
			int read = 0;
			
			while((read = fr.read()) != -1) {
				System.out.print((char)read);
				
			}
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
