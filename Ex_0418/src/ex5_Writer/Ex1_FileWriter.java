package ex5_Writer;

import java.io.FileWriter;

public class Ex1_FileWriter {
	public static void main(String[] args) {
		// FileWriter
		// 문자 기반의 출력스트림
		
		try {
			FileWriter fw = new FileWriter("D:\\web1500_RYJ\\1.java/fileWriter예제.txt", true);
			
			fw.write("첫번째 줄 작성합니다.\n");
			fw.write("두번째 줄도 문제없지\n");
			System.out.println("작성완료");
			fw.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
