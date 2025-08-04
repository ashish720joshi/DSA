class Solution {
    private List<Integer> [] graph;
    private int []bobTime;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n=amount.length;
        graph=new ArrayList[n];
        bobTime=new int[n];
        Arrays.fill(bobTime,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int []edge:edges){
            int u=edge[0];
            int v=edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        findBobTime(bob,-1,0);
        return dfs(0,-1,0,amount);

    }

    private boolean findBobTime(int node,int parent,int time){
        if(node==0){
          bobTime[node]=time;
          return true;
        }
        for(int neighbour:graph[node]){
            if(neighbour!=parent){
                if(findBobTime(neighbour,node,time+1)){
                    bobTime[node]=time;
                    return true;
                }
            }
        }
        return false;
    }

    private int dfs(int node,int parent,int time,int []amount){
        int profit;

        if(time<bobTime[node]){
            profit=amount[node];
        }else if(time==bobTime[node]){
            profit=amount[node]/2;
        }else{
            profit=0;
        }
        int maxChildProfit=Integer.MIN_VALUE;
        boolean isLeafNode=true;

        for(int neighbour:graph[node]){
            if(neighbour!=parent){
                isLeafNode=false;
                int childProfit=dfs(neighbour,node,time+1,amount);
                maxChildProfit=Math.max(childProfit,maxChildProfit);
            }
        }

        if(isLeafNode) return profit;
        return profit+maxChildProfit;
    }
}


//proper comments code below

import java.util.*;

class Solution {
    private List<Integer>[] graph;  // Adjacency list to store the tree
    private int[] bobTime;          // bobTime[i] = time when Bob reaches node i

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;

        // Initialize graph and bobTime array
        graph = new ArrayList[n];
        bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE); // default: Bob never reaches

        // Build graph (tree) from edge list
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // Step 1: Backtrack from Bob to root (node 0), record his arrival time at each node
        findBobTime(bob, -1, 0);

        // Step 2: DFS from node 0 (you), calculate max profit along any root-to-leaf path
        return dfs(0, -1, 0, amount);
    }

    // Helper method to record the time at which Bob reaches each node on his path to node 0
    private boolean findBobTime(int node, int parent, int time) {
        if (node == 0) {
            bobTime[node] = time;
            return true;
        }

        for (int neighbour : graph[node]) {
            if (neighbour != parent) {
                // DFS to find path from Bob to node 0
                if (findBobTime(neighbour, node, time + 1)) {
                    bobTime[node] = time;  // Bob passed through this node
                    return true;
                }
            }
        }
        return false;  // node is not on Bob's path to 0
    }

    // DFS to explore all root-to-leaf paths and compute the max profit
    private int dfs(int node, int parent, int time, int[] amount) {
        int profit;

        // Calculate profit at the current node based on arrival times
        if (time < bobTime[node]) {
            profit = amount[node];            // You arrive before Bob
        } else if (time == bobTime[node]) {
            profit = amount[node] / 2;        // You and Bob arrive at the same time
        } else {
            profit = 0;                       // Bob already took the value
        }

        int maxChildProfit = Integer.MIN_VALUE;
        boolean isLeafNode = true;

        // Recur on all children
        for (int neighbour : graph[node]) {
            if (neighbour != parent) {
                isLeafNode = false;
                int childProfit = dfs(neighbour, node, time + 1, amount);
                maxChildProfit = Math.max(childProfit, maxChildProfit);  // best path from current node
            }
        }

        // If it's a leaf, just return the current profit
        if (isLeafNode) return profit;

        // Else add the best child path profit
        return profit + maxChildProfit;
    }
}
