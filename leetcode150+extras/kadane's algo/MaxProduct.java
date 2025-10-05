class Solution {
    public int maxProduct(int[] nums) {
        int minSoFar=nums[0];
        int maxSoFar=nums[0];
        int result=nums[0];
        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            int tempMaxSoFar=Math.max(curr,Math.max(curr*maxSoFar,curr*minSoFar));
            minSoFar=Math.min(curr,Math.min(curr*maxSoFar,curr*minSoFar));
            maxSoFar=tempMaxSoFar;
            result=Math.max(result,maxSoFar);
        }
        return result;
    }
}