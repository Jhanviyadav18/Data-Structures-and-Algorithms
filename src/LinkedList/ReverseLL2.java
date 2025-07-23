package LinkedList;

class Node2{
    int val;
    ListNode next;
    Node2(int val){
        this.val = val;
    }
    Node2(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class ReverseLL2 {
    public ListNode reverseBetween(ListNode head, int left, int right){
        //create dummy list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftPre = dummy;
        ListNode currNode = head;
        for (int i = 0; i < left - 1; i++) {
            leftPre = leftPre.next;
            currNode = currNode.next;
        }

        ListNode preNode = null;
        ListNode subListTail = currNode;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }

        leftPre.next = preNode;
        subListTail.next = currNode;

        return dummy.next;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode x = new ListNode(4);
        x.next = new ListNode(8);
        x.next.next = new ListNode(15);
        x.next.next.next = new ListNode(16);
        x.next.next.next.next = new ListNode(23);
        x.next.next.next.next.next = new ListNode(42);

        ReverseLL2 obj = new ReverseLL2();
        System.out.print("Original List: ");
        obj.printList(x);

        int left = 2;
        int right = 4;

        ListNode result = obj.reverseBetween(x, left, right);

        System.out.print("After Reversing from position " + left + " to " + right + ": ");
        obj.printList(result);
    }
}
