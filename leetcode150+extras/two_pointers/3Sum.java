//medium optmized

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        Set<List<Integer>>set=new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k=nums.length-1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        ansList.addAll(set);
        return ansList;
    }
}


//best optimized

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int j = i + 1;
            int k=nums.length-1;
            //checking duplicate elements for i
            if(i>0 && nums[i]==nums[i-1]) continue;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    ansList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    //skipping duplicates elment by just checking previous for j and next for k as k stars from last
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(k>j && nums[k]==nums[k+1]) k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ansList;
    }
}





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

