package LL_medium;

/*
==============================================================================================
PROBLEM:) 
==============================================================================================
Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
(i) a next pointer to the next node,
(ii) a bottom pointer to a linked list where this node is head.
Each of the sub-linked-list is in sorted order.
Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
Note: The flattened list will be printed using the bottom pointer instead of next pointer.

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(1)

==============================================================================================
EXAMPLE:
=============================================================================================
Input:
5 -> 10 -> 19 -> 28
|     |     |     | 
7     20    22   35
|           |     | 
8          50    40
|                 | 
30               45

Output:  5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
*/

/*
==============================================================================================
APPROACH:)
==============================================================================================

*/
public class p3_flatten_LL {

 static class Node {
  int data;
  Node next;
  Node down;

  Node(int d) {
   data = d;
   next = null;
   down = null;
  }
 }

 public static void main(String[] args) {
  Node head = new Node(5);
  head.down = new Node(7);
  head.down.down = new Node(8);
  head.down.down.down = new Node(30);

  head.next = new Node(10);
  head.next.down = new Node(20);

  head.next.next = new Node(19);
  head.next.next.down = new Node(22);
  head.next.next.down.down = new Node(50);

  head.next.next.next = new Node(28);
  head.next.next.next.down = new Node(35);
  head.next.next.next.down.down = new Node(40);
  head.next.next.next.down.down.down = new Node(45);

  Node res = flatten(head);
  while (res != null) {
   System.out.print(res.data + " ");
   res = res.down;
  }
  System.out.println();
 }

 public static Node flatten(Node head) {
  if (head == null || head.next == null) {
   return head;
  }

  head.next = flatten(head.next);

  head = merge(head, head.next);
  return head;
 }

 public static Node merge(Node a, Node b) {
  if (a == null) {
   return b;
  }

  if (b == null) {
   return a;
  }

  Node result;

  if (a.data < b.data) {
   result = a;
   result.down = merge(a.down, b);
  } else {
   result = b;
   result.down = merge(a, b.down);
  }

  result.next = null;
  return result;
 }

}
