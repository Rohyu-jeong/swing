package ex6_buffered;

import java.io.BufferedReader;
import java.io.FileReader;

public class Ex3_BufferedReader {
	public static void main(String[] args) {
		// 버퍼에 데이터를 저장하여 입력 또는 출력하기 때문에
		// 단어 뿐만 아니라 문장 단위로 데이터를 읽거나 쓸 수 있다.
		
		FileReader reader = null;
		BufferedReader br = null;
		
		try {
			reader = new FileReader("D:\\web1500_RYJ\\1.java/상속.txt");
			br = new BufferedReader(reader);
			
			String str = "";
			
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(br != null) {
					br.close();
				}
				if(reader != null) {
					reader.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
