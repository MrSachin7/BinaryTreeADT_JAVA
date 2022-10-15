import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> binarySearchTreeUnderTest;
    private int binarySearchTreeUnderTestSizeToCreate;

    @BeforeEach
    void setup() {
        binarySearchTreeUnderTest = new BinarySearchTree<>();
        binarySearchTreeUnderTestSizeToCreate = 15;
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void initializeRootAsNull() {
        assertNull(binarySearchTreeUnderTest.getRoot());
    }

    @Test
    void insertingOnTheEmptySetsTheRoot() {
        binarySearchTreeUnderTest.insert(5);
        assertEquals(binarySearchTreeUnderTest.getRoot().getElement(), 5);

    }

    @Test
    void containsWorksOnComplexTrees() {
        setupComplexBinarySearchTree();
        assertTrue(binarySearchTreeUnderTest.contains(2));
    }

    @Test
    void testIfRemoveWorksWhenExists() {

        setupComplexBinarySearchTree();

        assertEquals(binarySearchTreeUnderTestSizeToCreate, binarySearchTreeUnderTest.size());
        boolean doesExist = binarySearchTreeUnderTest.removeElement(binarySearchTreeUnderTestSizeToCreate);

        assertTrue(doesExist);

        // Need to not contain the last element
        assertFalse(binarySearchTreeUnderTest.contains(binarySearchTreeUnderTestSizeToCreate));
        // Need one less element
        assertEquals(binarySearchTreeUnderTestSizeToCreate-1, binarySearchTreeUnderTest.size());
    }

    @Test
    void testIfRemoveWorksWhenRemovingTheRoot() {

        setupComplexBinarySearchTree();
        assertEquals(binarySearchTreeUnderTestSizeToCreate, binarySearchTreeUnderTest.size());

        Integer root = binarySearchTreeUnderTest.getRoot().getElement();
        boolean doesExist = binarySearchTreeUnderTest.removeElement(root);

        assertTrue(doesExist);

        // Need to not contain the last element
        assertFalse(binarySearchTreeUnderTest.contains(root));
        // Need one less element
        assertEquals(binarySearchTreeUnderTestSizeToCreate-1, binarySearchTreeUnderTest.size());



    }
    @Test
    void testIfRemoveWorksWhenDoesNotExists() {

        setupComplexBinarySearchTree();

        assertEquals(15, binarySearchTreeUnderTest.size());
        boolean doesExist = binarySearchTreeUnderTest.removeElement(binarySearchTreeUnderTestSizeToCreate+1);

        assertFalse(doesExist);
        //Sizw doesnt change
        assertEquals(binarySearchTreeUnderTestSizeToCreate, binarySearchTreeUnderTest.size());
        // Need to not contain 11
        assertFalse(binarySearchTreeUnderTest.contains(binarySearchTreeUnderTestSizeToCreate+1));


    }

    @Test
    void testFindMin(){
        setupComplexBinarySearchTree();
        assertEquals(1, binarySearchTreeUnderTest.findMin());
    }

    @Test
    void testFindMax(){
        setupComplexBinarySearchTree();
        // Since, size is the max item
        assertEquals(binarySearchTreeUnderTestSizeToCreate, binarySearchTreeUnderTest.findMax());
    }

    @Test
    void testRebalance(){
        setupComplexBinarySearchTree();
        Integer[] correctPreOrderAtBalance  ={8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 15};
        ArrayList<Integer> expectedPreOrder = new ArrayList<>(List.of(correctPreOrderAtBalance));

        binarySearchTreeUnderTest.reBalance();

        assertEquals(expectedPreOrder, binarySearchTreeUnderTest.preOrder());

    }



    private void setupComplexBinarySearchTree() {
        for (int i = 1; i <= binarySearchTreeUnderTestSizeToCreate; i++) {
            binarySearchTreeUnderTest.insert(i);
        }
        new BinaryTreePrint().printTree(binarySearchTreeUnderTest.getRoot());

    }


}