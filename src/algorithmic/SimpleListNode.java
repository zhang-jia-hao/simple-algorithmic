package algorithmic;

import dataStructural.ListNode;

public class SimpleListNode {

	public static void main(String[] args) {
		ListNode listNode = new ListNode(5);
		ListNode listNode2 = new ListNode(4);
		listNode2.next = listNode;

		ListNode listNode31 = new ListNode(1);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(2);
		listNode3.next = listNode4;
		listNode4.next = listNode3;
		ListNode listNode5 = new ListNode(1);
		listNode5.next = listNode4;

		// deleteNode(listNode4);
		// ListNode removeNthFromEnd = removeNthFromEnd(listNode5, 1);
		/* ListNode reverseList = reverseList(listNode5); */

		// ListNode mergeTwoLists = mergeTwoLists(listNode5, listNode2);
		/*
		 * while (mergeTwoLists != null) {
		 * System.out.println(mergeTwoLists.val); mergeTwoLists =
		 * mergeTwoLists.next; }
		 */
		//System.out.println(isPalindrome(listNode5));
		System.out.println(hasCycle(listNode5));
	}

	/**
	 * 给定一个链表，判断链表中是否有环。
	 * 
	 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
	 * 
	 * 示例 1：
	 * 
	 * 输入：head = [3,2,0,-4], pos = 1 输出：true 解释：链表中有一个环，其尾部连接到第二个节点。
	 * 示例 2：
	 * 
	 * 输入：head = [1,2], pos = 0 输出：true 解释：链表中有一个环，其尾部连接到第一个节点。
	 * 示例 3：
	 * 
	 * 输入：head = [1], pos = -1 输出：false 解释：链表中没有环。
	 * 
	 * 进阶：
	 * 
	 * 你能用 O(1)（即，常量）内存解决此问题吗？
	 * 
	 * @param head
	 * @return
	 */
	public static boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) return false;
		ListNode last = head.next.next;
		ListNode slow = head;
		
		while(last != null){
			if(last == slow) return true;
			if(last.next == null) return false;
			last = last.next.next;
			slow = slow.next;
		}
		return false;
	}

	/**
	 * 请判断一个链表是否为回文链表。
	 * 
	 * 示例 1:
	 * 
	 * 输入: 1->2 输出: false 示例 2:
	 * 
	 * 输入: 1->2->2->1 输出: true 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
	 * 
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode head) {
		ListNode listNode = head;
		int length = 0;

		while (listNode != null) {
			listNode = listNode.next;
			length++;
		}
		listNode = head;

		for (int i = 0; i < length >> 1; i++) {
			listNode = listNode.next;
		}

		listNode = reverseList(listNode);

		while (listNode != null && head != null) {
			if (listNode.val != head.val)
				return false;
			listNode = listNode.next;
			head = head.next;
		}
		return true;
	}

	public static boolean isPalindrome1(ListNode head) {
		int lhash = 0, rhash = 0;
		for (int x = 1; head != null; head = head.next, x *= 11) {
			lhash = lhash * 11 + head.val;
			rhash = rhash + head.val * x;
		}
		return lhash == rhash;
	}

	/**
	 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
	 * 
	 * 示例：
	 * 
	 * 输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode curr = new ListNode(0);// 当前节点
		ListNode listNode = new ListNode(0);//
		ListNode temp = listNode;

		while (l1 != null || l2 != null) {
			if (l1 != null && l2 != null && l1.val > l2.val) {
				curr = l2;
				l2 = l2.next;
			} else if (l1 == null) {
				curr = l2;
				l2 = l2.next;
			} else if (l2 == null) {
				curr = l1;
				l1 = l1.next;
			} else {
				curr = l1;
				l1 = l1.next;
			}
			curr.next = null;

			temp.next = curr;

			temp = temp.next;
		}

		return listNode.next;
	}

	/**
	 * 反转一个单链表。
	 * 
	 * 示例:
	 * 
	 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL 进阶:
	 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;//
			prev = curr;//
			curr = nextTemp;
		}
		return prev;
	}

	/**
	 * 
	 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
	 * 
	 * 示例：
	 * 
	 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
	 * 
	 * 当删除了倒数第二个节点后，链表变为 1->2->3->5. 说明：
	 * 
	 * 给定的 n 保证是有效的。
	 * 
	 * 进阶：
	 * 
	 * 你能尝试使用一趟扫描实现吗？
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = new ListNode(0);
		node.next = head;

		ListNode listNode = node;
		ListNode listNode2 = node;

		while (listNode != null) {
			if (n < 0) {
				listNode2 = listNode2.next;
			}

			listNode = listNode.next;
			n--;
		}

		listNode2.next = listNode2.next.next;

		return node.next;
	}

	/**
	 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
	 * 
	 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为: 示例 1:
	 * 
	 * 输入: head = [4,5,1,9], node = 5 输出: [4,1,9] 解释: 给定你链表中值为 5
	 * 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9. 示例 2:
	 * 
	 * 输入: head = [4,5,1,9], node = 1 输出: [4,5,9] 解释: 给定你链表中值为 1
	 * 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
	 * 
	 * 说明:
	 * 
	 * 链表至少包含两个节点。 链表中所有节点的值都是唯一的。 给定的节点为非末尾节点并且一定是链表中的一个有效节点。 不要从你的函数中返回任何结果。
	 * 
	 * @param node
	 */
	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
