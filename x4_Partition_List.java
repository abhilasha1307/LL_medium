package LL_medium;

/*
=========================================================
PROBLEM: 86
=========================================================
Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

The number of nodes in the list is in the range [0, 200].
-100 <= Node.val <= 100
-200 <= x <= 200
*/

/*
===============================================================
APPROACH:)
===============================================================
We make 2 dummy heads (b_head and a_head) and 2 pointers to point to these dummy heads (before and after)
we traverse the LL and check the value of each node, if its less than or greater than = the value of x
if less, we put it in the before list and increment the before pointer and similarly for the values >= 
when head is null, we break out of the loop and make the after.next null so that the last element of the list is not pointing to any other element inside the list
we join the before and the after list and return the b_head.next pointer

order will be preserved as we have made different lists (before and after) and then joined them

Time : O(n); n = number of elements in the LL
Space : O(1)
*/
public class x4_Partition_List extends helper {
 public static void main(String[] args) {
  Node head = new Node(1);
  head.next = new Node(4);
  head.next.next = new Node(3);
  head.next.next.next = new Node(2);
  head.next.next.next.next = new Node(5);
  head.next.next.next.next.next = new Node(2);

  int x = 3;
  Node result = partition(head, x);
  while (result != null) {
   System.out.print(result.data + " ");
   result = result.next;
  }
 }

 public static Node partition(Node head, int x) {
  Node b_head = new Node(0);
  Node before = b_head;
  Node a_head = new Node(0);
  Node after = a_head;

  while (head != null) {
   if (head.data < x) {
    before.next = head;
    before = before.next;
   }

   else {
    after.next = head;
    after = after.next;
   }
   head = head.next;
  }

  after.next = null;

  before.next = a_head.next;
  return b_head.next;
 }
}
