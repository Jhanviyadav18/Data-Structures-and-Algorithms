package LinkedList;
class ListNode{
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
        next = null;
    }
}

public class CycleInLL {
    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = head.next;
            fast = fast.next.next;
            if (slow == fast){
                return true; //cycle detected
            }
        }
        return false; //no cycle
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(0);
        ListNode fourth = new ListNode(-4);

        //cycle
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        CycleInLL detect = new CycleInLL();
        System.out.println("Cycle detected: " + detect.hasCycle(head));
    }
}
