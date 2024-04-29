package ex1_Buffered;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Ex1_InputStreamReader {
	public static void main(String[] args) {
		FileInputStream in = null;
		InputStreamReader is = null;
		
		try {
			in = new FileInputStream("D:\\web1500_RYJ\\1.java/test.txt");
			is = new InputStreamReader(in, "UTF-8");
			int read = 0;
			
			while ((read = is.read()) != -1) {
				System.out.print((char)read);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				if(is != null) {
					is.close();
				}
				
				if(in != null) {
					in.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
