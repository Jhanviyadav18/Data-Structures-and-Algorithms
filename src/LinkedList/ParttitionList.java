package LinkedList;

class ListNode6 {
    int val;
    ListNode next;
    ListNode6() {}
    ListNode6(int val) { this.val = val; }
    ListNode6(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ParttitionList {
    public ListNode partitionList(ListNode head, int x){
        ListNode small = new ListNode(0);    // dummy head for small list
        ListNode higher = new ListNode(0);   // dummy head for higher list

        ListNode smallHead = small, higherHead = higher;

        while (head != null){
            if (head.val < x){
                // Add to small list
                smallHead.next = head;
                smallHead = smallHead.next;
            } else {
                // Add to high list
                higherHead.next = head;
                higherHead = higherHead.next;
            }
            head = head.next;
        }

        higherHead.next = null;            // ✅ Important: close the higher list
        smallHead.next = higher.next;      // ✅ Connect small list to high list

        return small.next;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;
        ParttitionList obj = new ParttitionList();
        ListNode result = obj.partitionList(head, x);
        obj.printList(result);  // ✅ Correct method to print result
    }
}
