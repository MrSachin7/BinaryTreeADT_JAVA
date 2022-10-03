import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    BinaryTreeNodeADT<Integer> nodeADT;

    @BeforeEach
    void setUp() {
         nodeADT = new BinaryTreeNode<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRootWorksTest(){
        nodeADT.setElement(10);
        assertEquals(10, nodeADT.getElement());
    }

    @Test
    void addLeftChild(){

        nodeADT.addLeftChild(new BinaryTreeNode<>(15));
        assertEquals(15, nodeADT.getLeftChild().getElement());
    }
    @Test
    void addRightChild(){
        nodeADT.addRightChild(new BinaryTreeNode<>(15));
        assertEquals(15, nodeADT.getRightChild().getElement());
    }



}