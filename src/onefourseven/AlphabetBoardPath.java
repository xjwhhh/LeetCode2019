package onefourseven;

import java.util.HashMap;

public class AlphabetBoardPath {
    public String alphabetBoardPath(String target) {
        String [][] board={{"a","b","c","d","e"},
                {"f","g","h","i","j"},
                {"k","l","m","n","o"},
                {"p","q","r","s","t"},
                {"u","v","w","x","y"},
                {"z"}
        };
        String [] board1=new String[26];
        int index=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                board1[index]=board[i][j];
                index++;
            }
        }
        board1[index]="z";
        String result="";
        target="a"+target;
        for(int i=0;i<target.length()-1;i++){
            String from=String.valueOf(target.charAt(i));
            String to=String.valueOf(target.charAt(i+1));
            int index1=getIndex(board1,from);
            int index2=getIndex(board1,to);
            int[] index3=getTwoIndex(index1);
            int[] index4=getTwoIndex(index2);
            int x1=index3[0];
            int y1=index3[1];
            int x2=index4[0];
            int y2=index4[1];
            if(from.equals("z")&&!to.equals("z")){
                result=resulty(y1,y2,result);
                result=resultx(x1,x2,result);
            }else{
                result=resultx(x1,x2,result);
                result=resulty(y1,y2,result);
            }

            result+="!";
        }
        return result;

    }

    public  int getIndex(String[] array,String a){
        for(int j=0;j<array.length;j++){
            if(a.equals(array[j])){
                return j;
            }
        }
        return 0;

    }

    public int[] getTwoIndex(int a){
        int x=a%5;
        int y=a/5;
        return new int[]{x,y};
    }

    public String resultx(int x1,int x2,String result){
        if(x1<=x2){
            int count=x2-x1;
            for(int j=0;j<count;j++){
                result+="R";
            }
        }else{
            int count=x1-x2;
            for(int j=0;j<count;j++){
                result+="L";
            }
        }
        return result;
    }

    public String resulty(int y1,int y2,String result){
        if(y1<=y2){
            int count=y2-y1;
            for(int j=0;j<count;j++){
                result+="D";
            }
        }else{
            int count=y1-y2;
            for(int j=0;j<count;j++){
                result+="U";
            }
        }
        return result;
    }
}
