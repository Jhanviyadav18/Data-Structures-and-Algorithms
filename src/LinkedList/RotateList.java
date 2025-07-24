package LinkedList;
class Node5{
    int val;
    ListNode next;
    Node5(int val){
        this.val = val;
    }
    Node5(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class RotateList {
    public ListNode rotateRight(ListNode head, int k){
        if (head == null || k==0){
            return head;
        }
        int length = 0;
        ListNode tail = head;
        while (tail.next != null){
            length++;
            tail = tail.next;
        }
        length++;
        tail.next = head;
        int rotatePoint = length - k % length;

        tail = head;
        while (rotatePoint-- >1){
            tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
    public void printList(ListNode head){
        while (head != null){
            System.out.print(head.val);
            if (head.next != null){
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
        x.next.next.next = new ListNode(4);
        x.next.next.next.next = new ListNode(5);

        int k = 2;

        RotateList obj = new RotateList();
        ListNode result = obj.rotateRight(x,2);
        obj.printList(result);

    }
}
