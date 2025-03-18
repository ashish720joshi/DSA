class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=0;
        int last=nums.length-1;
        int []ans={-1,-1};
        int targetPos=binarySearch(first,last,target,nums);
        if(targetPos!=-1){
           ans[0]=leftBinarySearch(0,targetPos,target,nums);
           ans[1]=rightBinarySearch(targetPos,nums.length-1,target,nums);
        }
        return ans;
    }

    private int rightBinarySearch(int first,int last,int target,int []nums){
         while(first<=last){
                int mid=(first+last)/2;
                if(target==nums[mid]){
                    first=mid+1;
                }else{
                    last=mid-1;
                }
            }
            return last;
    }

    private int leftBinarySearch(int first,int last,int target,int []nums){
        while(first<=last){
            int mid=(first+last)/2;
            if(target==nums[mid]){
                last=mid-1;
            }else{
                first=mid+1;
            }
        }
        return first;
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
}