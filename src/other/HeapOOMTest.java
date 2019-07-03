package other;

import java.util.*;

public class HeapOOMTest {

	public static void main(String[] args) {
		List<HeapOOMTest> list = new ArrayList<HeapOOMTest>();

		while (true) {
			list.add(new HeapOOMTest());
		}
		// stackOverFlower();
	}

	public static int stackOverFlower() {
		return stackOverFlower();
	}

}
