package jsjf;

public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {


    public ArrayUnorderedList() {
        super();
    }


    public ArrayUnorderedList(int initialCapacity) {
        super(initialCapacity);
    }


    /**
     * Adds the specified element to the front of this list.
     *
     * @param element the element to be added to the front of this list
     */
    public void addToFront(T element)
    {
        if (size() == list.length)
            expandCapacity();

        for (int scan=rear; scan > 0; scan--)
            list[scan] = list[scan-1];

        list[0] = element;
        rear++;
    }

    /**
     * Adds the specified element to the rear of this list.
     *
     * @param element the element to be added to the rear of this list
     */
    public void addToRear(T element)
    {
        if (size() == list.length)
            expandCapacity();

        list[rear] = element;
        rear++;
    }

    /**
     * Adds the specified element after the specified target.
     *
     * @param element the element to be added after the target
     * @param target the target is the item that the element will be added
     * after
     */
    public void addAfter(T element, T target) {
        if (size() == list.length)
            expandCapacity();
        int scan = 0;
        while (scan < rear && !target.equals(list[scan]))
            scan++;
        if (scan == rear)
            throw new ElementNotFoundException("UnorderedList");
        scan++;
        for (int shift = rear; shift > scan; shift--)
            list[shift] = list[shift - 1];
        list[scan] = element;
        rear++;
        modCount++;
    }
}
