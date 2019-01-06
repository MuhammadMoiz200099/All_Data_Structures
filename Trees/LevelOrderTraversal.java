package Trees;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */

class NodeO
{
    int data;
    NodeO left, right;
    public NodeO(int item)
    {
        data = item;
        left = right = null;
    }
}
 
public class LevelOrderTraversal
{
    NodeO root;
 
    public LevelOrderTraversal()
    {
        root = null;
    }
 
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
 
    int height(NodeO root)
    {
        if (root == null)
           return 0;
        else
        {
            return Math.max(height(root.left),height(root.right)) + 1;
        }
    }
 
    void printGivenLevel (NodeO root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
     
    public static void main(String args[])
    {
       LevelOrderTraversal tree = new LevelOrderTraversal();
       tree.root= new NodeO(1);
       tree.root.left= new NodeO(2);
       tree.root.right= new NodeO(3);
       tree.root.left.left= new NodeO(4);
       tree.root.left.right= new NodeO(5);
        
       System.out.println("Level order traversal of binary tree is ");
       tree.printLevelOrder();
    }
}
