package Trees;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */
import java.util.LinkedList;

public class FindHeightOfTree {

    public static void main(String[] args) {
        NoodoTree tree = new NoodoTree(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(1);
        tree.insert(-1);
        tree.insert(29);
        tree.insert(93);
        tree.insert(6);
        tree.insert(0);
        tree.insert(-5);
        tree.insert(-6);
        tree.insert(-8);
        tree.insert(-1);

        tree.printLevelOrder();
        System.out.println();

        System.out.println("Height of the tree is: " + tree.findHeight());
    }
}

class NoodoTree {
    NoodoTree left, right;
    int data;

    public NoodoTree(int data) {
        this.data = data;
    }

    public void insert (int value) {
        if (value < data) {
            if (left == null) {
                left = new NoodoTree(value);
            }
            else {
                left.insert(value);
            }
        }
        else {
            if (right == null) {
                right = new NoodoTree(value);
            }
            else {
                right.insert(value);
            }
        }
    }

    public void printLevelOrder() {
        LinkedList<NoodoTree> queue = new LinkedList<>();
        queue.add(this);
        while(!queue.isEmpty()) {
            NoodoTree n = queue.poll();
            System.out.print(n.data + " ");
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    public int findHeight() {
        return findHeight(this);
    }

    private int findHeight(NoodoTree root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        else if (root.left != null && root.right != null) {
            return 1 + Math.max(findHeight(root.left), findHeight(root.right));
        }
        else if (root.left == null && root.right != null) {
            return 1 + findHeight(root.right);
        }
        else {
            return 1 + findHeight(root.left);
        }
    }
}


