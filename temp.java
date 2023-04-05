import java.util.*;
class temp{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String txt=sc.nextLine();
        String temp=sc.nextLine();
        String arr[]=temp.split(" ");
        //String arr[]={"colleges","kmec","ngit"};
        //indexPairs("thekmecandngitcolleges",arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void indexPairs(String text, String[] words) {
        List<int[]> indexPairsList = new ArrayList<int[]>();
        for (String word : words) {
            int wordLength = word.length();
            int curIndex = 0;
            while (curIndex >= 0) {
                curIndex = text.indexOf(word, curIndex);
                if (curIndex >= 0) {
                    indexPairsList.add(new int[]{curIndex, curIndex + wordLength - 1});
                    curIndex++;
                }
            }
        }
        Collections.sort(indexPairsList, new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[0] != array2[0])
                    return array1[0] - array2[0];
                else
                    return array1[1] - array2[1];
            }
        });
        int length = indexPairsList.size();
        int[][] indexPairs = new int[length][2];
        for (int i = 0; i < length; i++) {
            int[] indexPair = indexPairsList.get(i);
            System.out.print(indexPair[0]+" "+indexPair[1]);
            System.out.println();
        }
    }
}

  