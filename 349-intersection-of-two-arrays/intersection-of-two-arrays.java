import java.util.*;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet <Integer> set1=new HashSet<>();
        HashSet <Integer> set2=new HashSet<>();

        for(int value :nums1){
            set1.add(value);
        }
        for(int num : nums2){
            if(set1.contains(num)){
                set2.add(num);
            }
        }
        int x=set2.size();
        int arr[]=new int[x];
        int count=0;
        for(int val:set2){
            arr[count]=val;
            count++;
        }
       
        return arr;


    }
}