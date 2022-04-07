class p79{
    private String word;
    private char[][] board;
    private boolean[][] visited;
    private int m,n,k;
    public boolean exist(char[][] board, String word){
        this.m=board.length;
        if(m==0){return false;}
        else{
            n=board[0].length;
        }
        if(word.length()>m*n){ return false;}
        this.k=word.length();
        this.word=word;
        this.board=board;
        this.visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(backtrack(i, j, 0)){return true;}
            }
        }
        return false;
    }
    private boolean backtrack(int i,int j,int index){
        if(index<k && i<m && j<n && i>=0 && j>=0){
            if(board[i][j]!=word.charAt(index) || visited[i][j]==true){
                return false;
            }
            if(index==k-1){
                return true;
            }
            visited[i][j]=true;
            if(backtrack(--i, j, index+1)){return true;}
            if(backtrack(++i, --j, index+1)){return true;}
            if(backtrack(++i, ++j, index+1)){return true;}
            if(backtrack(--i, ++j, index+1)){return true;}
            visited[i][--j]=false;
            return false;
        }else{
            return false;
        }
    }
}