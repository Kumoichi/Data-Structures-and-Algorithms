//**********************************************************************/
//LinkedListQueueTester

//Kenichi Shihota T00639979
//COMP 2231 Assignment 3
//This assignment checks the difference of ArrayListStack, ArrayListQueue, LinkedListStack, LinkedListQueue
//**********************************************************************/


import list.*;

public class LinkedListQueueTester<T> {
    public static void main(String[] args)
    {
        LinkedListQueue<String> list = new LinkedListQueue<String>();

        list.enqueue("one");
        list.enqueue("two");
        list.enqueue("three");
        list.enqueue("four");

        displayList(list);

    }

    //this method implements toString(), size(), isEmpty(), first(), dequeue(), toString()
    public static void displayList(LinkedListQueue<String> list)
    {
        System.out.println("----------------LinkedListQueueTester-------------------------");
        System.out.println("The contents of the list");
        System.out.println(list.toString() + "\n");

        System.out.println("The size of the list");
        System.out.println(list.size()+ "\n");

        System.out.println("If list is empty return true, if not return false");
        System.out.println(list.isEmpty()+ "\n");

        System.out.println("First element of the list");
        System.out.println(list.first()+ "\n");

        System.out.println("removing the first added element, and that element is");
        System.out.println(list.dequeue()+ "\n");

        System.out.println("The contents of the list");
        System.out.println(list.toString()+ "\n");
    }
}
