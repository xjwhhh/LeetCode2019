import java.util.ArrayList;
import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-03 14:08
 * @Email xjwhhh233@outlook.com
 */
public class ZigZagConversion {
    public static  String convert(String s, int numRows) {
        if(s==null||s.length()==0){
            return "";
        }
        if(numRows==1){
            return s;
        }

        String[][] array=new String[numRows][s.length()];
        int index=0;
        int row=0;
        int column=0;
        while(index<s.length()){
            if(column%(numRows-1)==0){
                if(row<numRows){
                    array[row++][column]=String.valueOf(s.charAt(index++));
                }else{
                    row-=2;
                    column++;
                }
            }else{
                if(row>0) {
                    array[row--][column++] =String.valueOf(s.charAt(index++));
                }
            }
        }
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(array[i][j]!=null){
                    stringBuilder.append(array[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static  String convert1(String s, int numRows) {
        if(s==null||s.length()==0){
            return "";
        }
        if(numRows==1){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int row=0;
        int flag=-1;
        for(int i=0;i<s.length();i++){
            rows.get(row).append(s.charAt(i));
            if(row==0||row==numRows-1){
                flag=-flag;
            }
            row+=flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder t : rows) res.append(t);
        return res.toString();

    }

    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING",
                3));
    }
}
