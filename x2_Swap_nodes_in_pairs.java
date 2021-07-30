package LL_medium;

/*
===========================================================
PROBLEM:) 24
===========================================================
Given a linked list, swap every two adjacent nodes and return its head.

Constraints:
The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100

=============================================================
EXAMPLES:)
=============================================================
Input: head = [1,2,3,4]
Output: [2,1,4,3]
*/

/*
=============================================================
APPROACH:)
=============================================================
we set up 3 nodes previous(points to head), current(points to head.next) and next(points to current.next)

we will make the next of current node point to the previous node 
if the next node is the last in LL or null, make prev.next point to next and come out of the loop

else make prev.next point to next.next(we have to swap the next 2 elements too)
now shift the prev node to next and current to next.next

time complexity: o(N)
space complexity: O(1)
*/
public class x2_Swap_nodes_in_pairs extends helper {

 public static void main(String[] args) {
  Node head = new Node(1);
  head.next = new Node(2);
  head.next.next = new Node(3);
  head.next.next.next = new Node(4);

  Node res = SwapNodes(head);
  while (res != null) {
   System.out.print(res.data + " ");
   res = res.next;
  }
 }

 public static Node SwapNodes(Node head) {
  if (head == null || head.next == null)

  {
   return head;
  }
  Node c = head.next;
  Node p = head;
  head = c;

  while (true) {
   Node n = c.next;
   c.next = p;
   if (n == null || n.next == null) {
    p.next = n;
    break;
   }
   p.next = n.next;
   p = n;
   c = n.next;
  }

  return head;
 }

}
