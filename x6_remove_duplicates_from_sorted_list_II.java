package LL_medium;

public class x6_remove_duplicates_from_sorted_list_II extends helper {

 public static void main(String[] args) {
  Node head = new Node(1);
  head.next = new Node(2);
  head.next.next = new Node(2);
  head.next.next.next = new Node(3);
  head.next.next.next.next = new Node(3);
  head.next.next.next.next.next = new Node(3);

  Node res = deleteDuplicates(head);
  if (res == null) {
   System.out.print("null");
  } else {
   while (res != null) {
    System.out.print(res.data + " ");
    res = res.next;
   }
  }

 }

 public static Node deleteDuplicates(Node head) {
  Node dummy = new Node(0, head);
  Node prev = dummy;

  while (head != null) {
   if (head.next != null && head.data == head.next.data) {
    while (head.next != null && head.data == head.next.data) {
     head = head.next;
    }
    prev.next = head.next;
   } else {
    prev = prev.next;
   }

   head = head.next;
  }
  return dummy.next;

 }
}