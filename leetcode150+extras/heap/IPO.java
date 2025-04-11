class Solution {
    static class Project{
        int capital;
        int profit;
        Project(int capital,int profit){
            this.capital=capital;
            this.profit=profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital){
        List<Project>projects=new ArrayList<>();
        PriorityQueue<Project>minCapitalHeap=new PriorityQueue<>(Comparator.comparingInt(p->p.capital));
        for(int i=0;i<capital.length;i++){
            minCapitalHeap.offer(new Project(capital[i],profits[i]));
        }

        PriorityQueue<Integer>maxProfitsHeap=new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0;i<k;i++){
            while(!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital<=w){
             maxProfitsHeap.offer(minCapitalHeap.poll().profit);   
            }

            if(maxProfitsHeap.isEmpty()) break;
            w+=maxProfitsHeap.poll();
        }
        return w;
    }
}