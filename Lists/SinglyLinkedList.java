package Lists;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */
public class SinglyLinkedList{
	private Node head;

	public SinglyLinkedList(){
		head = null;
	}

	public void insertHead(int x){
		Node newNode = new Node(x); 
		newNode.next = head; 		
		head = newNode; 			
	}


    Node InsertNth(Node head, int data, int position) {
        
        Node newNode = new Node();
        newNode.value = data;
        
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;

        while (--position > 0) {
            current = current.next;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }
    
	public Node deleteHead(){
		Node temp = head;
		head = head.next; 
		return temp;
	}

	public boolean isEmpty(){
		return(head == null);
	}

	public void display(){
		Node current = head;
		while(current!=null){
			System.out.print(current.getValue()+" ");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		SinglyLinkedList myList = new SinglyLinkedList();

		System.out.println(myList.isEmpty()); 

		myList.insertHead(5);
		myList.insertHead(7);
		myList.insertHead(10);

		myList.display(); 

		myList.deleteHead();

		myList.display(); 
	}
}

class Node{
	
	public int value;
	public Node next;

        public Node() {}

	public Node(int valuein){
		value = valuein;
        }

	public int getValue(){
		return value;
	}

}
