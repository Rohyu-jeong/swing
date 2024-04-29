package ex2_InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex1_FileInputStream {
	public static void main(String[] args) {
		// FileInputStream은 파일에서 바이트 단위로 자료를 읽어들일 때 사용하는 스트림
		// 이미지, 동영상, 텍스트 등 모든 타입의 파일을 읽어올 수 있다.
		
		String path = "D:\\web1500_RYJ\\1.java/test.txt";
		
		File f = new File(path);
		
		FileInputStream fis = null;
		
		if(f.exists()) {
			try {
				fis = new FileInputStream(f);
				
				int code = 0;
				
				while ((code = fis.read()) != -1) {
					System.out.print((char)code);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
