package ex2_InputStream;

import java.io.File;
import java.io.FileInputStream;

public class Ex2_FileInputStream {
	public static void main(String[] args) {
		String path = "D:\\web1500_RYJ\\1.java/test.txt";
		
		File f = new File(path);
		
		byte[] b = new byte[(int)f.length()];
		
		FileInputStream fis = null;
		
		if(f.exists()) {
			try {
				fis = new FileInputStream(f);
				
				fis.read(b);
				
				String msg = new String (b);
				
				System.out.println(msg);
				
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if (fis != null) {
						fis.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
}
