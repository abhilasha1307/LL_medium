package LL_medium;

public class p4_mergeSort_for_LL extends helper {

 public static void main(String[] args) {
  Node head = new Node(3);
  head.next = new Node(5);
  head.next.next = new Node(2);
  head.next.next.next = new Node(4);
  head.next.next.next.next = new Node(1);

  Node res = sort(head);
  while (res != null) {
   System.out.print(res.data + " ");
   res = res.next;
  }
 }

 public static Node sort(Node head) {
  if (head == null || head.next == null) {
   return head;
  }

  Node mid = getMiddle(head);
  Node Next_of_mid = mid.next;

  mid.next = null;

  Node left = sort(head);
  Node right = sort(Next_of_mid);

  Node result = merge(left, right);
  return result;
 }

 public static Node getMiddle(Node temp) {
  Node slow = temp;
  Node fast = temp.next;

  while (fast != null && fast.next != null) {
   slow = slow.next;
   fast = fast.next.next;
  }
  return slow;
 }

 public static Node merge(Node A, Node B) {
  if (A == null) {
   return B;
  }

  if (B == null) {
   return A;
  }

  Node result;
  if (A.data <= B.data) {
   result = A;
   result.next = merge(A.next, B);
  } else {
   result = B;
   result.next = merge(A, B.next);
  }
  return result;
 }
}
