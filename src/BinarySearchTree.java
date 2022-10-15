public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    private BinarySearchTreeNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTreeNode<E> getRoot() {
        return this.root;
    }


    public boolean insert(E element) {

        try {
           root= insert(element, root);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    private BinarySearchTreeNode<E> insert(E element, BinarySearchTreeNode<E> node) throws Exception {
        if (node == null) {
            node = new BinarySearchTreeNode<>(element);
            return node;
        } else if (element.compareTo(node.getElement()) < 0) {
            node.addLeftChild(insert(element, (BinarySearchTreeNode<E>) node.getLeftChild()));
        } else if (element.compareTo(node.getElement()) > 0) {
            node.addRightChild(insert(element, (BinarySearchTreeNode<E>) node.getRightChild()));

        }

        return node;

    }


    public boolean removeElement(E element) {
        BinarySearchTreeNode<E> node = removeElement(element, root);
        if (node == null) return false;
        return true;

    }


    /**
     * We are going to find the successor of the node to be deleted, and then replace the node to be deleted with the
     * successor
     *
     * @param element The element to be removed.
     * @param node    The node to be removed.
     * @return The node that is being returned is the node that is being removed.
     */
    private BinarySearchTreeNode<E> removeElement(E element, BinarySearchTreeNode<E> node) {
        // Base case : if the tree is empty
        if (node == null) return null;

        // Recur down the tree
        if (node.getElement().compareTo(element) < 0) {
            node.addLeftChild(removeElement(element, (BinarySearchTreeNode<E>) node.getRightChild()));
            return node;
        } else if (node.getElement().compareTo(element) > 0) {
            node.addRightChild(removeElement(element, (BinarySearchTreeNode<E>) node.getLeftChild()));
            return node;
        }

        // Here, the element is finally found. Now there are three cases..
        // The found root might have zero, one or two childs..

        else {

            // If one child is empty, the corresponding is going to be the new root
            if (node.getRightChild() == null) {
                return (BinarySearchTreeNode<E>) node.getLeftChild();
            }
            if (node.getLeftChild() == null) {
                return (BinarySearchTreeNode<E>) node.getRightChild();
            }

            // If both children exist, this is super complex...
            else {
                BinarySearchTreeNode<E> tempSuccNode = node;

                // Mission : Finding the successor for the node...
                BinarySearchTreeNode<E> successorNode = (BinarySearchTreeNode<E>) node.getRightChild();

                while (successorNode != null) {
                    tempSuccNode = successorNode;
                    successorNode = (BinarySearchTreeNode<E>) successorNode.getLeftChild();
                }

                // Here, we delete the successor .
                // Since, the succsesor is always the left child of the parent (the smaller one), we can
                // make the successors right-right child to the left of its parent.
                if (tempSuccNode != node) {
                    tempSuccNode.addLeftChild(successorNode.getRightChild());
                } else {
                    tempSuccNode.addRightChild(successorNode.getRightChild());
                }


                // Well, if there is no sucessor, then assign suceessor -> right  to tempParent->right..
                node.setElement((E) successorNode.getElement());
                return node;
            }
        }
    }

    /**
     * We start at the root node, and then we keep going left until we can't go left anymore
     *
     * @return The minimum value in the tree.
     */
    public E findMin() {

        BinarySearchTreeNode<E> startNode = root;

        E minVal = (E) startNode.getElement();
        while (startNode.getLeftChild() != null) {
            minVal = (E) startNode.getLeftChild().getElement();
            startNode = (BinarySearchTreeNode<E>) startNode.getLeftChild();

        }
        return minVal;
    }

    public E findMax() {
        BinarySearchTreeNode<E> startNode = root;

        E maxVal = (E) startNode.getElement();
        while (startNode.getRightChild() != null) {
            maxVal = (E) startNode.getRightChild().getElement();
            startNode = (BinarySearchTreeNode<E>) startNode.getRightChild();

        }
        return maxVal;
    }

    public boolean contains(E element) {
        return contains(element, root);
    }

    private boolean contains(E element, BinarySearchTreeNode node) {

        if (node == null || node.getElement() == null) return false;
        if (node.getElement().compareTo(element) > 0) {
            return contains(element, (BinarySearchTreeNode) node.getLeftChild());
        } else if (node.getElement().compareTo(element) < 0) {
            return contains(element, (BinarySearchTreeNode) node.getRightChild());
        } else {
            // If compare to method returns 0, its equal
            return true;
        }

    }

    public void reBalance() {

    }
}
