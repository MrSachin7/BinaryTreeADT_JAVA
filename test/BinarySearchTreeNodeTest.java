import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeNodeTest {


    private BinarySearchTreeNode<Integer> binarySearchTreeNodeUnderTest;

    @BeforeEach
    void setup(){
        binarySearchTreeNodeUnderTest = new BinarySearchTreeNode<>();
    }

    @Test
    void initializeEveryFieldAsNull(){
        assertNull(binarySearchTreeNodeUnderTest.getRightChild());
        assertNull(binarySearchTreeNodeUnderTest.getElement());
        assertNull(binarySearchTreeNodeUnderTest.getLeftChild());

    }

    @Test
    void testGetLeftChild(){

        // Arrange
        BinarySearchTreeNode<Integer> leftNodeToTest = new BinarySearchTreeNode<>();
        leftNodeToTest.setElement(10);

        // Act
        binarySearchTreeNodeUnderTest.setElement(11);
        binarySearchTreeNodeUnderTest.addLeftChild(leftNodeToTest);

        // Assert
        assertEquals(leftNodeToTest, binarySearchTreeNodeUnderTest.getLeftChild());
        assertEquals(10, leftNodeToTest.getElement());


    }
    @Test
    void testGetRightChild(){

        // Arrange
        BinarySearchTreeNode<Integer> rightNodeToTest = new BinarySearchTreeNode<>();
        rightNodeToTest.setElement(10);

        // Act
        binarySearchTreeNodeUnderTest.setElement(11);
        binarySearchTreeNodeUnderTest.addRightChild(rightNodeToTest);

        // Assert
        assertEquals(10, binarySearchTreeNodeUnderTest.getRightChild().getElement());


    }


}