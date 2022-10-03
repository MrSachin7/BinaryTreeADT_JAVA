import java.util.ArrayList;

public interface BinaryTreeADT<E> {

    /**
     * Returns a reference to the root or null if tree is empty
     * @return
     */
    BinaryTreeNodeADT<E> getRoot();

    /**
     * Set the root of the tree
     * @param root
     */
    void setRoot(BinaryTreeNodeADT<E> root);

    /**
     * Determines whether the tree is Empty
     * @return
     */
    boolean isEmpty();

    /**
     * Returns the number of element in the tree
     * @return
     */
    int size();

    /**
     * Determines if an element is present in the tree
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * Returns a inOrder representation of the tree
     * or null if the tree is empty
     * @return
     */
    ArrayList<E> inOrder();

    /**
     *Returns a preOrder representation of the tree
     * or null if the tree is empty
     * @return
     */
    ArrayList<E> preOrder();


    /**
     * Returns a postOrder representation of the tree
     * or null if the tree is empty
     * @return
     */
    ArrayList<E> postOrder();

    /**
     * Returns a level Order representation of the tree
     * or null if the tree is empty
     * @return
     */
    ArrayList<E> levelOrder();

    /**
     * Returns the height of the tree
     * or -l if the tree is empty
     * @return
     */
    int height();


}
