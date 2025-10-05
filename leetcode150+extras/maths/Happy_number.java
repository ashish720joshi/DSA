class Solution {
    public boolean isHappy(int n) {
       Set<Integer>numberSet=new HashSet<>();
       while(n!=1 && !numberSet.contains(n)){
       numberSet.add(n);
       int sum=0;
       while(n>0){
          int digit=n%10;
          sum+=digit*digit;
          n=n/10;
       }
       n=sum;
       }
       return n==1;
    }
}