package com.example.demo.linkedlist;

class OneWayList {

    public static void print(Node node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.getValue());
            if (node.getNext() != null) {
                sb.append(" ");
            }
            node = node.getNext();
        }

        System.out.println(sb.toString());
    }

    public static Node invert(Node head) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node nextElement = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextElement;
        }
        return previous;
    }

    public static boolean detectCycle(Node head) {
        if (head.getNext() == null) return false;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
