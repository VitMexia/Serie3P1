package Test;

import Series.DNACollection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;


public class DNACollectionTest {

    @Test
    public void  null_string(){
        DNACollection dnaCollection = new DNACollection();

//        assertTrue(  dnaCollection.add(null) == IllegalArgumentException);  ?????
//        dnaCollection.add(null);

    }


    @Test
    public void  one_fragment(){
        DNACollection dnaCollection = new DNACollection();

        assertTrue(dnaCollection.prefixCount("ACTG")== 0);

        dnaCollection.add("ACTG");

        assertTrue(dnaCollection.prefixCount("ACTG")== 1);
    }

    @Test
    public void  multi_fragment(){
        DNACollection dnaCollection = new DNACollection();

        assertTrue(dnaCollection.prefixCount("ACTG")== 0);

        dnaCollection.add("ACTG");
        dnaCollection.add("GTCA");
        dnaCollection.add("AAAA");
        dnaCollection.add("ATCG");
        dnaCollection.add("ACTGACTG");
        dnaCollection.add("ATCGATCG");

        assertTrue(dnaCollection.prefixCount("ACTG")== 2);
        assertTrue(dnaCollection.prefixCount("GTCA")== 1);
        assertTrue(dnaCollection.prefixCount("AAAA")== 1);
        assertTrue(dnaCollection.prefixCount("ATCG")== 2);
        assertTrue(dnaCollection.prefixCount("ACTGACTG")== 1);
        assertTrue(dnaCollection.prefixCount("ATCGATCG")== 1);
    }



}