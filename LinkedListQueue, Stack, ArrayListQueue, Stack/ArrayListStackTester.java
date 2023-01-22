import list.*;
public class ArrayListStackTester<T> {
    public static void main(String[] args)
    {
        ArrayListStack<String> list = new ArrayListStack<>();

        list.push("one");
        list.push("two");
        list.push("three");
        list.push("four");

        displayList(list);
    }

    //this method implements toString(), size(), isEmpty(), peek(), pop(), toString();
    public static void displayList(ArrayListStack<String> list)
    {
        System.out.println("----------------ArrayListStackTester-------------------------");
        System.out.println("The contents of the list");
        System.out.println(list.toString() + "\n");

        System.out.println("The size of the list");
        System.out.println(list.size()+ "\n");

        System.out.println("If list is empty return true, if not return false");
        System.out.println(list.isEmpty()+ "\n");

        System.out.println("First element of the list");
        System.out.println(list.peek()+ "\n");

        System.out.println("removing the last added element, and that element is");
        System.out.println(list.pop()+ "\n");

        System.out.println("The contents of the list");
        System.out.println(list.toString()+ "\n");
    }
}