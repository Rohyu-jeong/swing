package ex3_annotation;

import java.lang.annotation.Annotation;

// @TestInfo("테스트정보") // 파라미터를 전달하면 value()에 정보가 저장된다.
public class Ex2_Annotation {
	public static void main(String[] args) {
		Annotation[] annos = Ex2_Annotation.class.getAnnotations();
		
		for (Annotation anno : annos) {
			System.out.println(anno);
		}
		
		TestInfo testInfo = Ex2_Annotation.class.getAnnotation(TestInfo.class);
		System.out.println(testInfo.value());
	}
}
