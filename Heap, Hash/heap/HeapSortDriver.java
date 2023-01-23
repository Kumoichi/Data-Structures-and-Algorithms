//**********************************************************************/
//HeapSortDriver
//Kenichi Shihota
//testing heap sort with 3 unsorted array
//max heap the number and start sorting
//**********************************************************************/

package heap;

public class HeapSortDriver {

    public static void main(String[] args) {
        HeapSort<Integer> heap = new HeapSort<>();

        Integer[] array1 = {2, 8, 3, 9, 1};
        Integer[] array2 = {10,20,44,6543,23,345,6,12,0};
        Integer[] array3 = {90, -1,-23,-100,1000,2,4,234,56,34,7,68};
        display(array1);
        display(array2);
        display(array3);
    }

    public static void display(Integer[] data)
    {
        HeapSort<Integer> temp = new HeapSort<>();

        System.out.println("-----------------------------------");
        System.out.println("unsorted array");
        System.out.println(temp.toString(data));

        System.out.println("sorted array");
        System.out.println(temp.toString(temp.heapSort(data)));

    }

}