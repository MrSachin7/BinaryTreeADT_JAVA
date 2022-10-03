public interface BinarySearchTreeADT<E> {

    /**
     * Add an element to the tree.
     * Return true if successfully inserted, false if already present
     * @param element
     * @return
     */
    boolean insert(E element);

    /**
     * Remove an element from the tree
     * Return true if successfully removed, false if not present
     * @param element
     * @return
     */
    boolean removeElement(E element);

    /**
     * Returns the minimum element of the tree
     * @return
     */
    E findMin();

    /**
     * Returns the maximum element of the tree
     * @return
     */
    E findMax();

    /**
     * Determines if an element is present in the tree
     * Return true if present else false.
     * @param element
     * @return
     */
    boolean contains(E element);

    /**
     * Rebalance the entire tree, the outcome must
     * be a balanced tree.
     */
    void reBalance();

}
