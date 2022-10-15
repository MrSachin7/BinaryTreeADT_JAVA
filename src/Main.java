public class Main {
    public static void main(String[] args) {





        BinarySearchTree<Integer> searchTree = new BinarySearchTree<>();

        for (int i = 1; i <= 15; i++) {
            searchTree.insert(i);
        }
        System.out.println(searchTree.removeElement(6));

        new BinaryTreePrint().printTree(searchTree.getRoot());

        System.out.println("\n"+searchTree.preOrder());




    }
}
