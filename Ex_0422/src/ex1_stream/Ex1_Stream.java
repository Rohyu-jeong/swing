package ex1_stream;

import java.util.Arrays;
import java.util.stream.*;

public class Ex1_Stream {
	public static void main(String[] args) {
		int[] nums = {1, 44, 33, 21, 36, 68, 88, 4, 5, 6, 1, 1, 1, 2, 2, 2};
		
		// 1. 스트림 객체 생성
		IntStream stream = Arrays.stream(nums);
		
		// 2. 스트림에 중간연산
		stream.distinct().sorted().limit(5).forEach(System.out::println);
		
		// skip()
		// rangeClosed() : 정수 범위를 생성
		IntStream intStream = IntStream.rangeClosed(1, 10);
		intStream.skip(3).limit(5).forEach(x -> System.out.print(x + " "));
		
		System.out.println();
		
		// filter()
		IntStream intStream2 = IntStream.of(1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 8, 9, 10);
		intStream2.distinct().filter(i -> i % 2 == 0).forEach(x -> System.out.print(x + " ")); // 2 4 6 8 10
		
		System.out.println();
		 
		// 문자열 길이가 3이상인 문자열만 출력
		Stream.of("ab", "a", "abc", "abcd", "abcdef", "abcedfg").filter(x -> x.length() >= 3).forEach(x -> System.out.print(x + " "));
	}
}
