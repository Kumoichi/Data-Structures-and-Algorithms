package list;

import java.util.LinkedList;

public class LinkedListStack<T> implements StackADT<T>{

    LinkedList<T> list;

    public LinkedListStack()
    {
        list = new LinkedList<>();
    }
    @Override
    //adding the element on the top of the stack
    public void push(T element) {
        list.add(element);
    }

    @Override
    //it is just getting the top value here
    public T peek() throws EmptyCollectionException{
        if(isEmpty())
            throw new EmptyCollectionException("LinkedList");
        return list.peek();
    }

    @Override
    public T pop() throws EmptyCollectionException{
        if(isEmpty())
            throw new EmptyCollectionException("LinkedList");
        //removing last added value
        return list.remove(size()-1);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }

    //returns the contents of the stack
    public String toString()
    {
        String result = "";
        if(list.isEmpty())
            return "it is empty";
        for(int i = 0; i < list.size(); i++)
        {
            result += list.get(i) + " ";
        }
        return result;
    }
}
