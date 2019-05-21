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


        return null;
    }



/*que retorna true se e s´o se a ´arvore bin´aria referida por root for uma ´arvore bin´aria de pesquisa, segundo o
comparador cmp.*/
    public static <E> boolean isBST(Node<E> root, Comparator<E> cmp){



        return false;
    }
}
