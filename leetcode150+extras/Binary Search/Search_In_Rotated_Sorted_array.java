class Solution {
    public int search(int[] nums, int target) {
      int pivot=findPivot(0,nums.length-1,nums);
      if(pivot==-1) return binarySearch(0,nums.length-1,target,nums);

      if(target==nums[pivot]) return pivot;
      if(target>=nums[0]){
        return binarySearch(0,pivot-1,target,nums);
      }else{
        return binarySearch(pivot+1,nums.length-1,target,nums);
      }     
    }

    private int binarySearch(int first,int last,int target,int []nums){
         while(first<=last){
            int mid=(first+last)/2;
            if(target==nums[mid]) return mid;
            else if(target<nums[mid]){
                last=mid-1;
            }else{
                first=mid+1;
            }
        }
        return -1;
    }

    private int findPivot(int first,int last,int []nums){
        if(nums[first]<=nums[last]) return -1;
        while(first<last){
          int mid=(first+last)/2;
          if(nums[mid]>nums[last]){
            first=mid+1;
          }else{
            last=mid;
        }
      }
      return first;
    }
}