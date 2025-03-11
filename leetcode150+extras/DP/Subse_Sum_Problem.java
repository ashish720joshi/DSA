class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        int [][]dp=new int[arr.length][target+1];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
        return isSubsetSumRecur(arr,arr.length-1,target,dp)==1?true:false;
    }
    
    static int isSubsetSumRecur(int []arr,int index,int target,int [][]dp){
        if(index==0) {
            dp[index][target]=arr[index]==target?1:0;
            return dp[index][target];
        }
        if(dp[index][target]!=-1) return dp[index][target];
        if(arr[index]==target) return dp[index][target]=1;
        
        int pick=0;
        if(target>arr[index]){
            pick=isSubsetSumRecur(arr,index-1,target-arr[index],dp);
        }
        int notPick=isSubsetSumRecur(arr,index-1,target,dp);
        if(pick==1 || notPick==1){
            dp[index][target]=1;
        }else{
            dp[index][target]=0;
        }
        return dp[index][target];
    }
}