// memoization approach

class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int []dp=new int[arr.length];
        int n=arr.length-1;
        return minimizeCostCalc(k,arr,dp,n);
    }
    
    private int minimizeCostCalc(int k,int []arr,int []dp,int n){
       if(n==0) return 0;
       if(dp[n]!=0) return dp[n];
       int min=Integer.MAX_VALUE;
       for(int i=1;i<=k;i++){
        if(n-i>=0){
            int jump=minimizeCostCalc(k,arr,dp,n-i)+Math.abs(arr[n-i]-arr[n]);
            min=Math.min(min,jump);
        }
       }
       return dp[n]=min;
    }
}

// Tabulation approach

class Solution {
    public int minimizeCost(int k, int arr[]) {
        // code here
        int []dp=new int[arr.length];
        int n=arr.length-1;
        for(int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j>=0){
                  int jump=dp[i-j]+Math.abs(arr[i-j]-arr[i]);
                  min=Math.min(min,jump);
                }
            }
            dp[i]=min;
        }
        return dp[n];
    }
}