import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        String kString=String.valueOf(K);
        List<Integer> result=new ArrayList<>();
        int carry=0;
        int i=A.length-1;
        int j=kString.length()-1;
        while (i>=0||j>=0){
            int n1=i>=0 ? A[i]:0;
            int n2=j >= 0 ? kString.charAt(j) - '0' : 0;
            int temp=n1+n2+carry;
            carry = temp / 10;
            result.add(0,temp % 10);
            i--; j--;

        }
        if(carry == 1) result.add(0,1);
        return result;

    }
}
