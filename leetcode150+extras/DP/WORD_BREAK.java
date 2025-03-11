class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String>set =wordDict.stream().collect(Collectors.toSet());
        Map<String,Boolean>dp=new HashMap<>();
        return checkWordBreak(s,set,dp);
        }

    private boolean checkWordBreak(String word,Set<String>wordDict,Map<String,Boolean> dp){
         if(word.isEmpty()) return true;

         if(dp.containsKey(word)) return dp.get(word);

         int length=word.length();

         for(int i=1;i<=length;i++){
            String prefix=word.substring(0,i);
            if(wordDict.contains(prefix) && checkWordBreak(word.substring(i),       wordDict,dp)){
              dp.put(word,true);
              return true;
            }
         }  
         dp.put(word,false);
         return false;
    }
}