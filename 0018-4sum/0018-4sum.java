class Solution {
    public List<List<Integer>> fourSum(int[] a, int tar) {
        Arrays.sort(a);
        List<List<Integer>> ans=new ArrayList<>();
        int n=a.length;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                long sumA=(long)tar-((long)a[i]+(long)a[j]);
                int b=j+1,c=n-1;
                while(b<c){
                    long sumB=(long)a[b]+(long)a[c];
                    if(sumA==sumB){
                        ArrayList<Integer> temp=new ArrayList<>();
                        temp.add(a[i]);temp.add(a[j]);temp.add(a[b]);temp.add(a[c]);
                        ans.add(temp);
                        while(b<c && a[b]==a[b+1])b++;
                        while(c>b && a[c]==a[c-1])c--;
                        b++;c--;
                    }
                    else if(sumA<sumB)c--;
                    else b++;
                }
                while(j<n-2 && a[j]==a[j+1])j++;
            }
            while(i<n-3 && a[i]==a[i+1])i++;
        }
        return ans;
    }
}