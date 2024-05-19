public class Stack {
    private Integer[] stack;   
    private int topIndex;
    private int depth;



    public Stack(int depthIn) {
        depth = depthIn;
        stack = new Integer[depth];
        topIndex = 0;
    }


    public int top() {
        //get last non null
        return stack[topIndex-1];

    }

    public int pop() {
        //remove from list last element and return it
        int value = stack[topIndex-1];
        stack[topIndex-1] = null;
        topIndex--;
        return value;
        
    }

    public void push(int value) {
        //push the value to the top of the list 
        try {
            stack[topIndex] = value;
            topIndex++;
        } catch (Exception e) {
            System.out.println("Overflow error");
            System.out.println(e);
        }

    }

    public int size() {
        //retruns the size of the stack
        return topIndex;
    }

    public boolean isEmpty() {
        //returns true if all values are nulll
        if (topIndex == 0) {return true;};
        return false;
    }

    public void empty() {
        //empties array 
        for (int i = 0; i < stack.length; i++) {
            stack[i] = null;
        }

    }


}


public static void main(String[] args) {
    Stack st = new Stack(20);

    System.out.println("Adding 5 to the stack.");
    st.push(5);
    System.out.println("The top element of the stack is " + st.top());
    st.push(0);
    st.push(4);
    System.out.println("The top element of the stack is " + st.top());
    st.pop();
    System.out.println("The top element is now " + st.top());
    System.out.println("There are " + st.size() + " elements in the stack.");
    if (!st.isEmpty()) {
        st.empty();
    }
    System.out.println("There are now " + st.size() + " elements in the stack.");


}