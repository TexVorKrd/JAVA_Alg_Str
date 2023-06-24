package hw3.OneWayLnList;

public class MyLnListTwoWay<T> {
    private int size = 0;
    private Node head;
    private Node tail;

    public MyLnListTwoWay() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addFirst(T element) {
        Node<T> node = new Node<>(element);

        if (head == null) {
            head = new Node(element);
            tail = node;
            head = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
            head = node;
        }
        this.size++;
    }

    public void addLast(T element) {
        if (head == null) {
            addFirst(element);
        } else {
            Node<T> node = new Node<>(element);
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
            this.size++;
        }

    }

    public void delLast() {
        if (size == 0) return;
        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
        }
    }

    public void delFirst() {
        if (size == 0) return;
        if (size == 1) {
            head = null;
            tail = null;
            size = 0;
        } else {
            head = head.getNext();
            head.setPrev(null);
            size--;
        }
    }

    public void revert() {
        if (size < 2) return;

        Node<T> pointer = this.tail.getPrev();
        Node<T> temp = this.tail;

        while (pointer != null) {

            temp.setPrev(temp.getNext());
            temp.setNext(pointer);

            pointer = pointer.getPrev();
            temp = temp.getNext();

        }
        temp.setPrev(temp.getNext());
        temp.setNext(pointer);

        head = tail;
        tail = temp;
    }

    private static class Node<T> {

        private T value;
        private Node<T> next;
        private Node<T> prev;

        private Node(T value) {
            this.value = value;
            next = null;
            prev = null;
        }

        private MyLnListTwoWay.Node<T> getNext() {
            return next;
        }

        private Node<T> getPrev() {
            return prev;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }

        private void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        private T getValue() {
            return value;
        }

        private boolean hasNext() {

            if (this.next == null) return false;
            return true;
        }

        private boolean hasPrev() {

            if (this.prev == null) return false;
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder listToString = new StringBuilder();

        if (this.head == null) return "{}";

        Node pointer = this.head;
        listToString.append("{ ");
        while (pointer != null) {
            listToString.append(pointer.getValue());
            if (pointer.hasNext()) {
                listToString.append(",");
            }
            listToString.append(" ");
            pointer = pointer.getNext();
        }

        listToString.append("}");
        return listToString.toString();
    }
}
