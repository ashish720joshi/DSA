class Solution {
    public int findMin(int[] nums) {
        return findPivot(nums,0,nums.length-1);
    }

     private int findPivot(int []nums,int first,int last){
        if(nums[first]<nums[last]) return nums[first];
        while(first<last){
            int mid=(first+last)/2;
            if(nums[mid]>nums[last]){
                first=mid+1;
            }else if(nums[mid]<nums[last]){
                last=mid;
            }else{
                // this handles duplicate cases however also worst case time complexity becomes O(N) if every element is duplicate
                last--;
            }
        }
        return nums[first];
    }
}