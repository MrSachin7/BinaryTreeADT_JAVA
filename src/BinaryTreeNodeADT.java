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
    void addLeftChild(BinaryTreeNodeADT<E> node);


    /**
     *Add a right Child to the Node
     * @param node
     */
    void addRightChild(BinaryTreeNodeADT<E> node);

    /**
     * Returns a reference to the left Child
     * or null if there is no left Child
     */
    BinaryTreeNodeADT<E> getLeftChild();

    /**
     * Returns a reference to the right Child
     * or null if there is no right Child
     * @return
     */
    BinaryTreeNodeADT<E> getRightChild();
}
