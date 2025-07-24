package LinkedList;
class Node4{
    int val;
    ListNode next;
    Node4(int val){
        this.val = val;
    }
    Node4(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class RemoveDuplicates2 {
    public ListNode deleteDuplicate(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        //ITS FOR REMOVING DUPLICATES
        // while (curr != null && curr.next != null) {
        //     if (curr.val == curr.next.val) {
        //         curr.next = curr.next.next; // Skip the duplicate
        //     } else {
        //         curr = curr.next;
        //     }
        // }

        //ITS FOR DELETING DUPLICATES
        //dummy node for handling duplicates at the beginning
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null){
            //check for duplicate
            if (head.next != null && head.val == head.next.val){
                //skip all nodes with this value
                while (head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                prev.next = head.next; // remove all duplicates
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
    public void printList(ListNode head){
        while ( head != null){
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode x = new ListNode(1);
        x.next = new ListNode(2);
        x.next.next = new ListNode(3);
        x.next.next.next = new ListNode(3);
        x.next.next.next.next = new ListNode(4);
        x.next.next.next.next.next = new ListNode(4);
        x.next.next.next.next.next.next = new ListNode(5);

        RemoveDuplicates2 obj = new RemoveDuplicates2();
        ListNode result = obj.deleteDuplicate(x);
        obj.printList(x);
    }
}
