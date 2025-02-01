class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    boolean isEmpty() {
        return head == null;
    }

    void deleteAtBeginning() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
    }

    void deleteAtEnd() {
        if (isEmpty()) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    void deleteByValue(int value) {
        if (isEmpty()) {
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return;
        }

        previous.next = current.next;
    }

    void printList() { 
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);

        System.out.println("Original list:");
        list.printList();

        list.deleteAtBeginning();
        System.out.println("After deleting at beginning:");
        list.printList();

        list.deleteAtEnd();
        System.out.println("After deleting at end:");
        list.printList();

        list.deleteByValue(2);
        System.out.println("After deleting value 2:");
        list.printList();

        // More tests
        LinkedList list2 = new LinkedList();
        list2.head = new Node(1);
        list2.deleteByValue(5); //Doesn't exist
        System.out.println("After deleting 5 (not found):");
        list2.printList();

        LinkedList list3 = new LinkedList();
        list3.deleteAtBeginning();
        System.out.println("After deleting from empty list:");
        list3.printList();
    }
}
