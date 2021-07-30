package LL_medium;

/*
=================================================================
PROBLEM:)
=================================================================
Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.
Constraints:
1 ≤ N + M ≤ 2*105
-1000 ≤ value ≤ 1000

================================================================
EXAMPLE:)

Input: 
Linked List 1 = 4->1->common
Linked List 2 = 5->6->1->common
common = 8->4->5->NULL
Output: 8
=================================================================
*/

/*
======================================================================
APPROACH:)
======================================================================
as the lists are intersecting (supposedly), we will put temporary pointers on head1 and head2 (t1 and t2) and make them move by one position till either both the pointers arrive at the same node or become null
if they become null, we assign them to the head of the other list this time, so that the pointer of the smaller list can catch up with the pointer of the bigger list, so that they can reach the intersection node simultaneously


Time : O(N+M)
Space : O(1)
*/
public class p1_intersection_in_LL extends helper {
 public static void main(String[] args) {

  Node head1 = new Node(4);
  Node tail1 = head1;
  tail1.next = new Node(1);
  tail1 = tail1.next;

  Node head2 = new Node(5);
  Node tail2 = head2;
  tail2.next = new Node(6);
  tail2 = tail2.next;
  tail2.next = new Node(1);
  tail2 = tail2.next;

  Node head3 = new Node(8);
  tail1.next = head3;
  tail2.next = head3;
  Node tail3 = head3;

  tail3.next = new Node(4);
  tail3 = tail3.next;
  tail3.next = new Node(5);
  tail3 = tail3.next;

  System.out.println(Intersection_Point(head1, head2));
 }

 public static int Intersection_Point(Node head1, Node head2) {
  Node t1 = head1;
  Node t2 = head2;

  while (t1 != t2) {
   t1 = t1.next;
   t2 = t2.next;

   if (t1 == t2) {
    if (t1 == null) {
     return -1;
    }
    return t1.data;
   }

   if (t1 == null) {
    t1 = head2;
   }

   if (t2 == null) {
    t2 = head1;
   }

  }

  return -1;
 }
}