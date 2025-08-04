class Solution {
    private static int []dr={-1,1,0,0};
    private static int []dc={0,0,-1,1};
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,i,j,word,new boolean [board.length][board[0].length],0))
                return true;
            }
        }
        return false;
    }

    private boolean dfs(char [][]board,int row,int col,String word,boolean [][]visited,int index){
        int m=board.length;
        int n=board[0].length;

        if(index==word.length()) return true;

        if(row<0 || row>=m || col<0 || col>=n || visited[row][col]) return false;
        if(board[row][col]!=word.charAt(index)) return false;

        visited[row][col]=true;

        for(int i=0;i<4;i++){
            int adjRow=row+dr[i];
            int adjCol=col+dc[i];

            if(dfs(board,adjRow,adjCol,word,visited,index+1)){
                return true;
            }
        }

        visited[row][col]=false;
        return false;
    }
}