package LinkedList;
class ListNode1{
    int val;
    ListNode next;
    ListNode1(int val){
        this.val = val;
    }
    ListNode1(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        //Dummy node to make code cleaner
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        //merge
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        //attach remaining nodes
        if (list1 != null) current.next = list1;
        if (list2 != null) current.next = list2;

        return dummy.next;
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        MergeTwoSortedList solution = new MergeTwoSortedList();
        ListNode merged = solution.mergeTwoLists(list1,list2);

        printList(merged);

    }
}
