package LinkedListCycle;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slowNode = head, fastNode = head;

        while (fastNode.next != null && fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if (fastNode.equals(slowNode))
                return true; // use fastNode == slowNode since the class does not override equals so it compares references
        }

        return false;
    }
}
