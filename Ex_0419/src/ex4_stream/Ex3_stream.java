package ex4_stream;

import java.util.stream.IntStream;

public class Ex3_stream {
	public static void main(String[] args) {
		// 기본타입형 스트림
		// IntStream, DoubleStream
		// 기본 자료형에 유용하게 사용할 수 있는 메서드를 제공한다.
		
		int total = 0;
		for (int i = 0; i <= 10; i++) {
			total += i;
		}
		
		System.out.printf("1 ~ 10까지의 합 : %d\n", total);
		
		int total2 = IntStream.rangeClosed(1,  10).sum();
		
		System.out.printf("1 ~ 10까지의 합 : %d\n", total2);
	}
}
