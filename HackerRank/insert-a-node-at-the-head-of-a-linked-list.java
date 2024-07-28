// ref: https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list

    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (llist == null) return newNode;
        
        newNode.next = llist;
        return newNode;
    }