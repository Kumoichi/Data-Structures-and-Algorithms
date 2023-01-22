//**********************************************************************/
//ArrayStackDriver.java

//Kenichi Shihota
//This program push 5 elemnts in stack, tests isEmpty(), size(), peek(), pop(), and toString()
//**********************************************************************/

package jsjf;

public class ArrayStackDriver {

    public static void main(String[] args)
    {
        //pushing 5 elements in stack
        ArrayStack<String> stack = new ArrayStack<String>(5);
        stack.push("bread");
        stack.push("creals");
        stack.push("pasta");
        stack.push("noodles");
        stack.push("salad");

        //testing the method that I modified
        System.out.println("return true if it's empty, and return false in other case \n" + stack.isEmpty() + "\n");
        System.out.println("This is the size of the stack \n" + stack.size()+ "\n");
        System.out.println("This is the value of the top \n" + stack.peek()+ "\n");
        System.out.println("This is the popped value \n" +stack.pop() + "\n");
        System.out.println("This is what currently in the stack \n" + stack.toString());
    }
}
