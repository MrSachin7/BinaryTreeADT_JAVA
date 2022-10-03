public class BinaryTreeNode<E> implements BinaryTreeNodeADT<E> {

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


    @Override
    public void setElement(E element) {
        this.element = element;

    }

    public E getElement() {
        return element;
    }

    @Override
    public void addLeftChild(BinaryTreeNode<E> node) {
        this.leftChild =node;

    }

    @Override
    public void addRightChild(BinaryTreeNode<E> node) {
        this.rightChild = node;

    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }


}
