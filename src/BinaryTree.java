import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> implements BinaryTreeADT<E> {

    private BinaryTreeNodeADT<E> root;
    private int size;


    public BinaryTree(BinaryTreeNodeADT root) {
        this.root = root;
    }

    public BinaryTree() {
        root = null;
    }

    @Override
    public BinaryTreeNodeADT<E> getRoot() {
        return root;
    }

    @Override
    public void setRoot(BinaryTreeNodeADT<E> root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {

        if (root == null) return true;

        // if root is not null but the content are all null
        if (root.getElement() == null && root.getRightChild() == null && root.getLeftChild() == null) return true;

        return false;
    }

    @Override
    public int size() {
        return size(root);

    }

    private int size(BinaryTreeNodeADT<E> node) {
        if (node == null) {
            return 0;
        }
        return size(node.getLeftChild()) + size(node.getRightChild()) + 1;
    }

    @Override
    public boolean contains(E element) {
        return contains(element, root);
    }

    private boolean contains(E element, BinaryTreeNodeADT<E> nodeADT) {

        if (nodeADT == null) return false;
        if (nodeADT.getElement().equals(element)) return true;
        boolean inLeft = contains(element, nodeADT.getLeftChild());
        if (inLeft) return true;
        boolean inRight = contains(element, nodeADT.getRightChild());
        if (inRight) return true;

        return false;
    }


    @Override
    public ArrayList<E> inOrder() {
        ArrayList<E> temp = new ArrayList<>();
        addInOrder(root, temp);
        return temp;

    }

    private void addInOrder(BinaryTreeNodeADT<E> node,List<E> listToAddOn){
        if (node==null){
            return;
        }
        if (listToAddOn ==null){
            listToAddOn = new ArrayList<>();
        }
        addInOrder(node.getLeftChild(), listToAddOn);

        listToAddOn.add(node.getElement());

        addInOrder(node.getRightChild(), listToAddOn);

    }

    @Override
    public ArrayList<E> preOrder() {
        ArrayList<E> temp= new ArrayList<>();
        addPreOrder(root, temp);
        return temp;
    }

    private void addPreOrder(BinaryTreeNodeADT<E> node,List<E> listToAddOn){
        if (node==null){
            return;
        }
        if (listToAddOn ==null){
            listToAddOn = new ArrayList<>();
        }
        listToAddOn.add(node.getElement());

        addPreOrder(node.getLeftChild(), listToAddOn);
        addPreOrder(node.getRightChild(), listToAddOn);

    }

    @Override
    public ArrayList<E> postOrder() {
        ArrayList<E> temp = new ArrayList<>();
        addPostOrder(root, temp);
        return temp;
    }
    private void addPostOrder(BinaryTreeNodeADT<E> node,List<E> listToAddOn){
        if (node==null){
            return;
        }
        if (listToAddOn ==null){
            listToAddOn = new ArrayList<>();
        }

        addPostOrder(node.getLeftChild(), listToAddOn);
        addPostOrder(node.getRightChild(), listToAddOn);
        listToAddOn.add(node.getElement());


    }

    @Override
    public ArrayList<E> levelOrder() {
        int height = height();
        ArrayList<E> temp = new ArrayList<>();
        for (int i = 1; i <= height; i++) {
            addCurrentLevel(root, i,temp );
        }
        return temp;
    }

    private void addCurrentLevel(BinaryTreeNodeADT<E> node, int level, List<E> listToAddOn){
        if (node ==null){
            return;
        }
        if (level==1){
            listToAddOn.add(node.getElement());
        } else if (level >1){
            addCurrentLevel(node.getLeftChild(), level-1, listToAddOn);
            addCurrentLevel(node.getRightChild(), level-1, listToAddOn);
        }


    }

    @Override
    public int height() {
        return maxHeight(root);
    }

    private int maxHeight(BinaryTreeNodeADT node){
        if (node == null){
            return 0;
        }
        int leftHeight = maxHeight(node.getLeftChild());
        int rightHeight = maxHeight(node.getRightChild());

        // return whichever has more height+1;
        return leftHeight > rightHeight ? (leftHeight+1) : (rightHeight+1);

    }
}
