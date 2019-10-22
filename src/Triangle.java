import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row=triangle.size();
        int[] result=new int[row+1];
        for(int i=row-1;i>=0;i--){
            for(int j=0;j<=i;j++){
                result[j]=Math.min(result[j],result[j+1])+triangle.get(i).get(j);
            }
        }

        return result[0];

    }
}
