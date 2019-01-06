package Queues;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */
class PriorityQueue {
	private int maxSize;
	private int[] queueArray;
	private int nItems;

    public PriorityQueue(int size){
        maxSize = size;
        queueArray = new int[size];
        nItems = 0;
    }

    public void insert(int value){
        if(nItems == 0){
            queueArray[0] = value;
        }
        else{
            int j = nItems;
            while(j > 0 && queueArray[j-1] > value){
                queueArray[j] = queueArray[j-1]; 
                j--;
            }
            queueArray[j] = value; 
        }
        nItems++;
    }

    public int remove(){
	return queueArray[--nItems];
    }
        
    public int peek(){
	return queueArray[nItems-1];
    }

    public boolean isEmpty(){
	return(nItems == 0);
    }

    public boolean isFull(){
        return(nItems == maxSize);
    }

    public int getSize(){
        return nItems;
    }
    
}

public class PriorityQueues{

	public static void main(String args[]){
		PriorityQueue myQueue = new PriorityQueue(4);
		myQueue.insert(10);
		myQueue.insert(2);
		myQueue.insert(5);
		myQueue.insert(3);
                
                for(int i = 3; i>=0; i--) {
                    System.out.print(myQueue.remove() + " "); 
                }
	}
}