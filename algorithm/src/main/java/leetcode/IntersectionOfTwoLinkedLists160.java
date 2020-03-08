package leetcode;

public class IntersectionOfTwoLinkedLists160 {

  public static class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }

    @Override
    public String toString() {
      return "ListNode{" +
          "val=" + val +
          '}';
    }
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    int lengthA = getLength(headA);
    int lengthB = getLength(headB);

    if(lengthA > lengthB) {
      headA = skipNodes(lengthA - lengthB, headA);
    } else if (lengthA < lengthB) {
      headB = skipNodes(lengthB - lengthA, headB);
    }

    while(headA != null && headB != null) {
      if(headA == headB) {
        return headA;
      } else {
        headA = headA.next;
        headB = headB.next;
      }

    }

    return null;
  }

  private ListNode skipNodes(int i, ListNode n) {
    while(-- i >= 0) {
      n = n.next;
    }
    return n;
  }

  private int getLength(ListNode n) {
    ListNode a = n;
    int length = 0;
    while(a != null) {
      length ++;
      a = a.next;
    }
    return length;
  }

  /**
   * 2
   * [0,9,1,2,4]
   * [3,2,4]
   * 3
   * 1
   * @param args
   */
  public static void main(String[] args) {
    ListNode n0 = new ListNode(0);
    ListNode n1 = new ListNode(9);
    ListNode n2 = new ListNode(1);
    ListNode n3 = new ListNode(2);
    ListNode n4 = new ListNode(4);
    ListNode n5 = new ListNode(3);

    n0.next = n1;
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;

    n5.next = n3;

    System.out.println(new IntersectionOfTwoLinkedLists160().getIntersectionNode(n0, n5));

  }
}
