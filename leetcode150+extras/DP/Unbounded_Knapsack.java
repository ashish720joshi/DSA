class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        int [][]dp=new int[wt.length][capacity+1];
        for(int []a:dp){
            Arrays.fill(a,-1);
        }
        return knapSackRecur(val,wt,capacity,wt.length-1,dp);
    }
    
    static int knapSackRecur(int [] val,int [] wt,int capacity,int index,int [][]dp){
        if(index==0){
          return((int)(capacity/wt[0]))*val[0];
        } 
        if(dp[index][capacity]!=-1) return dp[index][capacity];

        int take=Integer.MIN_VALUE,notTake=0;
        if(capacity>=wt[index]){
            take=val[index]+knapSackRecur(val,wt,capacity-wt[index],index,dp);
        }
        notTake=knapSackRecur(val,wt,capacity,index-1,dp);
        return dp[index][capacity]=Math.max(take,notTake);
    }
}