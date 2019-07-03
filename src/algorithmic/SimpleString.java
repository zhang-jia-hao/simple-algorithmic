package algorithmic;

public class SimpleString {

	public static void main(String[] args) {

		char[] s = { 'h', 'e', 'l', 'l', 'o' };
		// reverseString(s);
		// System.out.println(Arrays.toString(s));
		// System.out.println(reverse(123));
		// System.out.println(firstUniqChar("leetcode"));
		// System.out.println(isAnagram("ac", "ca"));
		// System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		// System.out.println(myAtoi(" +0 123"));
		System.out.println(strStr("mississippi", "issipi"));
		// System.out.println(countAndSay(7));
		// String[] strs = {"aa","a"};
		// System.out.println(longestCommonPrefix(strs));
		System.out.println(firstBadVersion(8));
	}

	/**
	 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
	 * 
	 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
	 * 
	 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version
	 * 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
	 * 
	 * 示例:
	 * 
	 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
	 * 
	 * 调用 isBadVersion(3) -> false 调用 isBadVersion(5) -> true 调用 isBadVersion(4)
	 * -> true
	 * 
	 * 所以，4 是第一个错误的版本。
	 * 
	 * @param n
	 * @return
	 */
	public static int firstBadVersion(int n) {
       return firstBadVersion(1,n);
	}
	
	public static int firstBadVersion(int b,int e){
		int mid = b + ((e - b) >> 1);
		
		if(mid == b || mid == e){
			return isBadVersion(mid) ? (isBadVersion(mid - 1) ? mid - 1 : mid) : e;
		}
		return isBadVersion(mid) ? firstBadVersion(b,mid) : firstBadVersion(mid,e);
	}

	public static boolean isBadVersion(int n){
		return n >= 4;
	}
	/**
	 * 
	 * 编写一个函数来查找字符串数组中的最长公共前缀。
	 * 
	 * 如果不存在公共前缀，返回空字符串 ""。
	 * 
	 * 示例 1:
	 * 
	 * 输入: ["flower","flow","flight"] 输出: "fl" 示例 2:
	 * 
	 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。 说明:
	 * 
	 * 所有输入只包含小写字母 a-z 。
	 * 
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}
		StringBuffer result = new StringBuffer("");

		for (int i = 0; i < strs[0].length(); i++) {
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() <= i || strs[0].charAt(i) != strs[j].charAt(i)) {
					return result.toString();
				}
				if (j == strs.length - 1) {
					result.append(strs[0].charAt(i));
				}
			}
		}

		return result.toString();
	}

	/**
	 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
	 * 
	 * 1. 1 2. 11 3. 21 4. 1211 5. 111221 1 被读作 "one 1" ("一个一") , 即 11。 11 被读作
	 * "two 1s" ("两个一"）, 即 21。 21 被读作 "one 2", "one 1" （"一个二" , "一个一") , 即 1211。
	 * 
	 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
	 * 
	 * 注意：整数顺序将表示为一个字符串。
	 * 
	 * 
	 * 
	 * 示例 1:
	 * 
	 * 输入: 1 输出: "1" 示例 2:
	 * 
	 * 输入: 4 输出: "1211"
	 * 
	 * @param n
	 * @return
	 */
	public static String countAndSay(int n) {
		String initial = "1";
		StringBuffer result = new StringBuffer();

		int temp = 1;
		int length = initial.length();
		for (; n > 1; n--) {
			length = initial.length();
			result.setLength(0);

			for (int i = 0; i < length; i++) {
				if (i + 1 < initial.length() && initial.charAt(i) == initial.charAt(i + 1)) {
					temp++;
				} else {
					result.append("" + temp + (initial.charAt(i) - '0'));
					temp = 1;
				}
			}
			initial = result.toString();
		}

		return initial.toString();
	}

