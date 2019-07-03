package algorithmic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimpleArrays {
	
	public static void main(String[] args) {
		int[] s = {1,2,3,0,0,0};
		int[] s1 = {2,5,6};
		// int removeDuplicates = removeDuplicates(s);
		// System.out.println("length:"+removeDuplicates);

		// int removeElement = removeElement(s,3);
		// System.out.println("length:"+removeElement);

		// int maxProfit = maxProfit(s);
		// System.out.println(+maxProfit);

		// rotate(s,4);
		// System.out.println(containsDuplicate(s));
		// System.out.println(singleNumber(s));
		// intersect(s,s1);
		// System.out.println(plusOne(s));

		//
		merge(s,3,s1,3);

		for(int i =0;i<s.length;i++){
			System.out.print(s[i]);
		}
		
		// System.out.println(Arrays.toString(intersect(s, s1)));
		// moveZeroes(s);
		int[] s3 = { 2, 5, 5 };
		/*
		 * char[][] cha ={ {'5','7','.','.','7','.','.','.','.'},
		 * {'6','.','.','1','9','5','.','.','.'},
		 * {'.','9','8','.','.','.','.','6','.'},
		 * {'8','.','.','.','6','.','.','.','3'},
		 * {'4','.','.','8','.','3','.','.','1'},
		 * {'7','.','.','.','2','.','.','.','6'},
		 * {'.','6','.','.','.','.','2','8','.'},
		 * {'.','.','.','4','1','9','.','.','5'},
		 * {'.','.','.','.','8','.','.','7','9'} };
		 * 
		 * //System.out.println(Arrays.toString(twoSum(s3, 10)));
		 * System.out.println(isValidSudoku(cha));
		 */
		int[][] s4 = {{1,2,3},{4,5,6},{7,8,9}};
		//rotate(s4);
	}
	
	/**
	 * 给定一个 n × n 的二维矩阵表示一个图像。
	 * 
	 * 将图像顺时针旋转 90 度。
	 * 
	 * 说明：
	 * 
	 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
	 * 
	 * 示例 1:
	 * 
	 * 给定 matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
	 * 
	 * 原地旋转输入矩阵，使其变为: [ [7,4,1], [8,5,2], [9,6,3] ] 示例 2:
	 * 
	 * 给定 matrix = [ [ 5, 1, 9,11], [ 2, 4, 8,10], [13, 3, 6, 7], [15,14,12,16]
	 * ],
	 * 
	 * 原地旋转输入矩阵，使其变为: [ [15,13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16,
	 * 7,10,11] ]
	 * 
	 * @param matrix
	 */
	public static void rotate(int[][] matrix) {
		int length = matrix.length -1;
		int m = (length + 2)/2;
		int num = 0;

		for(int n = 0;n < m;n++){
			for (int i = 0; i < length - (n << 1); i++) {
				num = matrix[length - i - n][n];// 左下角
	
				matrix[length - i - n][n] = matrix[length - n][length - i - n];
	
				matrix[length - n][length - i - n] = matrix[i + n][length - n];
	
				matrix[i + n][length - n] = matrix[n][i + n];
	
				matrix[n][i + n] = num;
			}
		}

		for (int i = 0; i <= length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}

	}

	/**
	 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
	 * 
	 * 数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
	 * 
	 * 
	 * 上图是一个部分填充的有效的数独。
	 * 
	 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
	 * 
	 * 示例 1:
	 * 
	 * 输入: [ ["5","3",".",".","7",".",".",".","."],
	 * ["6",".",".","1","9","5",".",".","."],
	 * [".","9","8",".",".",".",".","6","."],
	 * ["8",".",".",".","6",".",".",".","3"],
	 * ["4",".",".","8",".","3",".",".","1"],
	 * ["7",".",".",".","2",".",".",".","6"],
	 * [".","6",".",".",".",".","2","8","."],
	 * [".",".",".","4","1","9",".",".","5"],
	 * [".",".",".",".","8",".",".","7","9"] ] 输出: true 示例 2:
	 * 
	 * 输入: [ ["8","3",".",".","7",".",".",".","."],
	 * ["6",".",".","1","9","5",".",".","."],
	 * [".","9","8",".",".",".",".","6","."],
	 * ["8",".",".",".","6",".",".",".","3"],
	 * ["4",".",".","8",".","3",".",".","1"],
	 * ["7",".",".",".","2",".",".",".","6"],
	 * [".","6",".",".",".",".","2","8","."],
	 * [".",".",".","4","1","9",".",".","5"],
	 * [".",".",".",".","8",".",".","7","9"] ] 输出: false 解释: 除了第一行的第一个数字从 5 改为 8
	 * 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。 说明:
	 * 
	 * 一个有效的数独（部分已被填充）不一定是可解的。 只需要根据以上规则，验证已经填入的数字是否有效即可。 给定数独序列只包含数字 1-9 和字符
	 * '.' 。 给定数独永远是 9x9 形式的。
	 * 
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		Set<Character> hashSet1 = new HashSet<>();
		Set<Character> hashSet2 = new HashSet<>();
		Set<Character>[][] hashSet3 = new HashSet[3][3];

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.' && !hashSet1.add(board[j][i])) {
					return false;
				}
				if (board[i][j] != '.' && !hashSet2.add(board[i][j])) {
					return false;
				}
				if (hashSet3[i / 3][j / 3] == null) {
					hashSet3[i / 3][j / 3] = new HashSet<>(16);
				}
				if (board[i][j] != '.' && !hashSet3[i / 3][j / 3].add(board[i][j])) {
					return false;
				}
			}
			hashSet1.clear();
			hashSet2.clear();
		}

		return true;
	}

	/**
	 * 
	 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	 * 
	 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	 * 
	 * 示例:
	 * 
	 * 给定 nums = [2, 7, 11, 15], target = 9
	 * 
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9 所以返回 [0, 1]
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] sum = new int[2];
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>(nums.length);

		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(target - nums[i])) {
				sum[0] = hashMap.get(target - nums[i]);
				sum[1] = i;
				break;
			} else {
				hashMap.put(nums[i], i);
			}
		}

		return sum;
	}

	public int[] twoSum1(int[] nums, int target) {

		int[] sum = new int[2];

		for (int i = 0; i < nums.length - 1; i++) {
			for (int k = i + 1; k < nums.length; k++) {
				if (nums[i] + nums[k] == target) {
					sum[0] = i;
					sum[1] = k;
					return sum;
				}
			}
		}

		return sum;
	}

	/**
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	 * 
	 * 示例:
	 * 
	 * 输入: [0,1,0,3,12] 输出: [1,3,12,0,0] 说明:
	 * 
	 * 必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
	 * 
	 * @param nums
	 */
	public void moveZeroes(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				for (int j = i; j < nums.length; j++) {
					if (nums[j] != 0) {
						nums[i] = nums[j];
						nums[j] = 0;
						break;
					}
				}
			}
		}

		System.out.println(Arrays.toString(nums));
	}

	public void moveZeroes1(int[] nums) {
		int maxIndex = nums.length - 1;
		int num = 0;
		for (; maxIndex >= 0; maxIndex--) {
			if (nums[maxIndex] == 0 && maxIndex != nums.length - 1 && nums[maxIndex + 1] != 0) {
				for (int i = maxIndex; i < nums.length - 1; i++) {
					num = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = num;
				}
			}
		}

		System.out.println(Arrays.toString(nums));
	}

	/**
	 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
	 * 
	 * 说明:
	 * 
	 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存
	 * nums2 中的元素。 示例:
	 * 
	 * 输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
	 * 
	 * 输出: [1,2,2,3,5,6]
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		m--;n--;
		
		while(n >= 0){
			if(m < 0){
				nums1[n] = nums2[n]; n--;continue;
			}else if(nums1[m] > nums2[n]){
				nums1[m + n + 1] = nums1[m]; m--;
			}else{
				nums1[m + n + 1] = nums2[n]; n--;
			}
		}
	}

	/**
	 * 给定两个数组，编写一个函数来计算它们的交集。
	 * 
	 * 示例 1:
	 * 
	 * 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2] 示例 2:
	 * 
	 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [4,9] 说明：
	 * 
	 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。 我们可以不考虑输出结果的顺序。 进阶:
	 * 
	 * 如果给定的数组已经排好序呢？你将如何优化你的算法？ 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 如果 nums2
	 * 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int pointer1 = 0;
		int length1 = nums1.length;
		int pointer2 = 0;
		int length2 = nums2.length;

		int[] nums = new int[Math.min(length1, length2)];
		int index = 0;

		for (; pointer1 < length1 && pointer2 < length2;) {
			if (nums1[pointer1] > nums2[pointer2]) {
				pointer2++;
			} else if (nums1[pointer1] < nums2[pointer2]) {
				pointer1++;
			} else {
				nums[index] = nums1[pointer1];
				pointer1++;
				pointer2++;
				index++;
			}
		}

		if (nums.length > index) {
			nums = Arrays.copyOf(nums, index);
		}

		return nums;
	}

	public int[] intersect1(int[] nums1, int[] nums2) {
		if (Arrays.toString(nums1).equals(Arrays.toString(nums2))) {
			return nums1;
		}
		boolean isFirstMax = nums1.length > nums2.length;
		int nums[] = isFirstMax ? nums2 : nums1;
		String arrayString = Arrays.toString(isFirstMax ? nums1 : nums2).replaceAll("\\s*", "").replaceAll("\\[|\\]",
				",");
		List<Integer> res = new ArrayList<>();
		int index;
		String num;
		for (int i = 0; i < nums.length; i++) {
			num = String.valueOf("," + nums[i] + ",");
			if (arrayString.contains(num)) {
				index = arrayString.lastIndexOf(num);
				arrayString = arrayString.substring(0, index)
						+ arrayString.substring(index + num.length() - 1, arrayString.length());
				res.add(nums[i]);
			}
		}
		int[] intArr = res.stream().mapToInt(Integer::intValue).toArray();
		return intArr;
	}

	/**
	 * 
	 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
	 * 
	 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
	 * 
	 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
	 * 
	 * 示例 1:
	 * 
	 * 输入: [1,2,3] 输出: [1,2,4] 解释: 输入数组表示数字 123。 示例 2:
	 * 
	 * 输入: [4,3,2,1] 输出: [4,3,2,2] 解释: 输入数组表示数字 4321。
	 * 
	 * @param digits
	 * @return
	 */
	public int[] plusOne1(int[] digits) {// ???有最大数限制
		String arrayString = Arrays.toString(digits);
		arrayString = String.valueOf(Long.parseLong(
				arrayString.substring(1, arrayString.length() - 1).replace(",", "").replaceAll("\\s*", "")) + 1);

		int[] res = new int[arrayString.length()];

		for (int i = 0; i < arrayString.length(); i++) {
			res[i] = arrayString.charAt(i) - '0';
		}
		return res;
	}

	public int[] plusOne(int[] digits) {
		int length = digits.length;

		if (digits[length - 1] == 9) {// 需要扩容
			for (int i = length - 1; i >= 0; i--) {
				if (digits[i] != 9) {
					digits[i] += 1;
					break;
				} else {
					digits[i] = 0;
					if (i == 0) {
						digits[i] = 1;
						digits = Arrays.copyOf(digits, length + 1);
					}
				}
			}
		} else {
			digits[length - 1] += 1;
		}
		// System.out.println(Arrays.toString(digits));
		return digits;
	}

	/**
	 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 说明： 你的算法应该具有线性时间复杂度。
	 * 你可以不使用额外空间来实现吗？ 示例 1: 输入: [2,2,1] 输出: 1 示例 2: 输入: [4,1,2,1,2] 输出: 4
	 * 
	 * @param nums
	 * @return
	 */

	public int singleNumber(int[] nums) {
		int i = 0;
		for (int s : nums) {
			i = i ^ s;
		}
		return i;
	}

	/**
	 * 给定一个整数数组，判断是否存在重复元素。 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
	 * 示例 1: 输入: [1,2,3,1] 输出: true 示例 2: 输入: [1,2,3,4] 输出: false 示例 3: 输入:
	 * [1,1,1,3,3,4,3,2,4,2] 输出: true
	 * 
	 * @param nums
	 * @return
	 */
	public boolean containsDuplicate(int[] nums) {
		/*
		 * Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		 * 
		 * for(int i =0;i<nums.length;i++){ if(map.containsKey(nums[i])){ return
		 * true; }else{ map.put(nums[i],1); } } return false;
		 */

		Set<Object> hashSet = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (!hashSet.add(nums[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。 示例 1:
	 * 
	 * 输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4] 解释: 向右旋转 1 步:
	 * [7,1,2,3,4,5,6] 向右旋转 2 步: [6,7,1,2,3,4,5] 向右旋转 3 步: [5,6,7,1,2,3,4] 示例 2:
	 * 
	 * 输入: [-1,-100,3,99] 和 k = 2 输出: [3,99,-1,-100] 解释: 向右旋转 1 步:
	 * [99,-1,-100,3] 向右旋转 2 步: [3,99,-1,-100] 说明:
	 * 
	 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 要求使用空间复杂度为 O(1) 的原地算法。 1,2,3,4,5,6,7 2
	 * 7,2,3,4,5,6,1 2 3 7,6,3,4,5,2,1 2 4 7,6,1,4,5,2,3 7,6,1,2,5,4,3
	 * 7,6,1,2,3,4,5
	 * 
	 * 1,2,3,4,5,6,7,8 2 8,1,2,3,4,5,6,7
	 * 
	 * 
	 * @param nums
	 * @param k
	 */
	public void rotate(int[] nums, int k) {
		int length = k % nums.length;// 2

		for (int i = 0; i < length; i++) {
			int len = nums[0];
			nums[0] = nums[nums.length - 1];

			for (int s = 1; s < nums.length; s++) {
				int val = nums[s];
				nums[s] = len;
				len = val;
			}
		}
	}

	public int removeDuplicates(int[] nums) {
		int length = nums.length;
		int fast = 1;

		for (int slow = 0; slow < length - 1; slow++) {
			if (nums[slow] != nums[slow + 1]) {
				nums[fast] = nums[slow + 1];
				fast++;
			}
		}
		return fast;
	}

	public int removeElement(int[] nums, int val) {
		int length = nums.length;
		int index = 0;

		for (int i = 0; i < length; i++) {
			if (nums[i] != val) {
				nums[index] = nums[i];
				index++;
			}
		}

		for (int i : nums) {
			System.out.println(i);
		}

		return index;
	}

	// 2,1,2,1,0,1,2
	public int maxProfit(int[] prices) {
		int total = 0;// 总收益
		int purchase = 0;// 购买价格
		boolean isPur = false;

		for (int i = 0; i < prices.length - 1; i++) {

			if (prices[i] < prices[i + 1]) {// 当前价格比下一位低时
				if (!isPur) {// 未购买
					purchase = prices[i]; // 购买
					isPur = true;
				}

				if (i == prices.length - 2) {// 最后一位还在涨
					total += (prices[i + 1] - purchase);
				}
			} else {
				if (isPur) {// 购买过,卖出 total累加
					total += (prices[i] - purchase);
					isPur = false;
				}
			}
		}

		return total;
	}

	public boolean isPalindrome(int x) {
		String str = "";
		if (x > 0) {
			while (x != 0) {
				str += x % 10;
				x /= 10;
			}
			System.out.println(str);
			return Integer.parseInt(str) == x;
		} else {
			return false;
		}
	}
}
