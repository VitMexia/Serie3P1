package Test;

import Series.Node;
import Series.TreeUtils;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CreateBSTFromRangeTest extends TreeUtils {

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

    @Test
    public void  bad_Range(){

        assertTrue( createBSTFromRange(3,1) == null);
    }

    @Test
    public void  unitary_range(){
        assertTrue( createBSTFromRange(1,1) != null);
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


        assertTrue( validateBST(node) );
        assertTrue( validateBST(node) );
        assertTrue( isBalanced(node) );

        assertFalse(validateBST(notBSTNode));
        assertFalse( validateBST(notBSTNode) );
        assertTrue (isBalanced(node) );
        assertFalse( isBalanced(notBSTNode) );
    }

    private boolean validateBST(Node node){
        int max = getMax(node);
        int min = getMin(node);

        return isBSTAux(node, min, max);
    }

    private static  boolean isBSTAux(Node<Integer> node, int min, int max) {

        if (node == null) return true;

        if (node.value < min || node.value > max ) {
            return false;
        }

        return (isBSTAux(node.left, min, node.value-1) &&
                isBSTAux(node.right, node.value+1, max));
    }

    private static int getMin(Node<Integer> node) {

        if(node == null) return 0;

        if(node.left == null) return node.value;

        return getMin(node.left);
    }

    private static int getMax(Node<Integer> node) {
        if(node == null) return 0;

        if(node.right == null) return node.value;

        return getMax(node.right);
    }


    private boolean isBalanced(Node node){
        return isBalancedAux(node) != -1;
    }

    private int isBalancedAux(Node node) {
        if(node == null) return 0;

        int l = isBalancedAux(node.left);
        int r = isBalancedAux(node.right);

        if(l == -1 || r == -1) return -1;

        return (Math.abs(l-r))<= 1 ? Math.max(l,r)+1 : -1;
    }
}