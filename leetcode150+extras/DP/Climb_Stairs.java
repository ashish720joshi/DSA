class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1) return 1;
        return climbStairs(n-1)+climbStairs(n-2);
    }
}

// using tabulation

class Solution {
    public int climbStairs(int n) {
        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        return countWays(n,dp);
    }

    private int countWays(int n,int []dp){
        if(dp[n]!=0) return dp[n];
        return dp[n]=countWays(n-1,dp)+countWays(n-2,dp);
    }
}

//optimized---don't need complete array

class Solution {
    public int climbStairs(int n) {
        int prev=1;
        int prev2=1;
        for(int i=2;i<=n;i++){
            int curr=prev+prev2;
            prev=prev2;
            prev2=curr;
        }
        return prev2;
    }
}