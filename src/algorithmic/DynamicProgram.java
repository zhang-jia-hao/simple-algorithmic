package algorithmic;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgram {

    public static void main(String[] args) {

        // System.out.println(climbStairs(3));
        int nums[] = {-2, 0, 3, -5, 2, -1};
        // System.out.println(maxProfit(s));
        // System.out.println(maxSubArray(s));
        // System.out.println(rob(s));
        // System.out.println(minCostClimbingStairs(s));

        // NumArray numArray = new DynamicProgram().new NumArray(nums);
        // numArray.sumRange(0, 1);

        // System.out.println(divisorGame(5));
        // System.out.println(countBits(5));
        int[] t[] = {{-1}, {2, 3}, {1, -1, -3}};

        //System.out.println(minPathSum(t));
        //System.out.println(numTrees(4));

        List<List<Integer>> lists = new ArrayList<>();

        for (int[] i : t) {
            List<Integer> integers = new ArrayList<>();

            for (int j : i) {
                integers.add(j);
            }
            lists.add(integers);
        }

        System.out.println(minimumTotal(lists));
    }

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     * <p>
     * <p>
     * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
     * <p>
     * 说明：m 和 n 的值均不超过 100。
     * <p>
     * 示例 1:
     * <p>
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     * 示例 2:
     * <p>
     * 输入: m = 7, n = 3
     * 输出: 28
     *
     * f(m,n) = f(m, n - 1) + n
     * f(m,n) = m
     *
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }


        return 0;
    }

    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * 例如，给定三角形：
     * [
     * [2],
     * [3,4],
     * [6,5,7],
     * [4,1,8,3]
     * ]
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * 说明：
     * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
     * f(1) = 1  i = 0
     * f(2) = f(1)+ Min(g[2][i],g[2][i+1])
     * <p>
     * f(n) = f(n-1) + Min(g[n][i],g[n][i+1])
     *
     * @param triangle
     * @return
     */
    //{-1}, {2, 3}, {1, -1, -3}
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
            }
        }
        return dp[0];
    }

    public static int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() <= 0) {
            return 0;
        }
        int[][] dp = new int[triangle.size()][triangle.size()];
        int temp = dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i][j] = temp = dp[i - 1][0] + triangle.get(i).get(0);
                    continue;
                }
                dp[i][j] = (i == 0 ? dp[0][0] : (j == triangle.get(i).size() - 1 ? dp[i - 1][j - 1] : dp[i - 1][j - 1] > dp[i - 1][j] ? dp[i - 1][j] : dp[i - 1][j - 1])) + triangle.get(i).get(j);
                temp = temp < dp[i][j] ? temp : dp[i][j];
            }
        }
        return temp;
    }


    /**
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     * <p>
     * 示例:
     * <p>
     * 输入: 3 输出: 5 解释: 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
     * 卡塔兰数列： f(n) = f(n-1)*f(0) + f(n-2)*f(1) + ...
     *
     * @param n
     * @return
     */
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 说明：每次只能向下或者向右移动一步。
     * 示例:
     * <p>
     * 输入: [ [1,3,1], [1,5,1], [4,2,1] ] 输出: 7 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        if (grid.length <= 0) {
            return 0;
        }

        int[][] minPath = new int[grid.length][grid[0].length];
        minPath[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || j == 0) {
                    if (i == 0 && j != 0) {
                        minPath[0][j] = minPath[0][j - 1] + grid[i][j];
                    }
                    if (j == 0 && i != 0) {
                        minPath[i][0] = minPath[i - 1][0] + grid[i][j];
                    }
                } else {
                    minPath[i][j] = (minPath[i][j - 1] > minPath[i - 1][j] ? minPath[i - 1][j] : minPath[i][j - 1])
                            + grid[i][j];
                }
            }
        }

        return minPath[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
     * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。 亚历克斯和李轮流进行，亚历克斯先开始。
     * 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
     * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
     * <p>
     * 示例：
     * <p>
     * 输入：[5,3,4,5] 输出：true 解释： 亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。 假设他取了前 5 颗，这一行就变成了
     * [3,4,5] 。 如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。 如果李拿走后 5 颗，那么剩下的是
     * [3,4]，亚历克斯拿走后 4 颗赢得 9 分。 这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
     * <p>
     * 提示： 2 <= piles.length <= 500 piles.length 是偶数。 1 <= piles[i] <= 500
     * sum(piles) 是奇数。
     *
     * @param piles
     * @return
     */
    public static boolean stoneGame(int[] piles) {
        return true;// 先手必赢
    }

    /**
     * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 2 输出: [0,1,1] 示例 2:
     * <p>
     * 输入: 5 输出: [0,1,1,2,1,2] 进阶:
     * <p>
     * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
     * 要求算法的空间复杂度为O(n)。 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的
     * __builtin_popcount）来执行此操作。
     *
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) { // 注意要从1开始，0不满足
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    /**
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     * <p>
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     * <p>
     * 选出任一 x，满足 0 < x < N 且 N % x == 0 。 用 N - x 替换黑板上的数字 N 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     * <p>
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
     * <p>
     * 示例 1： 输入：2 输出：true 解释：爱丽丝选择 1，鲍勃无法进行操作。
     * <p>
     * 示例 2： 输入：3 输出：false 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
     *
     * @param N
     * @return
     */
    public static boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    /**
     * 给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。
     * <p>
     * 示例：
     * <p>
     * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
     * <p>
     * sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 说明:
     * <p>
     * 你可以假设数组不可变。 会多次调用 sumRange 方法。
     *
     * @author alisa
     */
    class NumArray {
        private int[] nums;
        private int[] sum;

        public NumArray(int[] nums) {
            this.nums = nums;

            if (nums.length > 0) {
                sum = new int[nums.length];

                int temp = 0;
                for (int i = 0; i < nums.length; i++) {
                    temp += nums[i];
                    sum[i] = temp;
                }
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? sum[j] : sum[j] - sum[i - 1];
        }
    }

    /**
     * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
     * <p>
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     * <p>
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     * <p>
     * 示例 1:
     * <p>
     * 输入: cost = [10, 15, 20] 输出: 15 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。 示例
     * 2:
     * <p>
     * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] 输出: 6 解释:
     * 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。 注意：
     * <p>
     * cost 的长度将会在 [2, 1000]。 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        int a = 0, b = cost[1] > cost[0] ? cost[0] : cost[1];
        int count = b;

        for (int i = 2; i < cost.length; i++) {
            count = b + cost[i] > a + cost[i - 1] ? a + cost[i - 1] : cost[i] + b;
            a = b;
            b = count;
        }

        return count;
    }

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3,1] 输出: 4 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。 偷窃到的最高金额
     * = 1 + 3 = 4 。 示例 2:
     * <p>
     * 输入: [2,7,9,3,1] 输出: 12 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5
     * 号房屋 (金额 = 1)。 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int maxAmount = 0;
        int a = 0;
        int b = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                maxAmount = a = nums[0];
                continue;
            }
            if (i == 1) {
                maxAmount = b = nums[1] > nums[0] ? nums[1] : nums[0];
                continue;
            }

            maxAmount = nums[i] + a > b ? nums[i] + a : b;
            a = b;
            b = maxAmount;
        }

        return maxAmount;
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 进阶:
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(nums[i], temp + nums[i]);
            max = Math.max(max, temp);
        }

        return max;
    }

    /**
     * 买卖股票的最佳时机 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意你不能在买入股票前卖出股票。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4] 输出: 5 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 =
     * 6）的时候卖出，最大利润 = 6-1 = 5 。 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。 示例 2:
     * <p>
     * 输入: [7,6,4,3,1] 输出: 0 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 1,4,7,0,3
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;

        int min = prices[0];
        int maxPrices = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > maxPrices) {
                maxPrices = prices[i] - min;
            }
        }

        return maxPrices;
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入： 2 输出： 2 解释： 有两种方法可以爬到楼顶。 1. 1 阶 + 1 阶 2. 2 阶 示例 2：
     * <p>
     * 输入： 3 输出： 3 解释： 有三种方法可以爬到楼顶。 1. 1 阶 + 1 阶 + 1 阶 2. 1 阶 + 2 阶 3. 2 阶 + 1 阶
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n >= 2)
            return n;

        int temp1 = 1;
        int temp2 = 2;
        int count = 0;

        for (int i = 2; i < n; i++) {
            count = temp1 + temp2;
            temp1 = temp2;
            temp2 = count;
        }
        return count;
    }
}
