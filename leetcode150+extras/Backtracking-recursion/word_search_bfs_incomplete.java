class Solution {
    static int [] dr={-1,1,0,0};
    static int [] dc={0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(wordSearchBFS(board,m,n,new Pair(i,j),word)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wordSearchBFS(char [][]board,int m,int n,Pair start,String word){
        class Node{
            int row,col,index;
            int [][]visited;
        }
        Queue<Pair>queue=new LinkedList<>();
        queue.offer(start);
        int index=1;
        Set<Pair>visited=new Pair();
        while(!queue.isEmpty()){
            Pair pair=queue.poll();
            char c=word.charAt(index);
            if(index==word.length()) return true;
            int row=(int)pair.first;
            int col=(int)pair.second;
            for(int i=0;i<4;i++){
                int adjX=row+dr[i];
                int adjY=col+dc[i];
                if(adjX>=0 && adjY>=0 && adjX<m && adjY<n && board[adjX][adjY]==c && visited.contains()){
                    Pair newP=new Pair(adjX,adjY);
                    queue.offer(newP);
                    visited.add(newP)
                    index++;
                }
            }
        }
        return false;
    }
}

public class Pair<K,V>{
    public K first;
    public V second;

    Pair(K first,V second){
        this.first=first;
        this.second=second;
    }
}
