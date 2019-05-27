package Series;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        Series.Node node = Series.TreeUtils.createBSTFromRange(1,10);
//
//        Comparator<Integer> cmp = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1<o2)
//                    return -1;
//                else if(o1 >o2)
//                    return 1;
//                else
//                    return 0;
//            }
//        };
//
//        boolean is = Series.TreeUtils.isBST(node, cmp);

        DNACollection dna = new DNACollection();

        dna.add("ACTG");
        dna.add("GTCA");
        dna.add("AAAA");
        dna.add("ATCG");
        dna.add("ACTGACTG");
        dna.add("ATCGATCG");

        int test = dna.prefixCount("A");
    }









}
