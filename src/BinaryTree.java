import java.util.ArrayList;

public class BinaryTree<E> implements BinaryTreeADT<E>  {

    private BinaryTreeNodeADT<E> root;
    private int size;


    public BinaryTree(BinaryTreeNodeADT root){
        this.root = root;
    }

    @Override
    public BinaryTreeNodeADT<E> getRoot() {
        return  root;
    }

    @Override
    public void setRoot(BinaryTreeNodeADT<E> root) {
      this.root = root;
    }

    @Override
    public boolean isEmpty() {
//        if (root ==null){
//            return true;
//        }
//        if (root.getLeftChild()==null && root.getRightChild()==null){
//            return true;
//        }
//
//        return false;

        return root ==null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(E element) {
        if (root==null){
            return false;
        }
        if (root.getElement().equals(element)) return true;

        BinaryTreeNodeADT<E> nodeLeft = root.getLeftChild();
        while (true) {
            // Travel entire left
                if (nodeLeft.getElement().equals(element)) return true;

        }
    }

    private boolean isOnLeft(E element, BinaryTreeNodeADT<E> nodeADT){
        return false;
//        if (nodeADT ==null) return false;

    }

    @Override
    public ArrayList<E> inOrder() {
        return null;
    }

    @Override
    public ArrayList<E> preOrder() {
        return null;
    }

    @Override
    public ArrayList<E> postOrder() {
        return null;
    }

    @Override
    public ArrayList<E> levelOrder() {
        return null;
    }

    @Override
    public int height() {
        return 0;
    }
}
