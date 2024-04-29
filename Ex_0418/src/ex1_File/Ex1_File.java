package ex1_File;

import java.io.File;

public class Ex1_File {
	public static void main(String[] args) {
		// File 클래스
		// 파일 또는 폴더에 대한 정보를 제공하는 클래스
		// 경로명, 파일 크기, 타입, 날짜 등의 속성 정보를 제공한다.
		// 파일 생성, 삭제, 이름 변경 등 파일 관리 작업을 지원하기 위한 메서드로 구성되어 있다.
		
		// 파일 객체에 전달할 경로
		String path = "D:\\web1500_RYJ\\1.java/test.txt";
		
		// 준비된 경로로 File 객체 생성
		File f = new File(path);
		
		// isFile()
		// 경로의 마지막이 파일이면 true, 아니면 false
		if (f.isFile()) {
			// length()
			// 파일의 크기를 반환
			System.out.println(f.length() + "byte");
		}
		
		
		
	}
}
