package com.cyq7on.sword2offer.linklist;


public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        copyNode(head);
        setRandomNode(head);
        return getCopyNodes(head);
    }

    private Node copyNode(Node head) {
        if (head == null) {
            return null;
        }
        Node node = new Node(head.val);
        node.next = copyNode(head.next);
        head.next = node;
        return head;
    }

    private void setRandomNode(Node head) {
        if (head == null) {
            return;
        }
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            if(cur.random != null) {
                next.random = cur.random.next;
            }
            cur = next.next;
        }
    }

    private Node getCopyNodes(Node head) {
        if (head == null) {
            return null;
        }
        Node origin = head;
        Node copyHead = head.next;
        Node cur = origin.next;
        while (cur.next != null) {
            Node next = cur.next;
            origin.next = next;
            cur.next = next.next;
            origin = origin.next;
            cur = cur.next;
        }
        origin.next = null;
        return copyHead;
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer copyListwithRandomPointer = new CopyListWithRandomPointer();
        Node node = new Node(new int[]{7, 13, 11, 10, 1});
        System.out.println(copyListwithRandomPointer.copyNode(node));
        System.out.println(copyListwithRandomPointer.getCopyNodes(node));
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int[] arr) {
            if (arr.length == 0) {
                return;
            }
            val = arr[0];
            Node cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new Node(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node cur = this;
            while (cur != null) {
                sb.append(cur.val).append("->");
                cur = cur.next;
            }
            sb.append("null");
            return sb.toString();
        }
    }
}
