package Trees;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */

class Nodo{
	public int data;
	public Nodo left;
	public Nodo right;
	public Nodo parent;
        
	public Nodo(int value){
		data = value;
		left = null;
		right = null;
		parent = null;
	}
}


class Tree{
    private Nodo root;
    
    public Tree(){
	root = null;
    }

    public Nodo find(int key) {
	Nodo current = root;
            while (current != null) {
		if(key < current.data) {
                    current = current.left;
		} else if(key > current.data) {
			current = current.right;
                } else {
                    return current;
		}
            }
	return null;
    }

    public void put(int value){
        Nodo newNode = new Nodo(value);
            if(root == null)
                root = newNode;
            else{
                Nodo parent = find(value);
                if(value < parent.data){
                    parent.left = newNode;
                    parent.left.parent = parent;
                    return;
		}
                else{
                    parent.right = newNode;
                    parent.right.parent = parent;
                    return;
		}
            }
    }

    public boolean remove(int value){
        Nodo temp = find(value);
            if(temp.data != value)
                return false;
            if(temp.right == null && temp.left == null){
                if(temp == root)
                    root = null;
                else if(temp.parent.data < temp.data)
                    temp.parent.right = null;
                else
                    temp.parent.left = null;
                return true;
            }
            else if(temp.left != null && temp.right != null){
                Nodo successor = findSuccessor(temp);
                successor.left = temp.left;
                successor.left.parent = successor;
                if(successor.right != null && successor.parent != temp){
                    successor.right.parent = successor.parent;
                    successor.parent.left = successor.right;
                    successor.right = temp.right;
                    successor.right.parent = successor;
                }
                if(temp == root){
                    successor.parent = null;
                    root = successor;
                    return true;
                }
                else{
                    successor.parent = temp.parent;
                    if(temp.parent.data < temp.data)
                        temp.parent.right = successor;
                    else
                        temp.parent.left = successor;
                    return true;
                }
            }
            else{
                if(temp.right != null){
                    if(temp == root){
                        root = temp.right; return true;
                    }
                    temp.right.parent = temp.parent;
                    if(temp.data < temp.parent.data)
                        temp.parent.left = temp.right;
                    else
                        temp.parent.right = temp.right;
                    return true;
                }
                else{
                    if(temp == root){
                        root = temp.left; return true;
                    }         
                    temp.left.parent = temp.parent;
                    if(temp.data < temp.parent.data)
                        temp.parent.left = temp.left;
                    else
                        temp.parent.right = temp.left;
                    return true;
                }
            }
    }

    public Nodo findSuccessor(Nodo n){
	if(n.right == null)
		return n;
            Nodo current = n.right;
            Nodo parent = n.right;
	while(current != null){
            parent = current;
            current = current.left;
	}
	return parent;
    }

    public Nodo getRoot(){
	return root;
    }

    public void inOrder(Nodo localRoot){
	if(localRoot != null){
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
	}
    }

    public void preOrder(Nodo localRoot){
    	if(localRoot != null){
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    public void postOrder(Nodo localRoot){
   	if(localRoot != null){
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
    	}
    }
}
