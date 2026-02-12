public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size; // size is not used in this implementation but can be useful for other
                            // operations

    public void addFirst(int data) {
        size++;
        // step 1: create new node
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2: newNode next = head
        newNode.next = head;
        // step 3: head = newNode
        head = newNode;

    }

    public void addLast(int data) {
        size++;
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // print linked list
    public void printList() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println(" null");
    }

    public void add(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // i = idx -1 ; temp --> prev
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE; // or throw an exception
        } else if (size == 1) {
            int val = head.data;
            head = tail = null; // If it was the only element, set head and tail to null
            size = 0; // Update size
            return val;
        }
        int val = head.data;
        head = head.next;
        size--; // Decrease the size of the linked list
        return val;
    }

    // Method to remove the last element (not implemented in the original code)
    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE; // or throw an exception
        } else if (size == 1) {
            int val = head.data;
            head = tail = null; // If it was the only element, set head and tail to null
            size = 0; // Update size
            return val;
        }
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next; // Traverse to the second last node
        }
        int val = prev.next.data; // Get the value of the last node
        prev.next = null; // Remove the last node
        tail = prev; // Update tail to the second last node
        size--; // Decrease the size of the linked list
        return val; // Return the value of the removed last node.
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.printList();
        ll.addFirst(2);
        // ll.printList();
        ll.addFirst(1);
        // ll.printList();
        ll.addLast(4);
        // ll.printList();
        ll.addLast(5);
        ll.add(2, 3);
        ll.printList();
        System.out.println(ll.size); // Print the size of the linked list
        System.out.println(ll.removeFirst()); // Remove the first element and print it
        ll.printList(); // Print the linked list after removing the first element

        System.out.println(ll.size); // Print the size of the linked list
        System.out.println(ll.removeLast()); // Remove the last element and print it
        ll.printList(); // Print the linked list after removing the last element
        System.out.println(ll.size); // Print the size of the linked list
    }
}