//**********************************************************************/
//SortingDriver.java

//Kenichi Shihota
//This program shows the shell sort, bubble sort, and bubble sort in a efficient way. 
//And checking how many times they swapped and compared the values.
//And calculating the each execution time to compare the speed.
//**********************************************************************/
import java.util.Random;
import java.util.Arrays;

public class SortingDriver
{
    static final int RANDOM_RANGE = 50;
    
    public static void main(String[] args)
    {
        //first question
        //making 3 arrays
        Integer[] array = {9,6,8,12,3,1,7};
        Integer[] tenRandom = random(10);
        Integer[] twentyRandom = random(20);

        printArray("shellSort", array, "default numbers");
        printArray("bubbleSort", tenRandom, "ten random numbers");
        printArray("bubbleSort2", twentyRandom, "twenty random numbers");

        //second question
        //making 2 random array, and 2 sorted array
        Integer[] bubbleRand = random(10);
        Integer[] bubble2Rand = Arrays.copyOf(bubbleRand,bubbleRand.length);
        Integer[] sorted = random(10);
        Arrays.sort(sorted);
        
        printArray("bubbleSort", bubbleRand, "ten random numbers with bubbleSort");
        printArray("bubbleSort2", bubble2Rand, "ten random numbers with bubbleSort2");
        printArray("bubbleSort", sorted, "sorted ten numbers with bubbleSort");
        printArray("bubbleSort2", sorted, "sorted ten nubmers with bubbleSort2");


        //third question
        System.out.println("----------------------------------------------------");
        System.out.println("Calculating the execution time of random numbers here.\n");

        //testing 10, 100, 1000 random number
        calcuRandomTime(10, "ten random");
        calcuRandomTime(100, "hundred random");
        calcuRandomTime(1000, "thousand random");

        System.out.println("----------------------------------------------------");
        System.out.println("Calculating the execution time of sorted numbers here.\n");

        //testin 10, 100, 1000 sorted number
        calcuSortedTime(10, "ten sorted");
        calcuSortedTime(100, "hundred sorted");
        calcuSortedTime(1000, "thousand sorted");
    }


    private static void printArray(String sortWay, Integer[] array, String arrayName)
    {
        System.out.println("\n--------------------------");
        System.out.println(arrayName);
        System.out.println("original numbers");
        arrayPrinter(array);
        System.out.println();

        //depends on the sortWay, it execute different sorting type.
        if(sortWay == "shellSort")
        {
            Sorting.shellSort(array);
        }

        else if(sortWay == "bubbleSort")
        {
            Sorting.bubbleSort(array);
        }

        else if(sortWay == "bubbleSort2")
        {
            Sorting.bubbleSort2(array);
        }
        //If it is not shellSort or bubbleSort or bubbleSort2, then it outputs this.
        else 
        {
            System.out.println("You need to write shellSort or bubbleSort or bubbleSort2"); 
        }

        //This prints the sorted array.
        System.out.println("After Sorted");
        arrayPrinter(array);
        
    }

    //making random numbers here
    private static Integer[] random(int num)
    {
        Integer[] number = new Integer[num];
        Random rand = new Random();
        for(int i = 0; i < num; i++)
        {
            number[i] = rand.nextInt(RANDOM_RANGE);

        }
        return number;
    }
    
    //printing the array
    private static void arrayPrinter(Integer[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    //calculating execution time for random array.
    private static void calcuRandomTime(int num, String size)
    {
        //if number is bigger than 1000, it prints 0.
        if(num > 1000)
        {
            num = 0;
            System.out.println("You can't put the number bigger than 1000");
        }
        Integer[] randomNum = random(num);

        //by using Arrays.copyOf, it can copy the array. 
        //even if randomNum changes, the numbers in bubbleNum and bubble2Num array don't change.
        Integer[] bubbleNum= Arrays.copyOf(randomNum,randomNum.length);
        Integer[] bubble2Num = Arrays.copyOf(randomNum,randomNum.length);
        long startTime, endTime;
        long shellExTime, bubbleExTime, bubble2ExTime; 

        //comparing the execution time of shellSort, bubbleSort, and bubbleSort2
        System.out.println("This shows the " + size + " numbers");
        startTime = System.nanoTime();
        Sorting.shellSort(randomNum);
        endTime = System.nanoTime();
        shellExTime = endTime - startTime;

        startTime = System.nanoTime();
        Sorting.bubbleSort(bubbleNum);
        endTime= System.nanoTime();
        bubbleExTime = endTime - startTime;
    
        startTime = System.nanoTime();
        Sorting.bubbleSort2(bubble2Num);
        endTime = System.nanoTime();
        bubble2ExTime = endTime - startTime;
        
        //this organize method create the clear outputs
        organize(shellExTime, bubbleExTime, bubble2ExTime);
    }

    //calculating execution time for sorted array.
    private static void calcuSortedTime(int num, String size)
    {
        //if number is bigger than 1000, it prints 0.
        if(num > 1000)
        {
            num = 0;
            System.out.println("You can't put the number bigger than 1000");
        }

        long startTime, endTime;
        long shellExeTime, bubbleExeTime, bubble2ExeTime; 
        Integer[] array = random(num);
        //sorting here, because you want to calculate the time for the sorted array.
        Arrays.sort(array);

         //comparing the execution time of shellSort, bubbleSort, and bubbleSort2
        System.out.println("This shows the " + size + " numbers");
        startTime = System.nanoTime();
        Sorting.shellSort(array);
        endTime = System.nanoTime();
        shellExeTime = endTime - startTime;

        startTime = System.nanoTime();
        Sorting.bubbleSort(array);
        endTime= System.nanoTime();
        bubbleExeTime = endTime - startTime;
    
        startTime = System.nanoTime();
        Sorting.bubbleSort2(array);
        endTime = System.nanoTime();
        bubble2ExeTime = endTime - startTime;
        
        //this organize method create the clear outputs
        organize(shellExeTime, bubbleExeTime, bubble2ExeTime);
    }

    //adjusting the ouputs with printf
    private static void organize(long shellsort, long bubblesort, long bubblesort2)
    {
        System.out.printf("\n%-15s %-15s %s\n","Shell Sort", "BubbleSort", "BubbleSort2");
        System.out.printf("%-15d %-15d %d\n\n",shellsort,bubblesort,bubblesort2);
    }
}
