package LL_medium;

//What if the the digits in the linked list are stored in non-reversed order? For example:
//(3\to 4\to 2)+(4\to 6\to 5)=8\to 0\to 7(3→4→2)+(4→6→5)=8→0→7
//use recursion (GFG)
/*
========================================================
PROBLEM:) 2
========================================================
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

CONSTRAINTS
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.


===============================================================
EXAMPLES:)
===============================================================
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*/

/*
==============================================================
APPROACH:)
==============================================================
We will traverse the two lists(till both are empty[not necessary to be simultaneous]) and add the value of nodes and store the sum and the carry in variables

Time: O(max(m,n))
Space: O(max(m,n)). The length of the new list is at most max(m,n)+1.
*/
public class x1_add_two_numbers extends helper {

  public static void main(String[] args) {
    Node l1 = new Node(2);
    l1.next = new Node(4);
    l1.next.next = new Node(3);

    Node l2 = new Node(5);
    l2.next = new Node(6);
    l2.next.next = new Node(4);

    Node result = addTwoNumbers(l1, l2);
    while (result != null) {
      System.out.print(result.data + " ");
      result = result.next;
    }

  }

  public static Node addTwoNumbers(Node l1, Node l2) {
    Node h3 = new Node(0);
    Node temp = h3;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int sum = carry + (l1 != null ? l1.data : 0) + (l2 != null ? l2.data : 0);
      carry = sum / 10; // 12/10 = 1.2 => storing in carry(type : int) it will become 1
      temp.next = new Node(sum % 10); // to store the even place of the two digit number(if that) in the node temp
      temp = temp.next;

      if (l1 != null)
        l1 = l1.next;
      if (l2 != null)
        l2 = l2.next;

    }

    if (carry > 0) {
      temp.next = new Node(carry);
    }

    return h3.next;
  }
}