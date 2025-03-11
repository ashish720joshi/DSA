class Solution {
    public int rob(int[] nums) {
        int []dp=new int[nums.length];
        Arrays.fill(dp, -1);
        return robHouse(nums.length-1,nums,dp);
    }

    private int robHouse(int n,int []nums,int []dp){
        if(n<0) return 0;
        if(n==0) return nums[n];
        if(dp[n]!=-1) return dp[n];
        int pick=nums[n]+robHouse(n-2,nums,dp);
        int notPick=robHouse(n-1,nums,dp);
        return dp[n]=Math.max(pick,notPick);
    }
}


// Tabulation approach

class Solution {
    public int rob(int[] nums) {
        int []dp=new int[nums.length];
        if(nums.length==1) return nums[0];
        dp[0]=nums[0];
        dp[1]=nums[0]>nums[1]?nums[0]:nums[1];
        for(int i=2;i<nums.length;i++){
            int pick=nums[i]+dp[i-2];
            int notPick=dp[i-1];
            dp[i]=Math.max(pick,notPick);
        }
        return dp[nums.length-1];
    }
}

/// space optimization in tabulation

class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int prev=nums[0];
        int prev2=nums[0]>nums[1]?nums[0]:nums[1];
        for(int i=2;i<nums.length;i++){
            int pick=nums[i]+prev;
            int notPick=prev2;
            int curr=Math.max(pick,notPick);
            prev=prev2;
            prev2=curr;
        }
        return prev2;
    }
}