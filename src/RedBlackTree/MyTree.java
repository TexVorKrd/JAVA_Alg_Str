package RedBlackTree;

public class MyTree<V extends Comparable<V>> {

    private Node root;

    public boolean add(V value) {
        if (root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = NodeColor.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = NodeColor.BLACK;
            root.value = value;
            return true;
        }
    }

    private boolean addNode(Node node, V value) {
        if (node.value == null || value == null) {
            return false;
        }

        if (node.value.equals(value)) {
            return false;
        } else {
            if (node.value.compareTo(value) > 0) {
                if (node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node();
                    node.leftChild.color = NodeColor.RED;
                    node.leftChild.value = value;
                    return true;
                }
            } else {
                if (node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node();
                    node.rightChild.color = NodeColor.RED;
                    node.rightChild.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalanse;
        do {
            needRebalanse = false;
            if (result.rightChild != null && result.rightChild.color == NodeColor.RED &&
                    (result.leftChild != null && result.leftChild.color == NodeColor.BLACK)) {
                needRebalanse = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == NodeColor.RED &&
                    result.leftChild.leftChild != null && result.leftChild.leftChild.color == NodeColor.RED) {
                needRebalanse = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == NodeColor.RED &&
                    result.rightChild != null && result.rightChild.color == NodeColor.RED) {
                needRebalanse = true;
                colorSwap(result);
            }
        }
        while (needRebalanse);
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = NodeColor.RED;
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = NodeColor.RED;
        return leftChild;

    }

    private void colorSwap(Node node) {
        node.rightChild.color = NodeColor.BLACK;
        node.leftChild.color = NodeColor.BLACK;
        node.color = NodeColor.RED;
    }

    private class Node {
        private V value;
        private NodeColor color;
        private Node leftChild;
        private Node rightChild;
    }

    private enum NodeColor {
        RED, BLACK
    }

    @Override
    public String toString() {
        return "MyTree{" +
                "root=" + root +
                "value=" + root.value.toString() +
                '}';
    }

    public Node getRoot() {
        return root;
    }
}
