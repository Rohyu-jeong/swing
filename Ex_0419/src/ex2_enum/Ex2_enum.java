package ex2_enum;

public class Ex2_enum {
	public static void main(String[] args) {
		// Item item = new Item(); 
		Item start = Item.START;
		String str = start.getItemStr();
		String str2 = start.getSymbol();
		System.out.println(str);
		System.out.println(str2);
	}
}
