import java.util.*;
class min_stack_exp {
    Stack<Integer> mainStack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    public void push(int x)
    {
        mainStack.push(x);
        if(minStack.isEmpty() || x<=minStack.peek()) minStack.push(x);
    }
    public void pop(){
        if(!mainStack.isEmpty()){
            if(!minStack.isEmpty() && minStack.peek()==mainStack.peek()) minStack.pop();
            mainStack.pop();
        }
    }
    public int top(){
        return (!mainStack.isEmpty())? mainStack.peek(): -1;
    }
    public int getMin(){
        return (!minStack.isEmpty())? minStack.peek(): -1;
    }
    public static void main(String args[])
    {
        min_stack_exp stack=new min_stack_exp();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter operations as space-separated values:");
        String[] operations=sc.nextLine().split(" ");
        System.out.println("Enter corresponding values as space-separated values: (null for no value)");
        String[] values=sc.nextLine().split(" ");

        for(int i=0;i<operations.length;i++)
        {
            String op=operations[i];
            switch(op)
            {
                case "push":
                    stack.push(Integer.parseInt(values[i]));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "getMin":
                    System.out.println(stack.getMin());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
            }
        }
    }
}