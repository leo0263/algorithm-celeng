// ref: https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
// weird problem, why do I need to iterate the linked list each time? just give pointer to the tail lah

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head == null) return newNode;
        
        SinglyLinkedListNode pointer = head;
        while (pointer.next != null) pointer = pointer.next;
        pointer.next = newNode;
        return head;
    }