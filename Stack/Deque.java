package jsjf;

public class Deque<T> implements DequeADT<T>
{
    LinearNode<T> front;
    LinearNode<T> last;
    LinearNode<T> next;
    LinearNode<T> previous;
    private int count;

    public Deque()
    {
        next = null;
        previous = null;
        count = 0;
    }
    //put element from front
    @Override
    public void enqueueFront(T element) {
        LinearNode<T> temp = new LinearNode<T>(element);
        //we want to put an element in front, temp next should direct front, and front previous should direct temp
        if(front == null)
        {
            last = temp;
        }
        if(front != null)
        {
            //setting front previous to temp
            front.setPrevious(temp);
        }
        //setting temp next to front
        temp.setNext(front);
        front = temp;
        count++;
    }

    @Override
    public void enqueueRear(T element) {
        LinearNode<T> temp = new LinearNode<T>(element);
        //we want to put an element in last, temp previous should direct last, and last next should direct temp
        if(last == null) {
            front = temp;
        }

        else if(last != null)
        {
            //setting last next to temp
            last.setNext(temp);
        }
        //setting temp previous to last
        temp.setPrevious(last);
        last = temp;
        count++;
    }

    @Override
    public void dequeueFront() {
        if(isEmpty())
            throw new EmptyCollectionException("queue");
        //temp is the next node of front
        LinearNode<T> temp = front.getNext();
        //by setting temp previous to null it removes front node from the queue
        if(temp.getPrevious() == null)
        {
            front = null;
        }

        if(temp.getPrevious() != null)
        {
            //setting temp previous to null
            temp.setPrevious(null);
        }

        front = temp;
        count--;
    }

    @Override
    public void dequeueRear() {
        if(isEmpty())
            throw new EmptyCollectionException("queue");

        //temp is previous node of last
        LinearNode<T> temp = last.getPrevious();
        //by setting temp next to null it removes last node from the queue
        if(last.getPrevious() == null)
        {
            last = null;
        }
        else if(last.getPrevious() != null)
        {
            //setting temp next to null
            temp.setNext(null);
        }
        last = temp;
        count--;
    }

    @Override
    public T front() {
        if(isEmpty())
            throw new EmptyCollectionException("queue");

        //showing front element
        return front.getElement();
    }

    @Override
    public T last() {
        if(isEmpty())
            throw new EmptyCollectionException("queue");

        //showing last element
        return last.getElement();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    public String toString()
    {
        String result = "";
        LinearNode current = front;

        while (current != null)
        {
            result = result + current.getElement() + " ";
            current = current.getNext();
        }

        return result + "\n";
    }
}
