class Solution {
    List<String>list=new ArrayList<>();
    Map<String,String>map=new HashMap<>();
    public List<String> letterCombinations(String digits) {
   
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        letterCombinationRecur(0,"",digits);
        return list;

    }

    private void letterCombinationRecur(int index,String combo,String digits){
        if(combo.length()==digits.length()){
            if(combo.length()!=0) list.add(combo);
            return;
        }
        String letters=map.get(Character.toString(digits.charAt(index)));
        char []letterArray=letters.toCharArray();
        for(char a:letterArray){
            letterCombinationRecur(index+1,combo+String.valueOf(a),digits);
        }
    }
}