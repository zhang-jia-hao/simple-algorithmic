package algorithmic;

import java.util.ArrayList;
import java.util.List;

public class MathProblem {

	public static void main(String[] args) {
		/*
		 * Iterator<String> iterator = fizzBuzz(15).iterator();
		 * 
		 * while (iterator.hasNext()) { System.out.println(iterator.next()); }
		 */

		// System.out.println(isPowerOfThree(7));
		System.out.println(countPrimes(499979));
	}

	/**
	 * 统计所有小于非负整数 n 的质数的数量。 示例: 输入: 10 输出: 4 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5,
	 * 7 。
	 * 
	 * 厄拉多塞筛法。厄拉多塞是一位古希腊数学家，他在寻找素数时，采用了一种与众不同的方法：先将2－N的各数放入表中，然后在2的上面画一个圆圈，
	 * 然后划去2的其他倍数；第一个既未画圈又没有被划去的数是3，将它画圈，再划去3的其他倍数；现在既未画圈又没有被划去的第一个数
	 * 是5，将它画圈，并划去5的其他倍数……依次类推，一直到所有小于或等于N的各数都画了圈或划去为止。这时，表中画了圈的以及未划去的那些数正好就是小于
	 * N的素数。
	 * 
	 * 
	 * 这很像一面筛子，把满足条件的数留下来，把不满足条件的数筛掉。由于这种方法是厄拉多塞首先发明的，所以，后人就把这种方法称作厄拉多塞筛法。
	 * 
	 * 
	 * @param n
	 * @return
	 */
	public static int countPrimes(int n) {
		boolean[] s = new boolean[n];
		int count = 0;

		for (int i = 2; i < n; i++) {
			if (!s[i]) {
				for (long j = (long)(i) * i; j < n; j += i) {
					   s[(int) j] = true;
				}
				count++;
			}
		}

		return count;
	}

	/**
	 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
	 * 
	 * 示例 1:
	 * 
	 * 输入: 27 输出: true 示例 2:
	 * 
	 * 输入: 0 输出: false 示例 3:
	 * 
	 * 输入: 9 输出: true 示例 4:
	 * 
	 * 输入: 45 输出: false 进阶： 你能不使用循环或者递归来完成本题吗？
	 * 
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfThree(int n) {
		return n > 0 && 1162261467 % n == 0;
	}

	/**
	 * 写一个程序，输出从 1 到 n 数字的字符串表示。
	 * 
	 * 1. 如果 n 是3的倍数，输出“Fizz”；
	 * 
	 * 2. 如果 n 是5的倍数，输出“Buzz”；
	 * 
	 * 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
	 * 
	 * 示例：
	 * 
	 * n = 15,
	 * 
	 * 返回: [ "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz",
	 * "11", "Fizz", "13", "14", "FizzBuzz" ]
	 * 
	 * @param n
	 * @return
	 */
	public static List<String> fizzBuzz(int n) {
		List<String> arrayList = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				arrayList.add("FizzBuzz");
			} else if (i % 3 == 0) {
				arrayList.add("Fizz");
			} else if (i % 5 == 0) {
				arrayList.add("Buzz");
			} else {
				arrayList.add(String.valueOf(i));
			}
		}

		return arrayList;
	}

}
