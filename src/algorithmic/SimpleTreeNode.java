package algorithmic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import dataStructural.TreeNode;

public class SimpleTreeNode {

	public static void main(String[] args) {

		TreeNode treeNode = new TreeNode(1);
		TreeNode leftNode = new TreeNode(2);
		TreeNode rightNode = new TreeNode(3);

		leftNode.left = new TreeNode(4);
		rightNode.right = new TreeNode(5);

		treeNode.left = leftNode;
		treeNode.right = rightNode;

		int[] i = {0,1,2};
		// System.out.println(maxDepth(treeNode5));
		// System.out.println(isValidBST(treeNode));
		// System.out.println(isSymmetric(treeNode));
		List<List<Integer>> levelOrder = levelOrder(sortedArrayToBST(i));
		for (List<Integer> list : levelOrder) {
			for (Integer integer : list) {
				System.out.print(integer + ",");
			}
			System.out.println();
		}
	}

	/**
	 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
	 * 
	 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
	 * 
	 * 示例:
	 * 
	 * 给定有序数组: [-10,-3,0,5,9],
	 * 
	 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
	 * 
	 * 0 / \ -3 9 / / -10 5
	 * 
	 * @param nums
	 * @return
	 */
	public static TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums,0,nums.length -1);
	}
	
	public static TreeNode sortedArrayToBST(int[] nums,int l,int r){
		if(l > r) return null;
		
		int mid = l + ((r-l) >> 1); 
		TreeNode treeNode = new TreeNode(nums[mid]);
		
		treeNode.left = sortedArrayToBST(nums,l,mid - 1);
		treeNode.right = sortedArrayToBST(nums,mid + 1,r);
		
		return treeNode;
	}

	/**
	 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
	 * 
	 * 例如: 给定二叉树: [3,9,20,null,null,15,7],
	 * 
	 * 3 / \ 9 20 / \ 15 7 返回其层次遍历结果：
	 * 
	 * [ [3], [9,20], [15,7] ]
	 * 
	 * @param root
	 * @return
	 */
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null)
			return list;
		List<Integer> arrayList;
		Queue<TreeNode> currQueue = new LinkedList<>();
		currQueue.offer(root);

		while (!currQueue.isEmpty()) {
			arrayList = new ArrayList<>();
			int length = currQueue.size();

			for (int i = 0; i < length; i++) {
				TreeNode treeNode = currQueue.poll();
				arrayList.add(treeNode.val);
				if (treeNode.left != null)
					currQueue.offer(treeNode.left);
				if (treeNode.right != null)
					currQueue.offer(treeNode.right);
			}
			list.add(arrayList);
		}

		return list;
	}

	public List<List<Integer>> leverOrder(TreeNode root, List<List<Integer>> list) {
		if (root == null)
			return list;
		List<Integer> arrayList = new ArrayList<>();
		if (root.left != null)
			arrayList.add(root.left.val);
		if (root.right != null)
			arrayList.add(root.right.val);
		list.add(arrayList);

		return list;
	}

	/**
	 * 给定一个二叉树，检查它是否是镜像对称的。
	 * 
	 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
	 * 
	 * 1 / \ 2 2 / \ / \ 3 4 4 3 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
	 * 
	 * 1 / \ 2 2 \ \ 3 3 说明:
	 * 
	 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isSymmetric(TreeNode root) {
		return isSymmetric(root.left, root.right);
	}

	public static boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
		if (leftNode == null && rightNode == null)
			return true;
		if (leftNode == null || rightNode == null)
			return false;

		return leftNode.val == rightNode.val && isSymmetric(leftNode.left, rightNode.right)
				&& isSymmetric(leftNode.right, rightNode.left);
	}

	/**
	 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
	 * 
	 * 假设一个二叉搜索树具有如下特征：
	 * 
	 * 节点的左子树只包含小于当前节点的数。 节点的右子树只包含大于当前节点的数。 所有左子树和右子树自身必须也是二叉搜索树。 示例 1:
	 * 
	 * 输入: 2 / \ 1 3 输出: true 示例 2:
	 * 
	 * 输入: 5 / \ 1 4 / \ 3 6 输出: false 解释: 输入为: [5,1,4,null,null,3,6]。 根节点的值为 5
	 * ，但是其右子节点值为 4 。
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isValidBST(TreeNode root) {
		return root == null ? true : isValidTree(root, Long.MAX_VALUE, Long.MIN_VALUE);
		// return root == null ? true : (root.left != null ? root.val >
		// root.left.val : true) && (root.right != null ? ( root.right.left !=
		// null ? root.val < root.right.val && root.val < root.right.left.val :
		// root.val < root.right.val) : true) && isValidBST(root.left) &&
		// isValidBST(root.right);
	}

	public static boolean isValidTree(TreeNode node, long max, long min) {
		if (node == null)
			return true;
		if (node.val >= max || node.val <= min)
			return false;

		return isValidTree(node.left, node.val, min) && isValidTree(node.right, max, node.val);
	}

	/**
	 * 给定一个二叉树，找出其最大深度。
	 * 
	 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
	 * 
	 * 说明: 叶子节点是指没有子节点的节点。
	 * 
	 * 示例： 给定二叉树 [3,9,20,null,null,15,7]，
	 * 
	 * 3 / \ 9 20 / \ 15 7
	 * 
	 * @param root
	 * @return
	 */
	public static int maxDepth(TreeNode root) {
		return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
