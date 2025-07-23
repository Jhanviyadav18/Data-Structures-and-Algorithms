package LinkedList;

import java.util.Stack;

class Node1{
    int val;
    ListNode next;
    Node1(int val) {
        this.val = val;
    }
    Node1(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
//public class ReverseAlinkedList {
    //with extra space TC = O(n), SC = O(n)
    //Stack methode
//    public ListNode reverseWithStack(ListNode head){
//        Stack<Integer> valueStack = new Stack<>();
//        while (head != null){
//            valueStack.push(head.val);
//            head = head.next;
//        }
//        ListNode reverseList = new ListNode(Integer.MIN_VALUE);
//        ListNode ptr = reverseList;
//        while (!valueStack.isEmpty()){
//            ptr.next = new ListNode(valueStack.pop());
//            ptr = ptr.next;
//        }
//        return reverseList;
//    }

//WITHOUT USING EXTRA SPACE
public class ReverseAlinkedList {
    public ListNode reverseWithoutExtraSpace(ListNode head){
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode preNode = null;
        ListNode currNode = head;
        while (currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        head = preNode;
        return head;
}
    public void printList(ListNode head){
        while (head != null){
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

        ReverseAlinkedList obj = new ReverseAlinkedList();
        System.out.print("ORIGINAL LIST: ");
        obj.printList(x);

//        ListNode reversed = obj.reverseWithStack(x);
//        System.out.print("REVERSED LIST: ");
//        obj.printList(reversed);

        ListNode reversed = obj.reverseWithoutExtraSpace(x);
        System.out.print("REVERSED LIST: ");
        obj.printList(reversed);
    }
}