	/**
	 * 实现 strStr() 函数。
	 * 
	 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置
	 * (从0开始)。如果不存在，则返回 -1。
	 * 
	 * 示例 1:
	 * 
	 * 输入: haystack = "hello", needle = "ll" 输出: 2 示例 2:
	 * 
	 * 输入: haystack = "aaaaa", needle = "bba" 输出: -1 说明:
	 * 
	 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
	 * 
	 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
	 * 
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public static int strStr(String haystack, String needle) {
		if (needle == null || needle.equals("") || haystack.equals(needle)) {
			return 0;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		int maxi = 0;
		int j = needle.length() - 1;
		int badCharIndex = -1;

		for (int i = needle.length() - 1; i < haystack.length();) {
			if (j < 0) {
				return i + 1;
			}
			if (i < 0) {
				return -1;
			}

			maxi = maxi > i ? maxi : i;
			if (haystack.charAt(i) == needle.charAt(j)) {
				i--;
				j--;
			} else {
				for (int y = needle.length() - 1; y >= 0; y--) {
					if (haystack.charAt(i) == needle.charAt(y)) {
						badCharIndex = y;
						break;
					}
				}
				j = needle.length() - 1;
				i = (i += (j - badCharIndex)) > maxi ? i : maxi + 1;
			}
		}

		return -1;
	}

	public static int strStr1(String haystack, String needle) {
		if (needle == null || needle.equals("") || haystack.equals(needle)) {
			return 0;
		}
		if (needle.length() > haystack.length()) {
			return -1;
		}
		char[] charArray = haystack.toCharArray();
		char[] charArray2 = needle.toCharArray();
		int index = -1;

		for (int i = 0; i < charArray.length; i++) {
			for (int j = 0; j < charArray2.length;) {
				if (i + j >= charArray.length) {
					return -1;
				}
				if (charArray2[j] == charArray[i + j]) {
					if (j == 0) {
						index = i;
					}
					if (j == charArray2.length - 1) {
						return index;
					}
					if (j + 1 < charArray2.length) {
						j++;
					}
				} else {
					j = 0;
					break;
				}
			}
		}
		return -1;
	}

	/**
	 * 
	 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
	 * 
	 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
	 * 
	 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
	 * 
	 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
	 * 
	 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
	 * 
	 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
	 * 
	 * 说明：
	 * 
	 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231, 231 − 1]。如果数值超过这个范围，qing返回
	 * INT_MAX (231 − 1) 或 INT_MIN (−231) 。
	 * 
	 * 示例 1:
	 * 
	 * 输入: "42" 输出: 42 示例 2:
	 * 
	 * 输入: " -42" 输出: -42 解释: 第一个非空白字符为 '-', 它是一个负号。
	 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。 示例 3:
	 * 
	 * 输入: "4193 with words" 输出: 4193 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。 示例 4:
	 * 
	 * 输入: "words and 987" 输出: 0 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。 因此无法执行有效的转换。 示例
	 * 5:
	 * 
	 * 输入: "-91283472332" 输出: -2147483648 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
	 * 因此返回 INT_MIN (−231) 。
	 * 
	 * @param str
	 * @return
	 */
	public static int myAtoi(String str) {
		char[] chars = str.toCharArray();
		long num = 0;
		boolean flag = false;
		int sign = 1;
		for (int i = 0; i < chars.length; i++) {
			if (sign * num > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
			if (sign * num < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			if (chars[i] <= '9' && chars[i] >= '0') {
				flag = true;
				num = num * 10 + (int) (chars[i] - '0');
			} else if (flag == false && chars[i] == ' ') {
				continue;
			} else if (flag == false && chars[i] == '-') {
				flag = true;
				sign = -sign;
			} else if (flag == false && chars[i] == '+') {
				flag = true;
			} else {
				break;
			}
		}
		num = num * sign;
		if (sign > 0) {
			return num > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) num;
		} else {
			return num < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) num;
		}
	}

	public static int myAtoi1(String str) {
		char[] charArray = str.replaceAll("\\s", "").toCharArray();
		int result = 0;

		if (charArray.length <= 0) {
			return 0;
		}

		if (charArray[0] != '-' && charArray[0] != '+') {
			if (!Character.isDigit(charArray[0])) {
				return result;
			}
		} else {
			if (charArray.length < 2 || !Character.isDigit(charArray[1])) {
				return result;
			}
		}

		for (int i = 0; i < charArray.length; i++) {
			if (Character.isDigit(charArray[i])) {
				if (result + (charArray[i] - '0') > Integer.MAX_VALUE / 10
						|| result + (charArray[i] - '0') < Integer.MIN_VALUE / 10) {
					return charArray[0] != '-' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}

				result = (result * 10) + (charArray[i] - '0');
			} else if (result > 0 || i > 0) {
				break;
			}
		}

		return charArray[0] != '-' ? result : Integer.valueOf("-" + result);
	}

