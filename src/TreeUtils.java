import java.util.Comparator;

public class TreeUtils {

/*que retorna true se e s´o se a ´arvore bin´aria de pesquisa comra´ız root cont´emalgumelemento no intervalo [min,max],
segundo o comprador cmp.*/
    public static <E> boolean contains(Node<E> root, E min, E max, Comparator<E> cmp){
        return containsNode(root.right, min, max,cmp) != null ? true : false;
    }

    private static <E> Node containsNode(Node<E> root, E min, E max, Comparator<E> cmp){

        if(root == null) return null;
        else
            if(cmp.compare(root.value, min) >= 0 && cmp.compare(root.value, max) <= 0)
                return root;
        else
            if(cmp.compare(root.left.value, min)< 0)
                return root.right;
        else
            if(cmp.compare(root.left.value, min)>= 0)
                return root.left;
        else
            return null;

    }



/*que retorna a referˆencia para o n´o ra´ız de uma ´arvore bin´aria de pesquisa contendo os inteiros presentes no intervalo
    fechado [start,end]. A ´avore resultante deve estar balanceada.*/
    public static Node<Integer> createBSTFromRange(int start, int end){

        int [] array = new int[(end-start)+1];
        int tmp = start;

        for (int i = 0; i<array.length; ++i)
            array[i] = tmp++;

        Node<Integer> root = buildBST(array, 0, array.length-1);

        return root;
    }

    private static Node<Integer> buildBST(int[] array, int start, int end) {

        if (start > end) return null;

        int mid = (start + end) /2;

        Node root = new Node(array[mid]);

        root.left = buildBST(array, start, mid-1);
        root.right = buildBST(array,mid+1, end);

        return root;
    }



/*que retorna true se e só se a arvore binaria referida por root for uma arvore binaria de pesquisa, segundo o
comparador cmp.*/
    public static <E> boolean isBST(Node<E> root, Comparator<E> cmp){

//        if(root == null)
//            return true;

        if(root.left != null && cmp.compare(root.value, root.left.value)>0)
                isBST(root.left,cmp);
        else
            return false;

        if(root.right != null && cmp.compare(root.value, root.right.value)<0)
                isBST(root.right,cmp);
        else
            return false;

        return true;
    }

}
