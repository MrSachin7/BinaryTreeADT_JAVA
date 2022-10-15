import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private BinarySearchTree<Integer> binarySearchTreeUnderTest;

    @BeforeEach
    void setup(){
        binarySearchTreeUnderTest = new BinarySearchTree<>();
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void initializeRootAsNull(){
        assertNull(binarySearchTreeUnderTest.getRoot());
    }

    @Test
    void insertingOnTheEmptySetsTheRoot(){
        binarySearchTreeUnderTest.insert(5);
        assertEquals(binarySearchTreeUnderTest.getRoot().getElement(), 5);
        assertTrue(binarySearchTreeUnderTest.contains(5));
    }

    @Test
    void containsWorksOnComplexTrees(){
        setupComplexBinarySearchTree();
        assertTrue(binarySearchTreeUnderTest.contains(2));
    }




    private void setupComplexBinarySearchTree(){
        binarySearchTreeUnderTest.insert(1);
        binarySearchTreeUnderTest.insert(2);
        binarySearchTreeUnderTest.insert(3);
        binarySearchTreeUnderTest.insert(4);
        binarySearchTreeUnderTest.insert(5);
        binarySearchTreeUnderTest.insert(6);
        binarySearchTreeUnderTest.insert(7);
        binarySearchTreeUnderTest.insert(8);
        binarySearchTreeUnderTest.insert(9);
        binarySearchTreeUnderTest.insert(10);

    }




}