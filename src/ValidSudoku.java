import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){

            if(!helper1(board[i])){
                System.out.println("1");
                return false;
            }
        }
        for(int i=0;i<9;i++){
            ArrayList<Character> temp=new ArrayList<>();
            for(int j=0;j<9;j++) {
                temp.add(board[j][i]);
            }
            if(!helper(temp)){
                System.out.println("2");
                return false;
            }
        }

        int low=0;
        int high=3;
        for(int column=0;column<3;column++) {
            int left=0;
            int right=3;
            for (int row = 0; row < 3; row++) {
                ArrayList<Character> temp=new ArrayList<>();


                for (int i = left; i < right; i++) {
                    for (int j = low; j < high; j++) {
                        temp.add(board[j][i]);
                    }

                    if (!helper(temp)) {
                        System.out.println(row);
                        System.out.println(column);
                        for(int k=0;k<temp.size();k++){
                            System.out.print(temp.get(k));
                        }
                        System.out.println("");

                        System.out.println("3");
                        return false;
                    }
                }
                left += 3;
                right += 3;
            }
            low+=3;
            high+=3;
        }

        return true;




    }

    public boolean helper(ArrayList<Character> board){
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<board.size();i++){
            char temp=board.get(i);
            // System.out.println(temp);
            if('1'<=temp&&temp<='9'||temp=='.') {
                hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
            }else{
                System.out.println(temp);
                System.out.println("4");
                return false;
            }
        }
        for(Map.Entry<Character,Integer> entry:hashMap.entrySet()){
            if(('1'<=entry.getKey()&&entry.getKey()<='9')&&entry.getValue()>1){
                System.out.println("5");
                return false;
            }
        }
        return true;

    }

    public boolean helper1(char[] board){
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<board.length;i++){
            char temp=board[i];
            // System.out.println(temp);
            if('1'<=temp&&temp<='9'||temp=='.') {
                hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
            }else{
                System.out.println(temp);
                System.out.println("4");
                return false;
            }
        }
        for(Map.Entry<Character,Integer> entry:hashMap.entrySet()){
            if(('1'<=entry.getKey()&&entry.getKey()<='9')&&entry.getValue()>1){
                System.out.println("5");
                return false;
            }
        }
        return true;

    }

    //一次迭代，全部判断
    public boolean isValidSudoku1(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }

}