	/**
	 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	 * 
	 * 说明：本题中，我们将空字符串定义为有效的回文串。
	 * 
	 * 示例 1:
	 * 
	 * 输入: "A man, a plan, a canal: Panama" 输出: true 示例 2:
	 * 
	 * 输入: "race a car" 输出: false
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		s = s.replaceAll("\\W+", "").toLowerCase();
		char[] charArray = s.toString().toCharArray();
		int length = charArray.length;

		for (int i = 0; i < length / 2; i++) {
			if (charArray[i] != charArray[length - i - 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
	 * 
	 * 示例 1:
	 * 
	 * 输入: s = "anagram", t = "nagaram" 输出: true 示例 2:
	 * 
	 * 输入: s = "rat", t = "car" 输出: false 说明: 你可以假设字符串只包含小写字母。
	 * 
	 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isAnagram(String s, String t) {
		char[] charArrays = s.toCharArray();
		char[] charArrayt = t.toCharArray();
		int[] temp = new int[26];

		if (charArrays.length != charArrayt.length) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			temp[charArrays[i] - 'a']++;
			temp[charArrayt[i] - 'a']--;
		}

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
	 * 
	 * 案例:
	 * 
	 * s = "leetcode" 返回 0.
	 * 
	 * s = "loveleetcode", 返回 2.
	 * 
	 * 
	 * 注意事项：您可以假定该字符串只包含小写字母。
	 * 
	 * @param s
	 * @return
	 */
	public static int firstUniqChar(String s) {

		/*
		 * byte[] bytes = s.getBytes();
		 * 
		 * for(int i=0;i< bytes.length;i++){ if(s.indexOf(bytes[i]) ==
		 * s.lastIndexOf(bytes[i])){ return i; } }
		 */
		int index = -1;
		for (char a = 'a'; a <= 'z'; a++) {
			int temp = s.indexOf(a);
			if (temp != -1 && s.lastIndexOf(a) == temp) {
				index = (index == -1) ? temp : Math.min(temp, index);
			}
		}
		return index;
	}

	/**
	 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
	 * 
	 * 示例 1:
	 * 
	 * 输入: 123 输出: 321 示例 2:
	 * 
	 * 输入: -123 输出: -321 示例 3:
	 * 
	 * 输入: 120 输出: 21 注意:
	 * 
	 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回
	 * 0。
	 * 
	 * 12 3
	 * 
	 * @param x
	 * @return
	 */
	// 此题的关键是知晓一个事实：通过不停地取余和除10将原整数从低位到高位
	// 一位一位的取出来，然后迭代加余和乘以10得到翻转的数字。
	// 比如1024，可以通过((((0 + 4) * 10) * 10 + 2) * 10 + 0) + 1
	// 注意最高位x/10==0对应翻转之后的个位，所以不用乘10了，直接加上就可以了
	// 不知道这个，打破脑袋也想不出来，说白了就是套路
	public int reverse(int x) {
		int reverse = 0;
		while (x / 10 != 0) {
			int little = x % 10;
			if (reverse + little > Integer.MAX_VALUE / 10 || reverse + little < Integer.MIN_VALUE / 10) {
				return 0;
			}
			reverse = (reverse + little) * 10;
			x /= 10;
		}
		return reverse + x;
	}

	/**
	 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
	 * 
	 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
	 * 
	 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
	 * 
	 * 
	 * 
	 * 示例 1：
	 * 
	 * 输入：["h","e","l","l","o"] 输出：["o","l","l","e","h"] 示例 2：
	 * 
	 * 输入：["H","a","n","n","a","h"] 输出：["h","a","n","n","a","H"]
	 * 
	 * @param s
	 */
	public void reverseString(char[] s) {
		int length = s.length;
		char temp = 0;

		for (int i = 0; i < length / 2; i++) {
			temp = s[i];
			s[i] = s[length - 1 - i];
			s[length - 1 - i] = temp;
		}
	}
}
