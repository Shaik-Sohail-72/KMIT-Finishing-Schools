import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main
{   
    public static void main(String[] args) {
        int arr[]={34, 2 ,7, 23, 31, 38, 13, 11, 37, 19, 45, 6};
        findLongestConseqSubseq(arr ,12);
    }
	static void findLongestConseqSubseq(int arr[], int N)
	{
	    int c=0;
	    Arrays.sort(arr);
	    List<Integer> ls=new ArrayList<>();
	    for(int i=arr[0];i<=arr[N-1];i++){
	        ls.add(i);
	    }
        System.out.println(ls);
	    int m=0;
	    int curr=0;
	    for(int i=0;i<N;i++){
	        if(ls.contains(arr[i])){
	            curr++;
	        }else{
	            m=Math.max(curr,m);
	            curr=1;
	        }
	    }
	    System.out.println(m);
	}
}