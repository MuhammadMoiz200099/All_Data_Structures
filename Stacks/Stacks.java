package Stacks;

import java.util.ArrayList;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */

class Stack{
	
	private int maxSize;
	private int[] stackArray;	
	private int top;

	public Stack(int size){
		maxSize = size;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int value){
		if(!isFull()){ 
			top++;
			stackArray[top] = value;
		}else{
			resize(maxSize*2);
                        push(value);
		}
	}

	public int pop(){
		if(!isEmpty()){ 
			return stackArray[top--];
		}

		if(top < maxSize/4){
			resize(maxSize/2);
			return pop();
		}
		else{
			System.out.println("The stack is already empty");
			return -1;
		}
	}

	public int peek(){
		if(!isEmpty()){ 
			return stackArray[top];
		}else{
			System.out.println("The stack is empty, cant peek");
			return -1;
		}
	}

	private void resize(int newSize){
                int[] transferArray = new int[newSize];

                for(int i = 0; i < stackArray.length; i++){
			transferArray[i] = stackArray[i];
			stackArray = transferArray;
		}
		maxSize = newSize;
	}

	public boolean isEmpty(){
		return(top == -1);
	}

	public boolean isFull(){
		return(top+1 == maxSize);
	}

	public void makeEmpty(){ 
		top = -1;			
	}
}

class Stack2{
		
    ArrayList<Integer> stackList;

	Stack2(){
            stackList=new ArrayList<>();
	}

	void push(int value){
            stackList.add(value);
	}

	int pop(){
            if(!isEmpty()){ 

		int popValue=stackList.get(stackList.size()-1);
		stackList.remove(stackList.size()-1);  //removes the poped element from the list
			return popValue;
		}
		else{
                    System.out.print("The stack is already empty  ");
			return -1;
		}

        }	

	boolean isEmpty(){
            if(stackList.isEmpty())
                return true;
            else return false;
	}

	int peek(){
            return stackList.get(stackList.size()-1);
	}
}


public class Stacks{

	public static void main(String args[]){
			Stack myStack = new Stack(4); 
 		myStack.push(5);
 		myStack.push(8);
  		myStack.push(2);
  		myStack.push(9);

		System.out.println("*********************Stack Array Implementation*********************");
  		System.out.println(myStack.isEmpty()); 
  		System.out.println(myStack.isFull()); 
  		System.out.println(myStack.peek()); 
  		System.out.println(myStack.pop()); 
  		System.out.println(myStack.peek()); 

		Stack2 myStack2 = new Stack2(); 
  		
 		myStack2.push(5);
		myStack2.push(8);
 		myStack2.push(2);
 		myStack2.push(9);

 		System.out.println("*********************Stack List Implementation*********************");
 		System.out.println(myStack2.isEmpty()); 
 		System.out.println(myStack2.peek()); 
 		System.out.println(myStack2.pop()); 
 		System.out.println(myStack2.peek()); 
 		System.out.println(myStack2.pop()); 
	}
}
