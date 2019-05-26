import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Node node = TreeUtils.createBSTFromRange(1,10);

        Comparator<Integer> cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1<o2)
                    return -1;
                else if(o1 >o2)
                    return 1;
                else
                    return 0;
            }
        };

        boolean is = TreeUtils.isBST(node, cmp);
    }









}
