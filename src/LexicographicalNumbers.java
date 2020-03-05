import java.util.ArrayList;
import java.util.List;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-04 19:38
 * @Email xjwhhh233@outlook.com
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<10;i++){
            if(i<=n){
                res.add(i);
                helper(res,i,n);
            }else{
                break;
            }
        }
        return res;
    }

    private void helper(List<Integer> res,int current,int max){
        current=current*10;
        for(int i=0;i<10;i++){
            if(current+i<=max){
                res.add(current+i);
                helper(res,current+i,max);
            }else{
                break;
            }
        }
    }
}
