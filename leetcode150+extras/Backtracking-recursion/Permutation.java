class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>permutationList=new ArrayList<>();
        computePermutation(nums,new ArrayList<>(),permutationList,new HashSet<>());
        return permutationList;
    }

    private void computePermutation(int []nums,List<Integer>path,List<List<Integer>> permutationList,Set<Integer>visited){
        if(path.size()>nums.length) return;
        if(path.size()==nums.length){
            permutationList.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            if(visited.contains(num)) continue;
            path.add(num);
            visited.add(num);
            computePermutation(nums,path,permutationList,visited);
            visited.remove(num);
            path.remove(path.size()-1);
        }
        
    }
}