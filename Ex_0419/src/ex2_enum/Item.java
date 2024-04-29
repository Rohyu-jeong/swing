package ex2_enum;

public enum Item {
	START("시작", "s"), STOP("멈춤", "p"), EXIT("종료", "e");
	
	protected String itemStr;
	protected String symbol;
	
	// 열거형의 생성자는 외부에서 호출할 수 없다.
	Item(String itemStr, String symbol) {
		this.itemStr = itemStr;
		this.symbol = symbol;
	}
	
	public String getItemStr() {
		return itemStr;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
}

//public class Item {
//	public static Item START = new Item("시작");
//	public static Item STOP = new Item("멈춤");
//	public static Item EXIT = new Item("종료");
//}
