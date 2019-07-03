package other;

import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;

public class LambdaTest {

	public static void main(String[] args) {
		List<Apple> list = new ArrayList<Apple>();
		LambdaTest lambdaTest = new LambdaTest();

		list.add(lambdaTest.new Apple("a", "red", 10, "usa"));
		list.add(lambdaTest.new Apple("b", "green", 14, "china"));
		list.add(lambdaTest.new Apple("c", "red", 15, "china"));
		list.add(lambdaTest.new Apple("d", "yellow", 18, "usa"));

		list.stream().filter(a -> a.getAddress().equals("china")).forEach(a -> System.out.println(a.toString()));
		System.out.println("----------------------");
		list.stream().limit(3).forEach(a -> System.out.println(a.toString()));
		System.out.println("----------------------");
		System.out.println(list.stream().max((a1, a2) -> a1.getPrice() - a2.getPrice()).get().toString());
		System.out.println("----------------------");
		list.stream().sorted((a1, a2) -> a2.getPrice() - a1.getPrice()).forEach(a -> System.out.println(a.toString()));
		System.out.println("----------------------");

		new Thread(() -> System.out.println("aaa")).start();
	}

	class Apple {
		private String name;

		private String color;

		private int price;

		private String address;

		@Override
		public String toString() {
			return "Apple [name=" + name + ", color=" + color + ", price=" + price + ", address=" + address + "]";
		}

		public Apple(String name, String color, int price, String address) {
			super();
			this.name = name;
			this.color = color;
			this.price = price;
			this.address = address;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

	}

}
