package LL_medium;

/*
=============================================================
 PROBLEM:) 19
============================================================
Given the head of a linked list, remove the nth node from the end of the list and return its head.
The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

=================================================================
EG:
=================================================================
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
*/

/*
=====================================================================
 APPROACH:)
====================================================================
make a dummy node and make it point to head
make a temp pointer (first) and with this count all the nodes in the list
make first point to dummy
take away the value of n from the total length and then, while length is not zero we shift first to the next node
when length will become 0, this is when the node after 'first' is the node that we have to remove 
first.next = first.next.next
return the dummy.next node

Time : O(2L) => O(L); L is the length of the list
Space: O(1)
*/
public class x3_remove_Nth_node_from_the_end extends helper {
 public static void main(String[] args) {
  Node head = new Node(1);
  head.next = new Node(2);
  head.next.next = new Node(3);
  head.next.next.next = new Node(4);
  head.next.next.next.next = new Node(5);

  int n = 2;
  Node res = removeNthFromEnd(head, n);
  if (res == null) {
   System.out.println("[]");
  } else {
   while (res != null) {
    System.out.print(res.data + " ");
    res = res.next;
   }
  }
 }

 public static Node removeNthFromEnd(Node head, int n) {

  Node dummy = new Node(0);
  dummy.next = head;

  Node first = head;
  int length = 0;
  while (first != null) {
   length++;
   first = first.next;
  }

  length -= n;
  first = dummy;
  while (length > 0) {
   length--;
   first = first.next;
  }
  first.next = first.next.next;
  return dummy.next;
 }
}
