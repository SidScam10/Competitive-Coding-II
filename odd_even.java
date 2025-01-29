class Node {
    int data;
    Node next, prev;
}

class odd_even {
    Node head;

    void segregateEvenOdd() {
        if (head == null) return;

        Node evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = current.prev = null;

            if (current.data % 2 == 0) {
                if (evenStart == null) {
                    evenStart = evenEnd = current;
                } else {
                    evenEnd.next = current;
                    current.prev = evenEnd;
                    evenEnd = current;
                }
            } else {
                if (oddStart == null) {
                    oddStart = oddEnd = current;
                } else {
                    oddEnd.next = current;
                    current.prev = oddEnd;
                    oddEnd = current;
                }
            }
            current = next;
        }

        if (evenStart == null || oddStart == null) return;

        evenEnd.next = oddStart;
        oddStart.prev = evenEnd;
        head = evenStart;
    }

    void push(int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = head;
        if (head != null) head.prev = new_node;
        head = new_node;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        odd_even list = new odd_even();
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            list.push(sc.nextInt());
        }
        System.out.println("Original list:");
        list.printList();
        list.segregateEvenOdd();
        System.out.println("Segregated list (even before odd):");
        list.printList();
        sc.close();
    }
}