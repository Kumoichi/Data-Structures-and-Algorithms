//**********************************************************************/
//DropOutStackDriver.java

//Kenichi Shihota 
//This program has a limit in stack, and when more than 5 elements are pushed,
// it removes the bottom eoement in stack
//**********************************************************************/
package jsjf;

public class DropOutStackDriver {
    public static void main(String[] args)
    {
        DropOutStack<String> stack = new DropOutStack<String>();

        //pushing 5 elements
        stack.push("Kenichi");
        stack.push("Tom");
        stack.push("Jacob");
        stack.push("Mike");
        stack.push("Amanda");
        displayStack(stack);

        //pushing 2 more elements
        stack.push("Justin");
        stack.push("Josh");
        displayStack(stack);

    }

    private static void displayStack(DropOutStack<String> stack)
    {
        System.out.println("-----------------------------");
        System.out.println("The contents of stack \n" + stack.toString()+ "\n");
        System.out.println("The size of stack \n" + stack.size()+ "\n");
        System.out.println("The top of stack \n" + stack.peek()+ "\n");
    }
}
