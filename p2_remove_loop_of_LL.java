package LL_medium;

/*
==========================================================
PROBLEM:)
==========================================================
You are given a linked list of N nodes. Remove the loop from the linked list, if present. 
Note: X is the position of the node to which the last node is connected to. If it is 0, then there is no loop.
Expected time complexity : O(n)
Expected auxiliary space : O(1)

Constraints:
1 <= N <= 104

===================================================================
EXAMPLES:)
===================================================================
N = 4
value[] = {1,8,3,4}
X = 0
Output: 1

N = 3
value[] = {1,3,4}
X = 2
Output: 1
*/

/*
=====================================================================
APPROACH:)
=====================================================================
detect loop (use slow and fast pointers)
if present(slow == fast)
set slow at head
we have to check for the cyclic condition here (when last nodes points to head) i.e., fast = slow = head
in this case we move fast pointer till its next points to head and then set fast.next to null
else
move slow and fast pointers at the same pace till they point (slow.next and fast.next) to same node
set fast.next to null

Time : O(N)
Space: O(1)
*/

public class p2_remove_loop_of_LL extends helper {
 public static void main(String[] args) {

  Node head = new Node(1);
  head.next = new Node(2);
  head.next.next = new Node(4);
  head.next.next.next = new Node(5);
  head.next.next.next.next = new Node(8);
  head.next.next.next.next.next = new Node(7);

  int position = 3;

  makeloop(head, position);
  removeLoop(head);

  printList(head);

 }

 public static void makeloop(Node head, int p) {
  // position and indices are different
  if (p == 0)
   return;
  int c = 1;
  Node current = head;
  Node last = head;

  while (c < p) {
   current = current.next;
   c++;
  }

  while (last.next != null) {
   last = last.next;
  }

  last.next = current;
  return;
 }

 public static void removeLoop(Node head) {
  if (head == null || head.next == null) {
   return;
  }

  Node slow = head;
  Node fast = head;

  // detect loop
  while (fast != null && fast.next != null) { // either breaks, we come out the loop
   slow = slow.next;
   fast = fast.next.next;

   if (slow == fast)
    break;
  }

  // remove loop
  if (slow == fast) {
   slow = head;
   if (fast == head) {
    while (fast.next != head) {
     fast = fast.next;
    }
   } else {
    while (slow.next != fast.next) {
     slow = slow.next;
     fast = fast.next;
    }

    fast.next = null;
   }
  }
 }

 public static void printList(Node head) {
  Node temp = head;
  while (temp != null) {
   System.out.print(temp.data + " ");
   temp = temp.next;
  }
 }

}
