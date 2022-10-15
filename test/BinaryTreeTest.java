import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    BinaryTree<Integer> binaryTree;


    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree<>();

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void initializedRootAsNull() {
        assertNull(binaryTree.getRoot());
    }

    @Test
    void setRoot() {
        binaryTree.setRoot(new BinaryTreeNode<>(10));
        assertEquals(10, binaryTree.getRoot().getElement());
    }

    @Test
    void isInitializedAsEmpty() {
        assertTrue(binaryTree.isEmpty());
    }

    @Test
    void isNotEmptyWhenTheRootHasValue() {
        binaryTree.setRoot(new BinaryTreeNode<>(10));
        assertFalse(binaryTree.isEmpty());
    }

    @Test
    void isEmptyWhenRootNotNullButHasNoValueAndNoChild() {

        binaryTree.setRoot(new BinaryTreeNode<>()); // Just a  new binary tree node, this binary tree node has no value
        assertTrue(binaryTree.isEmpty());
    }

    @Test
    void containsReturnTrueWhenRootIsTheElement() {
        binaryTree.setRoot(new BinaryTreeNode<>(10));
        assertTrue(binaryTree.contains(10));
    }

    @Test
    void containsTrueWhenLeftChildContainsTheValue() {

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode(10);
        BinaryTreeNode<Integer> childNode = new BinaryTreeNode<>(15);
        node1.addLeftChild(childNode);
        binaryTree.setRoot(node1);

        assertTrue(binaryTree.contains(15));

    }

    @Test
    void containsTrueWhenRightChildContainsTheValue() {

        BinaryTreeNode<Integer> node1 = new BinaryTreeNode(10);
        BinaryTreeNode<Integer> childNode = new BinaryTreeNode<>(15);
        node1.addRightChild(childNode);
        binaryTree.setRoot(node1);
        assertTrue(binaryTree.contains(15));
    }

    @Test
    void containsFalseWhenNoChildContainsTheValue() {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode(10);
        BinaryTreeNode<Integer> childNode = new BinaryTreeNode<>(15);
        node1.addRightChild(childNode);
        binaryTree.setRoot(node1);
        assertFalse(binaryTree.contains(16));
    }

    @Test
    void containsTrueOnASuperComplicatedTree() {

        setUpSuperComplexTree();
        assertTrue(binaryTree.contains(310));
    }

    @Test
    void containsFalseOnASuperComplicatedTree() {


        setUpSuperComplexTree();
        assertFalse(binaryTree.contains(311));
    }

    @Test
    void testSize() {
        setUpSuperComplexTree();
        assertEquals(13, binaryTree.size());
    }

    @Test
    void testHeight() {
        setUpSuperComplexTree();
        assertEquals(6, binaryTree.height());
    }

    @Test
    void testInOrder() {
        setUpSuperComplexTree();
        Integer[] inOrderArray = {21, 40, 15, 11, 10, 1, 31, 27, 152, 8, 7, 310, 5};
        ArrayList<Integer> correctInOrder = new ArrayList<>(List.of(inOrderArray));
        assertEquals(correctInOrder, binaryTree.inOrder());
    }

    @Test
    void testInCorrectInOrder() {
        setUpSuperComplexTree();
        Integer[] inOrderArray = {21, 40, 15, 11, 10, 1, 31, 27, 152, 8, 7, 310, 6};
        ArrayList<Integer> correctInOrder = new ArrayList<>(List.of(inOrderArray));
        assertNotEquals(correctInOrder, binaryTree.inOrder());
    }

    @Test
    void testPreOrder() {
        setUpSuperComplexTree();
        Integer[] preOrder = {10, 15, 21, 40, 11, 5, 27, 1, 31, 8, 152, 7, 310};
        ArrayList<Integer> correctPreOrder = new ArrayList<>(List.of(preOrder));
        assertEquals(correctPreOrder, binaryTree.preOrder());
    }

    @Test
    void testInCorrectPreOrder() {
        setUpSuperComplexTree();
        Integer[] preOrder = {10, 15, 21, 40, 11, 5, 27, 1, 31, 8, 152, 7, 311};
        ArrayList<Integer> correctPreOrder = new ArrayList<>(List.of(preOrder));
        assertNotEquals(correctPreOrder, binaryTree.preOrder());
    }

    @Test
    void testPostOrder() {
        setUpSuperComplexTree();
        Integer[] postOrder = {40, 21, 11, 15, 31, 1, 152, 310, 7, 8, 27, 5, 10};
        ArrayList<Integer> correctPostOrder = new ArrayList<>(List.of(postOrder));
        assertEquals(correctPostOrder, binaryTree.postOrder());
    }

    @Test
    void testLevelOrder() {
        setUpSuperComplexTree();
        Integer[] levelOrder = {10,15,5,21,11,27,40,1,8,31,152,7,310};
        ArrayList<Integer> correctLevelOrder = new ArrayList<>(List.of(levelOrder));
        assertEquals(correctLevelOrder, binaryTree.levelOrder());
    }


    private void setUpSuperComplexTree() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode(10);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode(15);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode(5);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode(11);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode(21);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode(27);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode(01);
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode(31);
        BinaryTreeNode<Integer> node8 = new BinaryTreeNode(40);
        BinaryTreeNode<Integer> node9 = new BinaryTreeNode(8);
        BinaryTreeNode<Integer> node10 = new BinaryTreeNode(7);
        BinaryTreeNode<Integer> node11 = new BinaryTreeNode(152);
        BinaryTreeNode<Integer> node12 = new BinaryTreeNode(310);

        // setup nodes
        node.addLeftChild(node1);
        node.addRightChild(node2);
        node1.addRightChild(node3);
        node1.addLeftChild(node4);
        node2.addLeftChild(node5);
        node5.addLeftChild(node6);
        node6.addRightChild(node7);
        node4.addRightChild(node8);
        node5.addRightChild(node9);
        node9.addRightChild(node10);
        node9.addLeftChild(node11);
        node10.addRightChild(node12);
        binaryTree.setRoot(node);

        BinaryTreePrint printer = new BinaryTreePrint();
        printer.printTree((BinaryTreeNode) binaryTree.getRoot());
    }


}