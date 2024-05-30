class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListOperations {
    private Node head;

    public void insertAtPosition(int position, int data) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previous = head;
            for (int i = 1; i < position - 1 && previous != null; i++) {
                previous = previous.next;
            }
            if (previous == null) {
                System.out.println("Invalid position");
                return;
            }
            newNode.next = previous.next;
            previous.next = newNode;
        }
    }

    /**
     * @param position
     */
    public void deleteAtPosition(int position) {
        if (head == null) {
            return;
        }
        if (position == 1) {
            head = head.next;
        } else {
            Node previous = head;
            for (int i = 1; i < position - 1 && previous != null; i++) {
                previous = previous.next;
            }
            if (previous == null || previous.next == null) {
                System.out.println("Invalid position");
                return;
            }
            previous.next = previous.next.next;
        }
    }

    public void deleteAfterNode(Node prevNode) {
        if (prevNode == null  || prevNode.next == null) {
            System.out.println("Invalid previous node");
            return;
        }
        prevNode.next = prevNode.next.next;
    }

    public boolean searchNode(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

public class LinkedlistsAndStack {
    public static void main(String[] args) {
        LinkedListOperations listOps = new LinkedListOperations();
        listOps.insertAtPosition(1, 10);
        listOps.insertAtPosition(2, 20);
        listOps.insertAtPosition(3, 30);
        listOps.insertAtPosition(4, 40);
        listOps.deleteAtPosition(2);
        System.out.println("Is 20 present in the linked list? " + listOps.searchNode(20));
        Stack stack = new Stack();
        stack.push(50);
        stack.push(60);
        stack.push(70);
        System.out.println("Popped element from stack: " + stack.pop());
        System.out.println("Top element of stack: " + stack.peek());
    }
}