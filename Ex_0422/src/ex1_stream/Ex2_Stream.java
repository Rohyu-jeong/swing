package ex1_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2_Stream {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>(Arrays.asList("홍길동", "박병렬", "람다식", "김자바", "제임스"));
		
		System.out.println(list1);
		// Collectors : stream을 일반적인 List, Set 등의 컬렉션으로 변경시키는 클래스
		// toCollection() : 좀 더 특정한 컬렉션으로 구현
		ArrayList<String> list1_1 = list1.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(list1_1);
		
		// 배열
		// toArray() 최종연산
		String[] list2 = {"홍길동", "박병렬", "람다식", "김자바", "제임스"};
		
		String[] list2_1 = Arrays.stream(list2).sorted().toArray(String[]::new);
		System.out.println(Arrays.deepToString(list2_1));
		
		// reduce() 최종연산
		Integer[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int total = Arrays.stream(nums).reduce(0, (x, y) -> x + y);
		// 기본 자료형으로 바꿔줘야 해서 오토언박싱이 발생
		System.out.println("1 ~ 10까지의 총 합 : " + total);
		
		int[] num2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		IntStream stream2 = Arrays.stream(num2);
		int total2 = stream2.reduce(0, (x, y) -> x + y);
		System.out.println("1 ~ 10까지의 총 합 : " + total);
		
		
		
		
		
	}
}
