import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> prevRow=new ArrayList<>();
        prevRow.add(1);
        if(rowIndex==0){
            return prevRow;
        }

        for(int i=1;i<=rowIndex;i++){
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(prevRow.get(j-1)+prevRow.get(j));
            }
            row.add(1);
            prevRow=row;
        }

        return prevRow;

    }




}
