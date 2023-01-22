public class Sorting
{
    public static <T extends Comparable<T>>

    //This is the shellSort method
    void shellSort(T[] data)
    {
        int compareCounter = 0;
        int swapCounter = 0;
        //setting middle value
        int gap = data.length / 2;
        int swapBase;

        //until the gap reach 0 it executes
        while(gap > 0)
        {
            for(int i = gap; i < data.length; i++)
            {
                swapBase = swapCounter;
                int j = i;
                //swap only if j is bigger than or equal to gap
                //and data[j] is smaller than data[j-gap] 
                while(j >= gap && data[j].compareTo(data[j-gap]) < 0)
                {
                    swap(data,j,j-gap);
                    j--;
                    //counting the number of swapping
                    swapCounter++;
                    //System.out.println("swaped");
                    //arrayPrinter(data);
                    //hiding this because it outputs too much.
                    compareCounter++;
                }
                //adding 1 to compareCounter only when swapBase == swapCounter
                //even if swap doesn't occur it still compare. This increment the number
                if(swapBase == swapCounter)
                {
                compareCounter++;
                }
            }

            //Dividing gap half and making new middle value 
            gap = gap/2;
        }

        //outputs the number of the comparison and swapping
        tally(compareCounter,swapCounter);
        
    }

    //This is the bubble sort method
    public static <T extends Comparable<T>>
    void bubbleSort(T[] data)
    {
        int compareCounter = 0;
        int swapCounter = 0;
        int position, scan;

            for (position = data.length - 1; position >= 0; position--)
            {
                for (scan = 0; scan <= position - 1; scan++)
                {
                    //comparing the data[scan] and next value
                    if (data[scan].compareTo(data[scan+1]) > 0)
                    {  
                        swap(data, scan, scan + 1);
                        swapCounter++;
                        //System.out.println("swaped");
                        //arrayPrinter(data);
                        //hiding this because it outputs too much.
                    }
                    compareCounter++;
                }
            }
        tally(compareCounter,swapCounter);
       
    }

    //This is the efficient bubble sort method
    public static <T extends Comparable<T>>
    void bubbleSort2(T[] data)
    {
        int compareCounter = 0;
        int swapCounter = 0;
        int position = data.length-1;
        int scan;
        boolean swapflag = false;

        //only runs when swapflag is false
        while(!swapflag)
        {
                swapflag = true;
                for (scan = 0; scan <= position - 1; scan++)
                {
                    //comparing the data[scan] and next value
                    if (data[scan].compareTo(data[scan+1]) > 0)
                    {
                        //setting swapflag false, so that while loop doesn't stop
                        swapflag=false;    
                        swap(data, scan, scan + 1);
                        swapCounter++;
                        //System.out.println("swaped");
                        //arrayPrinter(data);
                        //hiding this because it outputs too much.
                    }
                    compareCounter++;
                }
                position--;
            }
        
        tally(compareCounter,swapCounter);
       
    }

    //this method swaps values
    private static <T extends Comparable<T>>
    void swap(T[] data, int index1, int index2)
    {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    //prints compareCounter and swapCounter
    private static void tally(int compareCounter, int swapCounter)
    {
        System.out.println("The number of comparison is " + compareCounter + ". The number of swapping is " + swapCounter + ".");
    }

    //prints array
    private static <T extends Comparable<T>> 
    void arrayPrinter(T[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}