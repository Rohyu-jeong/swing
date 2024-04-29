package ex2_InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex3_work {
	public static void main(String[] args) {
		// 특정 경로에 file.txt를 만들고 아무 문장이나 입력한다.
		// file.txt의 내용을 읽어와 문장이 회문인지 아닌지 판별하세요
		
		String path = "D:\\web1500_RYJ\\1.java/file.txt";
		
		File f = new File(path);
		
		byte[] b = new byte[(int)f.length()];
		
		FileInputStream fis = null;
		
		if (f.exists()) {
			try {
				fis = new FileInputStream (f);
				
				fis.read(b);
				
				StringBuilder ori = new StringBuilder(new String(b));
				
				StringBuilder rev = ori.reverse();
				
				if (ori.equals(rev)) {
					System.out.println(ori + "는 회문입니다.");
				} else {
					System.out.println(ori + "는 회문이 아닙니다.");
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
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
