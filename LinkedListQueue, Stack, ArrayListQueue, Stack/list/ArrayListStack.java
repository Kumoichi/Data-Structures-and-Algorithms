package list;

import java.util.ArrayList;

public class ArrayListStack<T> implements StackADT<T>{
    
    ArrayList<T> list;
    public ArrayListStack()
    {
        list = new ArrayList<>();
    }

    @Override
    public void push(T element) {
        //adding the element on the top of the stack
        list.add(element);
    }

    //it is just getting the top value here
    @Override
    public T peek() throws EmptyCollectionException{
        if(isEmpty())
            throw new EmptyCollectionException("ArrayList");
        return list.get(0);
    }

    //removing last added value
    @Override
    public T pop() throws EmptyCollectionException {
        if(isEmpty())
            throw new EmptyCollectionException("ArrayList");
        return list.remove(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return list.size();
    }

    //returns the contents of this stack
    public String toString()
    {
        String result = "";
        if(list.size() == 0)
        {
            return "it is empty";
        }
        for(int i = 0; i < list.size(); i++)
        {
            result += list.get(i) + " ";
        }
        return result;
    }
}
