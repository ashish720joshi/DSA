/// Memoization

class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int []dp=new int[nums.length];
        int []dp2=new int[nums.length];
        int []nums2=new int[nums.length];
        int []nums1=new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length-1;i++){
            nums1[j++]=nums[i];
        }
        j=0;
        for(int i=1;i<nums.length;i++){
            nums2[j++]=nums[i];
        }
        Arrays.fill(dp, -1);
        Arrays.fill(dp2, -1);
        return Math.max(robHouse(nums1.length-1,nums1,dp),robHouse(nums2.length-1,nums2,dp2));
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

// Tabulation 
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int []dp=new int[nums.length];
        int []dp2=new int[nums.length];
        int []arr1=new int[nums.length];
        int []arr2=new int[nums.length];
        int j=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i!=n-1) arr1[j]=nums[i];
            if(i!=0) arr2[j]=nums[i];

            j++;
        }
        return Math.max(solveHouseRobber(arr1,dp),solveHouseRobber(arr2,dp2));
    }

    private int solveHouseRobber(int []nums,int []dp){
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
        int []arr1=new int[nums.length];
        int []arr2=new int[nums.length];
        int j=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i!=n-1) arr1[j]=nums[i];
            if(i!=0) arr2[j]=nums[i];

            j++;
        }
        return Math.max(solveHouseRobber(arr1),solveHouseRobber(arr2));
    }

    private int solveHouseRobber(int []nums){
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