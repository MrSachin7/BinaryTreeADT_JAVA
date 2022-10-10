import java.util.concurrent.ConcurrentMap;

public class BinaryTreeNode<E extends Comparable<E>> implements BinaryTreeNodeADT<E> {

    private E element;
    private BinaryTreeNodeADT<E> leftChild, rightChild;

    public BinaryTreeNode(E element) {
        this.element = element;
        leftChild =null;
        rightChild =null;
    }

    public BinaryTreeNode() {
        element = null;
        leftChild =null;
        rightChild =null;

    }


    @Override
    public void setElement(E element) {
        this.element = element;

    }

    public E getElement() {
        return element;
    }

    @Override
    public void addLeftChild(BinaryTreeNodeADT<E> node) {
        this.leftChild =node;

    }

    @Override
    public void addRightChild(BinaryTreeNodeADT<E> node) {
        this.rightChild = node;

    }

    @Override
    public BinaryTreeNodeADT<E> getLeftChild() {
        return  leftChild;
    }

    @Override
    public BinaryTreeNodeADT<E> getRightChild() {
        return  rightChild;
    }


}
