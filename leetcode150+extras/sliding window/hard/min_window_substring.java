class Solution {
    public String minWindow(String s, String t) {

        int right=0,left=0,n=s.length();
        Map<Character,Integer>windowMap=new HashMap<>();
        Map<Character,Integer>needMap=new HashMap<>();
        for(int i=0;i<t.length();i++){
            needMap.put(t.charAt(i),needMap.getOrDefault(t.charAt(i),0)+1);
        }
        int have=0,needCount=needMap.size();
        int minLen=Integer.MAX_VALUE;
        int start=0;
        while(right<n){
            char curr=s.charAt(right);
            windowMap.put(curr,windowMap.getOrDefault(curr,0)+1);
            if(windowMap.containsKey(curr) && needMap.getOrDefault(curr,0).intValue()==windowMap.getOrDefault(curr,0).intValue()){
                have++;
            }
            while(have==needCount){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    start=left;
                }
                char c=s.charAt(left);
                windowMap.put(c,windowMap.get(c)-1);
                if(needMap.containsKey(c) && windowMap.getOrDefault(c,0)<needMap.getOrDefault(c,0)){
                    have--;
                }
                left++;
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);

    }
}