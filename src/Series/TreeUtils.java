package Series;

import java.util.Comparator;

public class TreeUtils {

/*que retorna true se e s´o se a ´arvore bin´aria de pesquisa comra´ız root cont´emalgumelemento no intervalo [min,max],
segundo o comprador cmp.*/
    public static <E> boolean contains(Node<E> root, E min, E max, Comparator<E> cmp){
        return containsNode(root, min, max,cmp) != null ? true : false;
    }

    private static <E> Node containsNode(Node<E> root, E min, E max, Comparator<E> cmp){

        if(root == null ) return null;

        if(cmp.compare(root.value, min) >= 0 && cmp.compare(root.value, max) <= 0)
                return root;

        if(root.left != null &&  cmp.compare(root.left.value, min)< 0)
               return containsNode(root.right, min, max, cmp);
        else
            if(root.right != null && cmp.compare(root.right.value, min)>= 0)
               return containsNode(root.left, min, max, cmp);

        return null;

    }



/*que retorna a referˆencia para o n´o ra´ız de uma ´arvore bin´aria de pesquisa contendo os inteiros presentes no intervalo
    fechado [start,end]. A ´avore resultante deve estar balanceada.*/
    public static Node<Integer> createBSTFromRange(int start, int end){

        if(end<start) return null;

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

        E max = getMax(root);
        E min = getMin(root);

        return isBSTAux(root, min, max, cmp);
    }


    private static <E> E getMin(Node<E> root) {

        if(root == null) return null;

        if(root.left == null) return root.value;

        return getMin(root.left);
    }

    private static <E> E getMax(Node<E> root) {
        if(root == null) return null;

        if(root.right == null) return root.value;

        return getMax(root.right);
    }

    private static <E> boolean isBSTAux(Node<E> root, E min, E max, Comparator cmp) {

        if (root == null) return true;

        if (cmp.compare(root.value , min ) < 0 || cmp.compare(root.value , max )>0) {
            return false;
        }

        return (isBSTAux(root.left, min, root.value, cmp) &&
                    isBSTAux(root.right, root.value, max, cmp));
    }



}
