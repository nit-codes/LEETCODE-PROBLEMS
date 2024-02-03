class Solution {
    public int maxSumAfterPartitioning(int[] a, int k) {
        int n=a.length;
        int dp[]=new int[n];
        dp[0]=a[0];
        for(int i=1;i<n;i++){
            int max=0;
            int max_value=0;
            for(int j=i;j>=Math.max(0,i-k+1);j--){
                max_value=Math.max(a[j],max_value);
                if(j>0){
                    max=Math.max(max,(i-j+1)*(max_value)+dp[j-1]);
                }else if(j==0){
                    max=Math.max(max,(i-j+1)*(max_value));
                }
            }
            dp[i]=max;
        }
        return dp[n-1];
    }
}
