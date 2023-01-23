//**********************************************************************/
//LinearProbingDriver
//Kenichi Shihota 
//This program is making 2 hash table to compare
// how can different order of the data makes a difference the place of them
//implementing find and remove method at the last of the first hash table.
//**********************************************************************/

package hash;

public class LinearProbingDriver {
    public static void main(String []args) {
        LinearProbing<Integer,String> first  = new LinearProbing<Integer,String>();

        System.out.println("----------------------------");
        System.out.println("first hash");
        first.add(123, "123747238");
        first.add(283, "283723984");
        first.add(783, "783482932");
        first.add(234, "234852302");
        first.add(789, "789234234");
        first.add(584, "584052819");
        first.add(982,"982784785");

        System.out.println(first.toString());


        //same data but with different order.
        System.out.println();
        System.out.println("----------------------------");
        System.out.println("Second hash with same data but different order");
        LinearProbing<Integer,String> second  = new LinearProbing<Integer,String>();
        second.add(789, "789234234");
        second.add(234, "234852302");
        second.add(982,"982784785");
        second.add(783, "783482932");
        second.add(283, "283723984");
        second.add(584, "584052819");
        second.add(123, "123747238");

        System.out.println(second.toString());

        //finding value based on the key number
        System.out.println("This is the value of this key");
        System.out.println(first.find(123));

        //removing this key and the value from the hashtable.
        first.remove(123);

    }
}