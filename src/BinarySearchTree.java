public class BinarySearchTree<E extends Comparable<E>> implements BinarySearchTreeADT<E> {

    private BinarySearchTreeNode root;


    @Override
    public boolean insert(E element) {
        return insert(element, root);

    }

    private boolean insert(E element, BinarySearchTreeNode node) {
        if (node == null) {
            node = new BinarySearchTreeNode();
            node.setElement(element);
            return true;
        }
        // if element is bigger than root, recur rightways..
        if (root.getElement().compareTo(element) <0){
            insert(element, root.getRightChild());
        }
        // If the element is smaller than the root, recur leftways..
        else if (root.getElement().compareTo(element) >0){
            insert(element, root.getLeftChild());

        }
        // If the compareTo doesn't return 1 or -1 then the element is already present

        return false;


    }


    @Override
    public boolean removeElement(E element) {
        return false;
    }


    /**
     * This method removes the node with the given element and returns the new node..
     * @param element
     * @param node
     * @return
     */
    private BinarySearchTreeNode<E> removeElement(E element, BinarySearchTreeNode<E> node){
        // Base case : if the tree is empty
        if (node == null) return null;

        // Recur down the tree
        if (node.getElement().compareTo(element) <0){
             node.addLeftChild(removeElement(element, node.getRightChild()));
             return node;
        }
        else if (node.getElement().compareTo(element) > 0){
            node.addRightChild(removeElement(element, node.getLeftChild()));
            return node;
        }

        // Here, the element is finally found. Now there are three cases..
        // The found root might have zero, one or two childs..

        else{

            // If one child is empty, the corresponding is going to be the new root
            if (node.getRightChild() ==null){
                return node.getLeftChild();
            }
            if (node.getLeftChild() ==null){
                return node.getRightChild();
            }

            // If both children exist, this is super complex...
            else{
                BinarySearchTreeNode<E> tempSuccNode = node;

                // Mission : Finding the successor for the node...
                BinarySearchTreeNode<E> successorNode = node.getRightChild();

                while (successorNode != null){
                    tempSuccNode = successorNode;
                    successorNode = successorNode.getLeftChild();
                }

                // Here, we delete the successor .
                // Since, the succsesor is always the left child of the parent (the smaller one), we can
                // make the successors right-right child to the left of its parent.
                if (tempSuccNode !=node){
                    tempSuccNode.addLeftChild(successorNode.getRightChild());
                }
                else{
                    tempSuccNode.addRightChild(successorNode.getRightChild());
                }


                // Well, if there is no sucessor, then assign suceessor -> right  to tempParent->right..
                node.setElement(successorNode.getElement());
                return node;
            }
        }
    }

    @Override
    public E findMin() {

        BinarySearchTreeNode<E> startNode = root;

        E minVal = (E) startNode.getElement();
        while (startNode.getLeftChild()!=null){
            minVal = (E) startNode.getLeftChild().getElement();
            startNode = startNode.getLeftChild();

        }
        return minVal;
    }

    @Override
    public E findMax() {
        BinarySearchTreeNode<E> startNode = root;

        E maxVal = (E) startNode.getElement();
        while (startNode.getRightChild()!=null){
            maxVal = (E) startNode.getRightChild().getElement();
            startNode = startNode.getRightChild();

        }
        return maxVal;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public void reBalance() {

    }
}
