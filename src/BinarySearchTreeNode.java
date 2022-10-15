public class BinarySearchTreeNode<E extends Comparable<E>> extends BinaryTreeNode<E> {

    private E element;

    public BinarySearchTreeNode() {
        super();
        this.element = null;

    }

    public BinarySearchTreeNode(E element){
        this.element = element;

    }


    public void setElement(E element) {
        this.element = element;
    }

    @Override
    public E getElement() {
        return element;
    }


}
