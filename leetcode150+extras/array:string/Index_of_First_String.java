class Solution {
    public int strStr(String haystack, String needle) {
       return haystack.indexOf(needle);
    }
}

//sliding window

class Solution {
    public int strStr(String haystack, String needle) {
       int k=needle.length();
       int j=0;
       int i=0;
       String temp="";
       while(j<haystack.length()){
            if(j-i==k){
                if(temp.equals(needle)) return i;
                temp=temp.substring(1,temp.length());
                i++;
            }
            temp+=String.valueOf(haystack.charAt(j));
            j++;
       }
       return temp.equals(needle)?i:-1;
    }
}