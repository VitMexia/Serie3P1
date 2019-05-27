package Test;

import Series.Node;
import Series.TreeUtils;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ContainsTest extends TreeUtils {

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
        assertFalse( contains(null, 0, 0, CMP_NATURAL_ORDER) );
    }


    @Test
    public void  one_node(){
        Node node = new Node(3);
        assertFalse( contains(node, 0, 2, CMP_NATURAL_ORDER) );
        assertTrue( contains(node, 0, 3, CMP_NATURAL_ORDER) );
    }
    @Test
    public void  multi_node(){
        Node node = TreeUtils.createBSTFromRange(1,10);
        assertFalse( contains(node, 11, 15, CMP_NATURAL_ORDER) );
        assertTrue( contains(node, 0, 3, CMP_NATURAL_ORDER) );
    }



}