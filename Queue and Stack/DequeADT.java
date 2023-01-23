package jsjf;

public interface DequeADT<T> {
    public void enqueueFront(T element);

    public void enqueueRear(T element);

    public void dequeueFront();

    public void dequeueRear();

    public T front();

    public T last();

    public boolean isEmpty();

    public int size();

    public String toString();
}

