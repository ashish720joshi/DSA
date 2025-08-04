class Solution {
    List<String>result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
      String inputString="";
      backTrackParenthesis(0,0,inputString,n);
      return result;
    }

    private void backTrackParenthesis(int left,int right,String inputString,int n){
        if(left==n && right==n){
            result.add(new String(inputString));
            return;
        }
        if(left<n){
            backTrackParenthesis(left+1,right,inputString+"(",n);
        }
        if(right<left){
            backTrackParenthesis(left,right+1,inputString+")",n);
        }
    }

}

// efficient with StringBuilder

class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backTrackParenthesis(0, 0, new StringBuilder(), n);
        return result;
    }

    private void backTrackParenthesis(int left, int right, StringBuilder current, int n) {
        if (left == n && right == n) {
            result.add(current.toString());
            return;
        }

        if (left < n) {
            current.append('(');
            backTrackParenthesis(left + 1, right, current, n);
            current.deleteCharAt(current.length() - 1); // backtrack
        }

        if (right < left) {
            current.append(')');
            backTrackParenthesis(left, right + 1, current, n);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }
}
