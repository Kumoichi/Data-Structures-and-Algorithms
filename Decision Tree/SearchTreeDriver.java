/**
 * SearchTreeDriver.java
 *
 * Kenichi Shihota 
 *
 * Added element, removed element and showing various cases.
 * And balancing the degenerate tree.
 * And again add some elements and rebalance that tree
 */
import jsjf.*;

public class SearchTreeDriver {
    public static void main(String[] args) {
        LinkedBinarySearchTree<Integer> t = new LinkedBinarySearchTree<>();

        //adding elements
        t.addElement(50);
        t.addElement(20);
        t.addElement(70);
        t.addElement(10);
        t.addElement(40);
        t.addElement(35);
        t.addElement(30);
        t.addElement(60);
        t.addElement(60);
        t.addElement(59);
        t.addElement(58);

        //when you find smallest number
        t.findMin();

        //when you find biggest number
        t.findMax();

        // when you remove leaf
        t.removeElement(10);

        // when you remove child which has one child
        //t.removeElement(59);

        // when you remove child which has two children(and that inorder successor has no children)
        // t.removeElement(70);

        // when you remove child which has two children(and that inorder successor has one child on the right)
        //t.removeElement(20);

        // when you can't find an element that you want to remove
        //t.removeElement(3);

        // when you remove root element
        //t.removeElement(50);

        //when you want to remove all the same number
        //t.removeElement(60);

        //when you remove smallest number
        //t.removeMin();

        //when you remove biggest number
        //t.removeMax();

        //when you remove the all target numbers;
        //t.removeAllOccurrences(60);

        //when you check whether the target number is in the list.
        //t.contains(50);

        System.out.println("The contents of the tree with inorder traversal");
        System.out.println(t.toString());
        System.out.println();
        System.out.println("Before balancing the height " + t.getHeight());
        t.balance();
        System.out.println("After balancing the height " + t.getHeight());

        t.addElement(10);
        t.addElement(9);
        System.out.println();
        System.out.println("The contents of the tree with inorder traversal");
        System.out.println(t.toString());

        System.out.println("Before balancing the height " + t.getHeight());

        t.balance();
        System.out.println("After balancing the height " + t.getHeight());
    }
}

