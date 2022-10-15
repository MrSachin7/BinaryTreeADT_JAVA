import java.util.Vector;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

    boolean isFound = false;

    public BinarySearchTree() {
        super();
    }


    public boolean insert(E element) {

        try {
            setRoot(insert(element, (BinarySearchTreeNode<E>) getRoot()));
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


        setRoot(removeElement(element, (BinarySearchTreeNode<E>) getRoot()));
        return isFound;
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
        isFound = false;
        // Base case : if the tree is empty
        if (node == null) return null;

        // Recur down the tree
        if (element.compareTo(node.getElement()) < 0) {
            node.addLeftChild(removeElement(element, (BinarySearchTreeNode<E>) node.getLeftChild()));
            return node;

        } else if (element.compareTo(node.getElement()) > 0) {
            node.addRightChild(removeElement(element, (BinarySearchTreeNode<E>) node.getRightChild()));
            return node;
        }

        // Here, the element is finally found.
        isFound = true;

        // Now there are three cases..
        // The found root might have zero, one or two childs..


        // If one child is empty, the corresponding is going to be the new root

        if (node.getLeftChild() == null) {
            return (BinarySearchTreeNode<E>) node.getRightChild();
        } else if (node.getRightChild() == null) {
            return (BinarySearchTreeNode<E>) node.getLeftChild();
        }


        // If both children exist, this is super complex...
        else {
            BinarySearchTreeNode<E> succParent = node;

            // Mission : Finding the successor for the node...
            BinarySearchTreeNode<E> succ = (BinarySearchTreeNode<E>) node.getRightChild();

            while (succ.getLeftChild() != null) {
                succParent = succ;
                succ = (BinarySearchTreeNode<E>) succ.getLeftChild();
            }

            // Here, we delete the successor .
            // Since, the succsesor is always the left child of the parent (the smaller one), we can
            // make the successors right-right child to the left of its parent.
            if (succParent != node) {
                succParent.addLeftChild(succ.getRightChild());
            } else {
                succParent.addRightChild(succ.getRightChild());
            }


            // Well, if there is no sucessor, then assign suceessor -> right  to tempParent->right..
            node.setElement(succ.getElement());
            return node;
        }

    }

    /**
     * We start at the root node, and then we keep going left until we can't go left anymore
     *
     * @return The minimum value in the tree.
     */
    public E findMin() {

        BinarySearchTreeNode<E> startNode = (BinarySearchTreeNode<E>) getRoot();

        E minVal = (E) startNode.getElement();
        while (startNode.getLeftChild() != null) {
            minVal = (E) startNode.getLeftChild().getElement();
            startNode = (BinarySearchTreeNode<E>) startNode.getLeftChild();

        }
        return minVal;
    }

    public E findMax() {
        BinarySearchTreeNode<E> startNode = (BinarySearchTreeNode<E>) getRoot();

        E maxVal = (E) startNode.getElement();
        while (startNode.getRightChild() != null) {
            maxVal = (E) startNode.getRightChild().getElement();
            startNode = (BinarySearchTreeNode<E>) startNode.getRightChild();

        }
        return maxVal;
    }

    public boolean contains(E element) {
        return contains(element, (BinarySearchTreeNode) getRoot());
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
       setRoot( reBalance((BinarySearchTreeNode<E>) getRoot()));
    }

    private BinarySearchTreeNode<E> reBalance(BinarySearchTreeNode<E> node){
        Vector<BinarySearchTreeNode<E>> nodes = new Vector<>();
        storeBinarySearchTreeNodes(node, nodes);


        int n = nodes.size();
        return buildTreeUtil(nodes, 0, n-1);
    }

    private void storeBinarySearchTreeNodes(BinarySearchTreeNode<E> node, Vector<BinarySearchTreeNode<E>> nodes) {
        // Base case
        if (node ==null) return;

        storeBinarySearchTreeNodes((BinarySearchTreeNode<E>) node.getLeftChild(), nodes);
        nodes.add(node);
        storeBinarySearchTreeNodes((BinarySearchTreeNode<E>) node.getRightChild(), nodes);

    }

    private BinarySearchTreeNode<E> buildTreeUtil(Vector<BinarySearchTreeNode<E>> nodes, int start, int end) {
        // base case
        if (start > end) return null;

        // Make the middle element root
        int mid = (start + end) /2;
        BinarySearchTreeNode<E> node = nodes.get(mid);

        // Construct left and right subtrees using inorder traversal
        node.addLeftChild(buildTreeUtil(nodes, start, mid-1));
        node.addRightChild(buildTreeUtil(nodes, mid+1, end));

        return node;


    }


}
