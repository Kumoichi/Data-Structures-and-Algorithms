package jsjf;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


public class LinkedBinarySearchTree<T extends Comparable<T>> extends LinkedBinaryTree<T>
        implements BinarySearchTreeADT<T> {
    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTree() {
        super();
    }

    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will be the root of the new binary
     */
    public LinkedBinarySearchTree(T element) {
        super(element);
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("LinkedBinarySearchTree");
    }

    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its natural order. Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    @Override
    public void addElement(T element) {
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("LinkedBinarySearchTree");
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (isEmpty())
            root = new BinaryTreeNode<T>(element);
        else {
            if (comparableElement.compareTo(root.getElement()) < 0) {
                if (root.getLeft() == null)
                    this.getRootNode().setLeft(new BinaryTreeNode<T>(element));
                else
                    addElement(element, root.getLeft());
            } else {
                if (root.getRight() == null)
                    this.getRootNode().setRight(new BinaryTreeNode<T>(element));
                else
                    addElement(element, root.getRight());
            }
        }
        modCount++;
    }

    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its natural order. Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search tree
     */
    private void addElement(T element, BinaryTreeNode<T> node) {
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (comparableElement.compareTo(node.getElement()) < 0) {
            if (node.getLeft() == null)
                node.setLeft(new BinaryTreeNode<T>(element));
            else
                addElement(element, node.getLeft());
        } else {
            if (node.getRight() == null)
                node.setRight(new BinaryTreeNode<T>(element));
            else
                addElement(element, node.getRight());
        }
    }

    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it. Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @throws ElementNotFoundException if the target element is not found
     */
    @Override
    public T removeElement(T targetElement)
            throws ElementNotFoundException {
        T result = null;
        if (isEmpty())
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        else {
            BinaryTreeNode<T> parent = null;
            if (((Comparable<T>) targetElement).equals(root.element)) {
                result = root.element;
                BinaryTreeNode<T> temp = replacement(root);
                if (temp == null)
                    root = null;
                else {
                    root.element = temp.element;
                    root.setRight(temp.right);
                    root.setLeft(temp.left);
                }
                modCount--;
            } else {
                parent = root;
                if (((Comparable) targetElement).compareTo(root.element) < 0)
                    result = removeElement(targetElement, root.getLeft(), parent);
                else
                    result = removeElement(targetElement, root.getRight(), parent);
            }
        }
        return result;
    }

    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it. Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @param node          the node from which to search
     * @param parent        the parent of the node from which to search
     * @throws ElementNotFoundException if the target element is not found
     */
    private T removeElement(T targetElement, BinaryTreeNode<T> node,
                            BinaryTreeNode<T> parent) throws ElementNotFoundException {
        T result = null;
        if (node == null)
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        else {
            if (((Comparable<T>) targetElement).equals(node.element)) {
                result = node.element;
                BinaryTreeNode<T> temp = replacement(node);
                if (parent.right == node)
                    parent.right = temp;
                else
                    parent.left = temp;
                modCount--;
            } else {
                parent = node;
                if (((Comparable) targetElement).compareTo(node.element) < 0)
                    result = removeElement(targetElement, node.getLeft(), parent);
                else
                    result = removeElement(targetElement, node.getRight(), parent);
            }
        }
        return result;
    }

    /**
     * Returns a reference to a node that will replace the one
     * specified for removal. In the case where the removed node has
     * two children, the inorder successor is used as its replacement.
     *
     * @param node the node to be removed
     * * @return a reference to the replacing node
     * */
    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;
        if ((node.left == null) && (node.right == null))
            result = null;
        else if ((node.left != null) && (node.right == null))
            result = node.left;
        else if ((node.left == null) && (node.right != null))
            result = node.right;
        else {
            BinaryTreeNode<T> current = node.right;
            BinaryTreeNode<T> parent = node;
            while (current.left != null) {
                parent = current;
                current = current.left;
            }
            current.left = node.left;
            if (node.right != current) {
                parent.left = current.right;
                current.right = node.right;
            }
            result = current;
        }
        return result;
    }

    /**
     * Removes elements that match the specified target element from
     * the binary search tree. Throws a ElementNotFoundException if
     * the specified target element is not found in this tree.
     *
     * @param targetElement the element being sought in the binary search tree
     * @throws ElementNotFoundException if the target element is not found
     */
    @Override
    public void removeAllOccurrences (T targetElement)
            throws ElementNotFoundException {
        removeElement(targetElement);
        try {
            while (contains((T) targetElement))
                removeElement(targetElement);
        } catch (Exception ElementNotFoundException) {
        }
    }

    /**
     * Removes the node with the least value from the binary search
     * tree and returns a reference to its element. Throws an
     * EmptyCollectionException if this tree is empty.
     *
     * @return a reference to the node with the least value
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T removeMin() throws EmptyCollectionException {
        T result = null;
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else {
            if (root.left == null) {
                result = root.element;
                root = root.right;
            } else {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current = root.left;
                while (current.left != null) {
                    parent = current;
                    current = current.left;
                }
                result = current.element;
                parent.left = current.right;
            }
            modCount--;
        }
        return result;
    }

    /**
     * Removes the node with the highest value from the binary search
     * tree and returns a reference to its element. Throws an
     * EmptyCollectionException if this tree is empty.
     *
     * @return a reference to the node with the highest value
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T removeMax() throws EmptyCollectionException{
        T result = null;
        if(isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else
        {
            if(root.getRight() == null)
            {
                result = root.element;
            }
            BinaryTreeNode<T> parent = root;
            BinaryTreeNode<T> current = root.right;
            while(current.right != null)
            {
                parent = current;
                current = current.right;
            }
            parent = current.left;
            result = current.element;
        }
        modCount--;
        return result;
    }

    /**
     * find the minimum number
     * @return a minimum value
     * @throws EmptyCollectionException if the tree is empty.
     */
    @Override
    public T findMin() throws EmptyCollectionException{
        T result = null;
        if(isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else
        {
            BinaryTreeNode<T> current = root;
            while(current.left != null)
            {
                current = current.left;
            }
            result = current.element;
        }
        return result;
    }

    /**
     * find the highest number
     * @return a highest value
     * @throws EmptyCollectionException if the tree is empty.
     */
    @Override
    public T findMax() throws EmptyCollectionException {
        T result = null;
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else
        {
            BinaryTreeNode<T> current = root;
            while(current.right != null)
            {
                current = current.right;
            }
            result = current.element;
        }
        return result;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param targetElement the target element
     * @return true if the target is in the list, false otherwise
     */

    @Override
    public boolean contains(T targetElement) {
        boolean found = false;
        try {
            find(targetElement);
            found = true;
        } catch (Exception ElementNotFoundException) {
            found = false;
        }
        return found;
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree. Throws a ElementNotFoundException if
     * the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if the element is not in the tree
     */
    @Override
    public T find(T targetElement) {
        BinaryTreeNode<T> current = findNode(targetElement, root);
        if (current == null)
            throw new ElementNotFoundException("LinkedBinaryTree");
        return (current.getElement());
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     */
    private BinaryTreeNode<T> findNode(T targetElement,
                                       BinaryTreeNode<T> next) {
        if (next == null)
            return null;
        if (next.getElement().equals(targetElement))
            return next;
        BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());
        if (temp == null)
            temp = findNode(targetElement, next.getRight());
        return temp;
    }

    public void balance()
    {
        //using inorder traversal
        Iterator<T> iterator = iteratorInOrder();

        //this temp arraylist will get the elements
        List<T> temp = new ArrayList<>();

        //adding elements
        while(iterator.hasNext())
        {
            temp.add(iterator.next());
        }

        root = rebalance(temp);
    }

    //balancing the tree here
    BinaryTreeNode<T> rebalance(List<T> element)
    {
        if(element.isEmpty())
            return null;
        else
        {
            //setting the middle
            int mid = element.size() / 2;
            //adding the middle element in the node
            BinaryTreeNode<T> node = new BinaryTreeNode<>(element.get(mid));
            //setting left side of the tree with recursion
            node.setLeft(rebalance(element.subList(0,mid)));
            //setting right side of the tree with recursion
            node.setRight(rebalance(element.subList(mid+1,element.size())));

            return node;
        }
    }
}



