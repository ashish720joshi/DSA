class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>combinationList=new ArrayList<>();
        prepareCombination(1,n,k,new ArrayList<>(),combinationList);
        return combinationList;
    }

    private void prepareCombination(int start,int n,int k,List<Integer>path,List<List<Integer>>combinationList){

        if(path.size()==k){
            combinationList.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<=n;i++){
            path.add(i);
            prepareCombination(i+1,n,k,path,combinationList);
            path.remove(path.size()-1);
        }
    }
}