class Solution {
    public boolean wordPattern(String pattern, String s) {
        String []stringArray=s.split("\s");
        Map<Character,String>map=new HashMap<>();
        Map<String,Character>wordMap=new HashMap<>();
        if(pattern.length()!=stringArray.length) return false;
        for(int i=0;i<pattern.length();i++){
            Character c=pattern.charAt(i);
            String word=stringArray[i];
            if(map.containsKey(c)){
                if(!map.get(c).equals(stringArray[i])) return false;
            }else if(wordMap.containsKey(word)){
                if(!wordMap.get(word).equals(c)) return false;
            }else{
                map.put(c,stringArray[i]);
                wordMap.put(stringArray[i],c);
            }
        }
        return true;
    }
}