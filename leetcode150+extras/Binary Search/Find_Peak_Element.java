class Solution {
    public int findPeakElement(int[] nums) {
        int first=0;
        int last=nums.length-1;
        while(first<=last){
            int mid=(first+last)/2;
            if(isPeakElement(nums,mid)) return mid;
            else if(checkBaseConditions(mid,nums.length-1) && 
            nums[mid+1]>nums[mid]){
                first=mid+1;
            }else if(checkBaseConditions(mid,nums.length-1) && 
            nums[mid+1]<nums[mid]){
                last=mid-1;
            }else{
                return nums[first]>nums[last]?first:last;
            }
        }
        return first;
    }

    private boolean isPeakElement(int []nums,int mid){
        return (checkBaseConditions(mid,nums.length-1) && nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]);
    }

    private boolean checkBaseConditions(int mid,int n){
        return mid+1<=n && mid-1>=0;
    }
}