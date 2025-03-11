class Solution {
    public String reverseWords(String s) {
        char[] charArray=s.toCharArray();
        StringBuilder builder=new StringBuilder();
        String reversed="";
        int n=s.length();
        for(int i=n-1;i>=0;i--){
            if(charArray[i]!=' '){
                builder.append(charArray[i]);
            }else if(builder.length()!=0){
                reversed+=builder.reverse()+" ";
                builder.setLength(0);
            }
        }

        reversed+=builder.reverse();

        return reversed.trim();
    }
}

// optimized solution

class Solution {
    public String reverseWords(String s) {
        String[] words=s.split("\s+");
        StringBuilder builder=new StringBuilder();
        int n=words.length-1;
        for(int i=n;i>=0;i--){
            builder.append(words[i]);
            if(i!=0) builder.append(" ");
        }
        return builder.toString().trim();
    }
}