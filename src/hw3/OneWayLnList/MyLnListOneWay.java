package hw3.OneWayLnList;

public class MyLnListOneWay<T> {
    Node<T> head;

    public MyLnListOneWay() {
        this.head = null;
    }

    /**
     * Добавление элемента в однонаправленный список
     *
     * @param element
     */
    public void add(T element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node<T> pointer = head;
            while (pointer.hasNext()) {
                pointer = pointer.getNext();
            }
            pointer.setNext(new Node<>(element));
        }
    }

    /**
     * Разворот однонаправленного списка
     */
    public void revert() {
        if (head == null || !(head.hasNext())) return;

        Node<T> pointer = this.head;
        Node<T> tempNext = pointer.getNext();
        Node<T> temp = this.head;

        while (tempNext != null) {

            pointer = tempNext;
            tempNext = pointer.getNext();
            pointer.setNext(temp);
            temp = pointer;

        }
        head.setNext(null);
        head = pointer;

    }

    @Override
    public String toString() {
        StringBuilder listToString = new StringBuilder();

        if (this.head == null) return "{}";

        Node<T> pointer = this.head;
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

    /**
     * Узел для однонаправленного списка
     *
     * @param <T> Элемент узла
     */
    private static class Node<T> {

        private T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
            next = null;
        }

        private Node<T> getNext() {
            return next;
        }

        private T getValue() {
            return value;
        }

        private boolean hasNext() {

            if (this.next == null) return false;
            return true;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
