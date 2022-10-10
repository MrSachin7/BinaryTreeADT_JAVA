import java.util.concurrent.ConcurrentMap;

public class BinarySearchTreeNode<E extends Comparable<E>> extends BinaryTreeNode<E> {

    private E element;
    private BinarySearchTreeNode<E> leftChild, rightChild;

    public BinarySearchTreeNode() {
        this.element = null;
        leftChild = null;
        rightChild = null;
    }

    @Override
    public BinarySearchTreeNode<E> getLeftChild() {
        return leftChild;
    }

    @Override
    public BinarySearchTreeNode<E> getRightChild() {
        return rightChild;
    }

    public void addLeftChild(BinarySearchTreeNode<E> node) {
        this.leftChild = node;
    }

    public void addRightChild(BinarySearchTreeNode<E> node) {
        this.rightChild = node;
    }
}
