public class Main {
    public static void main(String[] args) {





        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();

        searchTree.insert(5);
        searchTree.insert(6);
        searchTree.insert(9);


        searchTree.insert(8);


        searchTree.insert(1);
        searchTree.insert(4);
        searchTree.insert(2);
        searchTree.insert(7);
        searchTree.insert(3);
        searchTree.insert(10);

        System.out.println(searchTree.removeElement(12));


        BinaryTreePrint printer = new BinaryTreePrint();
        printer.printTree((BinaryTreeNode) searchTree.getRoot());
    }
}
