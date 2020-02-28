package sword;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 10:50
 * @Email xjwhhh233@outlook.com
 */
public class Exist {

    boolean[][] marked;

    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int row;
    private int column;
    private String word;
    private char[][] board;



    public boolean exist(char[][] board, String word) {
        row=board.length;
        if(row==0){
            return false;
        }
        column=board[0].length;
        marked=new boolean[row][column];
        this.word=word;
        this.board=board;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i,int j,int index){
        if (index==word.length()-1){
            return board[i][j]==word.charAt(index);
        }
        if (board[i][j] == word.charAt(index)) {
            marked[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, index + 1)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;

    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < column;
    }

}
