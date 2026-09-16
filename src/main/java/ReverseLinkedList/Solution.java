package ReverseLinkedList;

// * Definition for singly-linked list.
class ListNode {
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

//[0, 1, 2, 3, 4, 5]
//[5, 4, 3, 2, 1, 0]

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;

        ListNode nextAfterHead = head.next;
        ListNode endOfResult = new ListNode(head.val, null);
        ListNode result = new ListNode();
        while(nextAfterHead != null){
            result.val = nextAfterHead.val;
            result.next = endOfResult;
            endOfResult = new ListNode(result.val, result);
            nextAfterHead = nextAfterHead.next;
            result = new ListNode();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
