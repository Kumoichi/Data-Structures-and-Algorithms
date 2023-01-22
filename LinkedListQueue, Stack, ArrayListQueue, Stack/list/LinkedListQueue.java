package list;

import java.util.LinkedList;

//at the end of the interface I need to put <T>
public class LinkedListQueue<T> implements QueueADT<T>{

    LinkedList<T> list;

    public LinkedListQueue()
    {
        list = new LinkedList<>();
    }


    @Override
    //when you add element that element always go to the front
    public void enqueue(T element) {
        list.addFirst(element);
    }


    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty())
            throw new EmptyCollectionException("LinkedList");
        //last element will be deleted
        return list.removeLast();
    }


    @Override
    public T first() throws EmptyCollectionException{
        if(isEmpty())
            throw new EmptyCollectionException("LinkedList");
        //getting the first element
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size()
    {
        return list.size();
    }

    @Override
    //returns the contents of the queue
    public String toString()
    {
        String result = "";
        if(list.isEmpty())
            return "it is empty";
        for(int i = 0; i < list.size(); i++)
        {
                result+= list.get(i) + " ";
        }
        return result;
    }

}
