package Series;

public class DNACollection {

    Fragment fragmentCollection;

    public DNACollection(){
        fragmentCollection = new Fragment();
    }

    public void add(String fragment){

        Fragment tempFrag = fragmentCollection;

        for(int i = 0; i<fragment.length(); i++){

            switch(fragment.charAt(i)){
                case 'A':
                    if(tempFrag.array[0] == null){
                        tempFrag.array[0] = new Fragment();
                    }
                    tempFrag = tempFrag.array[0];
                    break;
                case 'C':
                    if(tempFrag.array[1] == null){
                        tempFrag.array[1] = new Fragment();
                    }
                    tempFrag = tempFrag.array[1];
                    break;
                case 'T':
                    if(tempFrag.array[2] == null){
                        tempFrag.array[2] = new Fragment();
                    }
                    tempFrag = tempFrag.array[2];
                    break;
                case 'G':
                    if(tempFrag.array[3] == null){
                        tempFrag.array[3] = new Fragment();
                    }
                    tempFrag = tempFrag.array[3];
                    break;
                default:
                    throw new IllegalArgumentException();
            }

        }

        if(tempFrag!= null) tempFrag.isWord = true;

    }

    public int prefixCount(String p){

        int fragCount = 0;
        Fragment tempFrag = fragmentCollection;

        for(int i = 0; i<p.length(); i++){

            switch(p.charAt(i)){
                case 'A':
                    tempFrag = tempFrag.array[0];
                    break;
                case 'C':
                    tempFrag = tempFrag.array[1];
                    break;
                case 'T':
                    tempFrag = tempFrag.array[2];
                    break;
                case 'G':
                    tempFrag = tempFrag.array[3];
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }

        if(tempFrag == null) return 0;

        fragCount = getFragCount(tempFrag);

        return fragCount;
    }

    private int getFragCount(Fragment tempFrag) {

        int count = 0;

        if(tempFrag == null) return 0;

        if(tempFrag.isWord)
            count++;

        count += getFragCount(tempFrag.array[0]);
        count += getFragCount(tempFrag.array[1]);
        count += getFragCount(tempFrag.array[2]);
        count += getFragCount(tempFrag.array[3]);

        return count;
    }


    class Fragment {
        boolean isWord;
        //A, C, T, G
        Fragment []array = new Fragment[4];
    }
}
