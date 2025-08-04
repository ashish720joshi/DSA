class Solution {
    public int search(int[] nums, int target) {
        int first = 0, last = nums.length - 1;
        int pivotIndex = findPivot(nums, first, last);
        if(pivotIndex==-1) return searchElement(nums,first,last,target);
        if(target>=nums[0]){ 
            return searchElement(nums, first, pivotIndex-1,target);
            // this mean in the left part of pivot
        }else{ 
            return searchElement(nums, pivotIndex, last,target);
            //right side including pivot as pivot is smallest element in array
        }
    }

    private int searchElement(int[] nums, int first, int last, int target) {
        while (first <=last) {
            int mid = (first + last) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (target > nums[mid]) {
                first = mid + 1;
            } else {
                last = mid-1;
            }
        }
        return -1;
    }

    private int findPivot(int[] nums, int first, int last) {
        if (nums[first] <= nums[last])
            return -1;
        while (first < last) {
            int mid = (first + last) / 2;
            if (nums[mid] > nums[last]) {
                first = mid + 1;
            } else {
                last = mid;
            }
        }
        return first;
    }

}