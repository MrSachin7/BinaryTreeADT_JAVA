import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> binarySearchTreeUnderTest;

    @BeforeEach
    void setup() {
        binarySearchTreeUnderTest = new BinarySearchTree<>();
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

        assertEquals(10, binarySearchTreeUnderTest.size());
        boolean doesExist = binarySearchTreeUnderTest.removeElement(9);

        assertTrue(doesExist);
        // Need one less element
        assertEquals(9, binarySearchTreeUnderTest.size());
        // Need to not contain 9
        assertFalse(binarySearchTreeUnderTest.contains(9));


    }
    @Test
    void testIfRemoveWorksWhenDoesNotExists() {

        setupComplexBinarySearchTree();

        assertEquals(10, binarySearchTreeUnderTest.size());
        boolean doesExist = binarySearchTreeUnderTest.removeElement(11);

        assertFalse(doesExist);
        //Sizw doesnt change
        assertEquals(10, binarySearchTreeUnderTest.size());
        // Need to not contain 11
        assertFalse(binarySearchTreeUnderTest.contains(11));


    }



    private void setupComplexBinarySearchTree() {
        binarySearchTreeUnderTest.insert(5);
        binarySearchTreeUnderTest.insert(6);
        binarySearchTreeUnderTest.insert(9);


        binarySearchTreeUnderTest.insert(8);


        binarySearchTreeUnderTest.insert(1);
        binarySearchTreeUnderTest.insert(4);
        binarySearchTreeUnderTest.insert(2);
        binarySearchTreeUnderTest.insert(7);
        binarySearchTreeUnderTest.insert(3);
        binarySearchTreeUnderTest.insert(10);

    }


}