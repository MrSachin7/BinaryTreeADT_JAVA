import java.util.concurrent.ConcurrentMap;

public class BinaryTreeNode<E>  {

    private E element;
    private BinaryTreeNode<E> leftChild, rightChild;

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



    public void setElement(E element) {
        this.element = element;

    }

    public E getElement() {
        return element;
    }


    public void addLeftChild(BinaryTreeNode<E> node) {
        this.leftChild =node;

    }


    public void addRightChild(BinaryTreeNode<E> node) {
        this.rightChild = node;

    }


    public BinaryTreeNode<E> getLeftChild() {
        return  leftChild;
    }


    public BinaryTreeNode<E> getRightChild() {
        return  rightChild;
    }


}
