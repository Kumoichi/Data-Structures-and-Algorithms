package heap;

public class HeapSort<T>
{

    public T[] heapSort(T[] data)
    {
        //get the last value
        int last = data.length - 1;

        //get the last parent number
        int parent = (last - 1)/2;
        int root = 0;

        //maxheap before sorting
        for(int i = parent; i >= 0; i--)
            maxHeap(data, i, last);

        for(int i = 0; i < last; i++)
        {
            int target = last - i;
            //put largest number at the last
            swap(data,root,target);
            //leave the last number of the array which is the largest number
            maxHeap(data,root,target-1);
        }
        return data;
    }

    private void maxHeap(T[] data, int root, int last)
    {
        //getting left of the root
        int left = 2 * root + 1;
        //getting right of the root
        int right = 2 * root + 2;
        int largest = root;

        //deciding which is the largest number
        if(left <= last && (((Comparable)data[left]).compareTo(data[root]) > 0))
        {
            largest = left;
        }

        if(right <= last && (((Comparable)data[right]).compareTo(data[largest]) > 0))
        {
            largest = right;
        }

        //if left or right number is bigger than root swap and repeat the max heap
        if(largest != root)
        {
            swap(data, largest, root);
            maxHeap(data,largest, last);
        }
    }

    private void swap(T[] data,int index1, int index2)
    {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public String toString(T[] data)
    {
        String result = "";
        for(int i = 0; i < data.length; i++)
        {
            result += data[i] + " ";
        }
        return result;
    }

}