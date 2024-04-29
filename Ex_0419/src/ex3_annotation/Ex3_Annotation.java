package ex3_annotation;

import java.util.Arrays;

@TestInfo(tester="홍길동", datetime=@DateTime(date="20240419", time="170555"))
public class Ex3_Annotation {
	public static void main(String[] args) {
		TestInfo testInfo = (TestInfo) Ex3_Annotation.class.getAnnotation(TestInfo.class);
		
		String value = testInfo.value();
		System.out.println(value);
		
		String[] tools = testInfo.testTool();
		System.out.println(Arrays.toString(tools));
		
		String tester = testInfo.tester();
		System.out.println(tester);
		
		String date = testInfo.datetime().date();
		String time = testInfo.datetime().time();
		System.out.printf("date = %s, time = %s\n", date, time);
	}
}
