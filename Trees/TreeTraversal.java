package Trees;

import java.util.LinkedList;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */
public class TreeTraversal {
    public static void main(String[] args) {
        Treee tree = new Treee(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        System.out.println("Pre order traversal:");
        tree.printPreOrder();
        System.out.println();
        System.out.println("In order traversal:");
        tree.printInOrder();
        System.out.println();
        System.out.println("Post order traversal:");
        tree.printPostOrder();
        System.out.println();
        System.out.println("Level order traversal:");
        tree.printLevelOrder();
        System.out.println();
    }
}

class Treee {
    Treee left, right;
    int data;

    public Treee(int data) {
        this.data = data;
    }

    public void insert (int value) {
        if (value < data) {
            if (left == null) {
                left = new Treee(value);
            }
            else {
                left.insert(value);
            }
        }
        else {
            if (right == null) {
                right = new Treee(value);
            }
            else {
                right.insert(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printPreOrder() {
        System.out.print(data + " ");
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.print(data + " ");
    }

    /**
    * O(n) time algorithm.
    * Uses O(n) space to store nodes in a queue to aid in traversal.
    */
    public void printLevelOrder() {
        LinkedList<Treee> queue = new LinkedList<>();
        queue.add(this);
        while (queue.size() > 0) {
            Treee head = queue.remove();
            System.out.print(head.data + " ");
            // Add children of recently-printed node to queue, if they exist.
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }
}
