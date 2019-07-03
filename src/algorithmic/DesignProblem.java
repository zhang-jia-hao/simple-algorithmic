package algorithmic;

import java.util.Arrays;
import java.util.Random;

public class DesignProblem {

	public static void main(String[] args) {

		MinStack minStack = new DesignProblem().new MinStack();
		minStack.push(1);
		
		System.out.println(minStack.top());
		minStack.pop();
		System.out.println(minStack.top());
		
		System.out.println(minStack.getMin());
	}

	/**
	 * 打乱一个没有重复元素的数组。
	 * 
	 * 示例:
	 * 
	 * // 以数字集合 1, 2 和 3 初始化数组。 int[] nums = {1,2,3}; Solution solution = new
	 * Solution(nums);
	 * 
	 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。 solution.shuffle();
	 * 
	 * // 重设数组到它的初始状态[1,2,3]。 solution.reset();
	 * 
	 * // 随机返回数组[1,2,3]打乱后的结果。 solution.shuffle();
	 * 
	 * @author alisa
	 *
	 */
	class Solution {

		private int[] nums;
		private Random rand = new Random();

		public Solution(int[] nums) {
			this.nums = nums;
		}

		/** Resets the array to its original configuration and return it. */
		public int[] reset() {
			return nums;
		}

		/** Returns a random shuffling of the array. */
		public int[] shuffle() {
			int[] newNum = nums.clone();
			for (int i = 0; i < newNum.length; i++) {
				int j = rand.nextInt(i + 1);
				int temp = newNum[j];
				newNum[j] = newNum[i];
				newNum[i] = temp;
			}
			return newNum;
		}
	}

	/**
	 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
	 * 
	 * push(x) -- 将元素 x 推入栈中。 pop() -- 删除栈顶的元素。 top() -- 获取栈顶元素。 getMin() --
	 * 检索栈中的最小元素。 示例:
	 * 
	 * MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
	 * minStack.push(-3); minStack.getMin(); --> 返回 -3. minStack.pop();
	 * minStack.top(); --> 返回 0. minStack.getMin(); --> 返回 -2. Your Solution
	 * object will be instantiated and called as such: Solution obj = new
	 * Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
	 * obj.shuffle();
	 */
	class MinStack {

		private int[] stack;
		private int[] minNumStack;
		private int minStacklen; 
		private int len;
		
		private int minNum = 0;
		private int CAPACITY = 20;
		
		/** initialize your data structure here. */
		public MinStack() {
            stack = new int[CAPACITY];
            minNumStack = new int[CAPACITY];
		}

		public void push(int x) {
			if(len >= CAPACITY){
				CAPACITY = CAPACITY + (CAPACITY >> 1);
				stack = Arrays.copyOf(stack,CAPACITY);
				minNumStack = Arrays.copyOf(minNumStack,CAPACITY);
			}
			
			if(x <= minNum || len == 0){
				minNumStack[minStacklen++] = minNum;
				minNum = x;
			}
			
			stack[len] = x;
			len ++;
		}

		public void pop() {
			if(stack[--len] == minNum){
				minNum = minNumStack[--minStacklen];
			}
		}

		public int top() {
			return len == 0 ? 0 :stack[len - 1];
		}

		public int getMin() {
			return minNum;
		}
	}
}
