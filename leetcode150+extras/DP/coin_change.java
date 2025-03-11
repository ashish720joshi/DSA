// Memoization approach

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int [][]dp=new int[coins.length][amount+1];
        for(int []a:dp){
            Arrays.fill(a,-1);
        }
        int min=coinChangeRecur(coins,amount,coins.length-1,dp);
        return min>=(int) Math.pow(10, 9)?-1:min;
    }

    public int coinChangeRecur(int []coins,int amount,int index,int [][]dp){
        if(index==0){
            if(amount%coins[index]==0)return amount/coins[index];
            else return (int) Math.pow(10, 9);
        }
        if(dp[index][amount]!=-1) return dp[index][amount];
        int take=(int) Math.pow(10, 9),notTake=0;
        if(amount>=coins[index]){
            take=1+coinChangeRecur(coins,amount-coins[index],index,dp);
        }
        notTake=coinChangeRecur(coins,amount,index-1,dp);
        return dp[index][amount]=Math.min(take,notTake);
    }
}

//Tabulation approach


class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int [][]dp=new int[coins.length][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)
              dp[0][i]=i/coins[0];
            else
              dp[0][i]=(int)Math.pow(10,9);
        }

        for(int i=1;i<coins.length;i++){
            for(int target=0;target<=amount;target++){
                int take=(int)Math.pow(10,9);
                if(target>=coins[i]){
                    take=1+dp[i][target-coins[i]];
                }
                int notTake=dp[i-1][target];
                dp[i][target]=Math.min(take,notTake);
            }
        }
        
        if(dp[coins.length-1][amount]>=(int)Math.pow(10,9)) return -1;
        return dp[coins.length-1][amount];
    }
}