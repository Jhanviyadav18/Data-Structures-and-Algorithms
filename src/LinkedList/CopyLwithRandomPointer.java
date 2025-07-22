package LinkedList;
import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyLwithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        //STEP-1 : Create new list with same values
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        //STEP-2 : Copy random pointers
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //STEP-3 : separate two lists
        curr = head;
        Node pseudoHead = new Node(0);
        Node copyCurr = pseudoHead;

        while(curr != null){
            Node front = curr.next.next;

            // extract the copy
            copyCurr.next = curr.next;

            // restore the original list
            curr.next = front;

            copyCurr = copyCurr.next;
            curr = front;
        }
        return pseudoHead.next;
    }
        public static void main(String[] args) {
        int[][] input = {{7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}};

        // Step 1: Build the linked list
        List<Node> nodes = new ArrayList<>();
        for (int[] pair : input) {
            nodes.add(new Node(pair[0]));
        }

        // Link next pointers
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }

        // Link random pointers
        for (int i = 0; i < nodes.size(); i++) {
            int randomIndex = input[i][1];
            if (randomIndex != -1) {
                nodes.get(i).random = nodes.get(randomIndex);
            }
        }

        Node head = nodes.get(0);

        // Step 2: Copy list
            CopyLwithRandomPointer obj = new CopyLwithRandomPointer();
            Node copiedHead = obj.copyRandomList(head);

        // Step 3: Print copied list in format [[val, randomIndex], ...]
        printList(copiedHead);
    }

    static void printList(Node head) {
        // Map original nodes to indices
        Map<Node, Integer> nodeToIndex = new HashMap<>();
        Node temp = head;
        int idx = 0;
        while (temp != null) {
            nodeToIndex.put(temp, idx++);
            temp = temp.next;
        }

        // Now print as [[val, randomIndex], ...]
        List<String> result = new ArrayList<>();
        temp = head;
        while (temp != null) {
            int randIndex = temp.random == null ? -1 : nodeToIndex.get(temp.random);
            result.add("[" + temp.val + "," + (randIndex == -1 ? "null" : randIndex) + "]");
            temp = temp.next;
        }
        System.out.println(result);
    }
}
