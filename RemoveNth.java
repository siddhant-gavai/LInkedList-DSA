public class RemoveNth {

    // Node class
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // head & tail
    public Node head;
    public Node tail;
    public int size; // static hata diya (important)

    // add first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // add last
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // print list
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
        System.out.println("null");
    }

    // 🔥 remove nth node from end
    public void removeNthFromEnd(int n) {

        // case 1: remove head
        if (n == size) {
            head = head.next;
            size--;
            return;
        }

        // step 1: find previous node index
        int idxToFind = size - n;
        Node prev = head;

        for (int i = 1; i < idxToFind; i++) {
            prev = prev.next;
        }

        // step 2: remove node
        prev.next = prev.next.next;

        // step 3: update tail if needed
        if (prev.next == null) {
            tail = prev;
        }

        size--;
    }

    // main method
    public static void main(String[] args) {
        RemoveNth ll = new RemoveNth();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.printList();
        System.out.println("Size: " + ll.size);

        ll.removeNthFromEnd(2); // remove 2nd from end
        ll.printList();
        System.out.println("Size: " + ll.size);
    }
}
