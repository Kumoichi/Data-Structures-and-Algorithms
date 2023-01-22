package list;
import java.util.ArrayList;

public class ArrayListQueue<T> implements QueueADT<T> {

    ArrayList<T> list;

    public ArrayListQueue()
    {
        list = new ArrayList<>();
    }

    @Override
    public void enqueue(T element) {
        //use add method to add element;
        list.add(element);
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty())
            throw new EmptyCollectionException("LinkedList");

        //set it to 0, so that it removes from the front.
        return list.remove(0);
    }

    //return the first element of the queue
    @Override
    public T first() throws EmptyCollectionException{
        if(isEmpty())
            throw new EmptyCollectionException("LinkedList");
        return list.get(0);
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

    //returns the contents in the queue
    public String toString()
    {
        String result = "";
        if(list.isEmpty())
            return "It is empty";
        for(int i = 0; i < list.size(); i++)
        {
            result += list.get(i) + " ";
        }
        return result;
    }

}
