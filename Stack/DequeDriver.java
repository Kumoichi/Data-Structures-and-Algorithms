//**********************************************************************/
//DequeDriver.java

//Kenichi Shihota
//This program tests putting elements from front and rear, and removes elements from front and rear.
//**********************************************************************/
package jsjf;

public class DequeDriver {
    public static void main(String[] args) {
        Deque<String> que = new Deque<String>();
        //putting element in the queue, from front and rear
        que.enqueueFront("water");
        display(que);
        que.enqueueRear("tea");
        display(que);
        que.enqueueFront("coffee");
        display(que);
        que.enqueueRear("juice");
        display(que);
        que.enqueueFront("coke");
        display(que);
        //dequeue element from front and rear
        que.dequeueFront();
        display(que);
        que.dequeueRear();
        display(que);

    }

    public static void display(Deque<String> que)
    {
        System.out.println("-----------------------");
        System.out.print("The contents of que \n" + que.toString() +"\n");
        System.out.println("The size of que \n" + que.size()+"\n");
        System.out.println("The front value \n" + que.front()+"\n");
        System.out.println("The last value \n" + que.last()+"\n");
        System.out.println();

    }

}
