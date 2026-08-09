package Lab04.pack;

public class LinkedList_Challenges_680123 {
    static public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode n) {
            this.val = val;
            this.next = n;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        if(head.val==val){
            head = head.next;
            return removeElements(head, val);
        }
        head.next = removeElements(head.next, val);
        return head;
    }

    public ListNode deepCopyRightHalf(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new ListNode(head.val);
        ListNode copyHead = deepCopyRightHalf(head.next);   
        return copyHead;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
