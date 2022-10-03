public interface BinaryTreeNodeADT<E> {

    /**
     *     Store the element in the Node
     * @param element
     */
    void setElement(E element);

    /**
     * Returns the element from the Node
     * @return
     */
    E getElement();

    /**
     * Add a left Child to the Node
     * @param node
     */
    void addLeftChild(BinaryTreeNode<E> node);


    /**
     *Add a right Child to the Node
     * @param node
     */
    void addRightChild(BinaryTreeNode<E> node);

    /**
     * Returns a reference to the left Child
     * or null if there is no left Child
     */
    BinaryTreeNode<E> getLeftChild();

    /**
     * Returns a reference to the right Child
     * or null if there is no right Child
     * @return
     */
    BinaryTreeNode<E> getRightChild();
}
