package leet_hw1;

/**
 * #160 Intersection of Two Linked Lists Add to List Write a program to find the
 * node at which the intersection of two singly linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
 * A: a1 → a2 ↘ c1 → c2 → c3 ↗ B: b1 → b2 → b3
 * 
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null. The linked
 * lists must retain their original structure after the function returns. You
 * may assume there are no cycles anywhere in the entire linked structure. Your
 * code should preferably run in O(n) time and use only O(1) memory.
 * 
 * @author liyugong
 *
 */
public class hw2_intersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		if (headA == headB)
			return headA;
		int lA = 0;
		int lB = 0;
		// save the head
		ListNode hA = headA;
		ListNode hB = headB;
		// get the length of list A and B
		while (headA != null) {
			lA += 1;
			headA = headA.next;
		}
		while (headB != null) {
			lB += 1;
			headB = headB.next;
		}
		// let the longer one start early by length diff
		if (lA > lB) {
			int diff = lA - lB;
			while (diff > 0) {
				hA = hA.next;
				diff -= 1;
			}
			while (hA != null) {
				if (hA == hB)
					return hA;
				hA = hA.next;
				hB = hB.next;
			}
		} else {
			int diff = lB - lA;
			while (diff > 0) {
				hB = hB.next;
				diff -= 1;
			}
			while (hA != null) {
				if (hA == hB)
					return hA;
				hA = hA.next;
				hB = hB.next;
			}
		}
		return null;

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// boundary check
		if (headA == null || headB == null)
			return null;

		ListNode a = headA;
		ListNode b = headB;

		// if a & b have different len, then we will stop the loop after second
		// iteration
		while (a != b) {
			// for the end of first iteration, we just reset the pointer to the
			// head of another linkedlist
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}

		return a;

	}
}
