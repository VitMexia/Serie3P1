package Test;

import Series.Node;
import Series.TreeUtils;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class isBSTTest extends TreeUtils {

    static final Comparator<Integer> CMP_REVERSE_ORDER= new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return i2.compareTo(i1);
        }
    };

    static final Comparator<Integer> CMP_NATURAL_ORDER= new Comparator<Integer>() {
        public int compare(Integer i1, Integer i2) {
            return i1.compareTo(i2);
        }
    };

    //Node node = TreeUtils.createBSTFromRange(1,10);


    @Test
    public void  null_node(){

        assertTrue( isBST(null,  CMP_NATURAL_ORDER) );
    }

    @Test
    public void  one_node(){
        Node node = new Node(3);

        assertTrue( isBST(node,  CMP_NATURAL_ORDER) );
    }
    @Test
    public void  multi_node(){

        Node node = TreeUtils.createBSTFromRange(1,10);

        Node notBSTNode = new Node(8);

        notBSTNode.right = new Node(9);
        notBSTNode.left = new Node(7);
        notBSTNode.left.left = new Node(4);
        notBSTNode.left.right = new Node(3);
        notBSTNode.left.left.left = new Node(10);

        assertFalse( isBST(notBSTNode,  CMP_NATURAL_ORDER) );
        assertTrue( isBST(node, CMP_NATURAL_ORDER) );
    }



}