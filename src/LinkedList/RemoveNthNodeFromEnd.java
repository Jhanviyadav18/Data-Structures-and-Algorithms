package LinkedList;
class Node3{
    int val;
    ListNode next;
    Node3(int val){
        this.val = val;
    }
    Node3(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;

        //move secondPtr n space ahead
        for (int i=0; i<n; i++){
            secondPtr = secondPtr.next;
        }
        //move both now, until the next secondPtr is null
        while (secondPtr.next != null){
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }
        //we now have to remove the node next of firstPtr
        firstPtr.next = firstPtr.next.next;
        return dummy.next;
    }
    public void printList(ListNode head){
        while (head != null){
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
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

        int n = 2;

        RemoveNthNodeFromEnd obj = new RemoveNthNodeFromEnd();

        System.out.print("Original List: ");
        obj.printList(x);

        ListNode result = obj.removeNthFromEnd(x,n);
        System.out.print("After removing " + n + "th node from end: ");
        obj.printList(result);
    }
}
