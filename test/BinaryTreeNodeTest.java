import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    BinaryTreeNode<Integer> node;

    @BeforeEach
    void setUp() {
         node = new BinaryTreeNode<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRootWorksTest(){
        node.setElement(10);
        assertEquals(10, node.getElement());
    }

    @Test
    void addLeftChildAndGetRightChild(){

        node.addLeftChild(new BinaryTreeNode<>(15));
        assertEquals(15, node.getLeftChild().getElement());
    }

    @Test
    void testLeftChildNullInTheBeginning(){
        assertNull(node.getLeftChild());
    }

    @Test
    void testRightChildNullInTheBeginning(){
        assertNull(node.getRightChild());
    }



    @Test
    void addRightChildAndGetRightChild(){
        node.addRightChild(new BinaryTreeNode<>(15));
        assertEquals(15, node.getRightChild().getElement());
    }






}