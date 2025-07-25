package LinkedList;
class ListNode2{
    int val;
    ListNode next;
    ListNode2(int val){
        this.val = val;
    }
    ListNode2(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode ptr = result;
        int carry = 0;
        while (l1 != null || l2 != null){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;
        }
        if (carry == 1) ptr.next = new ListNode(1);
        return result.next;
    }
    //To print a linked list
    public void printList(ListNode head){
        while (head !=null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        solution.printList(result);
    }
}
