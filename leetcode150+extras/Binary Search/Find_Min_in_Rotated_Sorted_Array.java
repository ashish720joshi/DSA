class Solution {
    public int findMin(int[] nums) {
        int first=0;
        int last=nums.length-1;
        if(nums[first]<=nums[last]) return nums[first];
        while(first<=last){
            int mid=(first+last)/2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if(nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid]>nums[last]){
                first=mid+1;
            }else{
                last=mid-1;
            }
        }
        return nums[first];
    }
}