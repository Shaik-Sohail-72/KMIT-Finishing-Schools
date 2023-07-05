import java.util.*;
class Main {
	public static void main(String[] args) {
		int arr1[]={1,2};
		int arr2[]={3,4};
		System.out.println(findMedianSortedArrays(arr1,arr2));
	}
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int begin=0;
        int end=nums1.length;
        int n1=nums1.length;
        int n2=nums2.length;
        while(begin<end){
            int i1=n1/2;
            int i2=((n1+n2+1)/2)-i1;
            int max1=(i1==0)? Integer.MIN_VALUE : nums1[i1-1];
            int min1=(i1==nums1.length)? Integer.MAX_VALUE : nums1[i1];
            
            int max2=(i2==0) ? Integer.MIN_VALUE :nums2[i2-1];
            int min2=(i2==nums2.length) ? Integer.MAX_VALUE : nums2[i2];
            
            if(max1<=min2 && max2<=min1){
                if((n1+n2)%2==0){
                    return ( (Math.max(max1,max2))+(Math.min(min1,min2)) )/2;
                }
                else{
                    return (Math.max(max1,max2));
                }
            }
            else if(max1>min2){
                end=i1-1;
            }
            else{
                begin=i2+1;
            }
        }
        return -1;
    }
}