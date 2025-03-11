import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>ansList=new ArrayList<>();
        Set<String>set=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int fixedNumber=nums[i];
            int fixedSum=-fixedNumber;
            int first=0;
            int last=nums.length-1;
            while(first<last){
                if(first==i) first++;
                else if(last==i) last--;
                else{
                    int twoSum=nums[first]+nums[last];
                    if(twoSum==fixedSum){
                        List<Integer>list=Arrays.asList(nums[i],nums[first],nums[last]);
                        Collections.sort(list);
                        String key=String.valueOf(list.get(0))+String.valueOf(list.get(1))+String.valueOf(list.get(2));
                        if(!set.contains(key)){
                            ansList.add(list);
                            set.add(key);
                        }
                    first++;
                    last--;
                    }else if(twoSum<fixedSum){
                        first++;
                    }else{
                        last--;
                    }
                }
            }
        }
        return ansList;
    }
}

// medium optmized

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        output.addAll(s);
        return output;
    }
}

//best optimized

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    // Found a triplet with zero sum
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicate elements for j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // Skip duplicate elements for k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // Move the pointers
                    j++;
                    k--;
                } else if (sum < 0) {
                    // Sum is less than zero, increment j to increase the sum
                    j++;
                } else {
                    // Sum is greater than zero, decrement k to decrease the sum
                    k--;
                }
            }
        }
        return ans;
    }
}

