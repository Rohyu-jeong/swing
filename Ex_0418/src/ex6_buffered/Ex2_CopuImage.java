package ex6_buffered;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex2_CopuImage {
	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fis = new FileInputStream("D:\\web1500_RYJ\\1.java/wall.jpg");
			fos = new FileOutputStream("D:\\web1500_RYJ\\1.java/wall_copy3.jpg");
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			System.out.println("이미지 복사 시작");
			
			long start = System.currentTimeMillis();
			
			int read = 0;
			
			while((read = bis.read()) != -1) {
				bos.write(read);
			}
			
			System.out.println("이미지 복사 종료");
			long end = System.currentTimeMillis();
			double result = (double)(end - start) / 1000;
			
			System.out.println("소요시간 : " + result + "초");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (bis != null) {
					bis.close();
				}
				
				if(fis != null) {
					fis.close();
				}
				
				if(bos != null) {
					bos.close();
				}
				
				if(fos != null) {
					fos.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
