import java.util.ArrayList;
import java.util.Set;

public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> t=new ArrayList<>();
        display(root,t);
        int a=0;
        int b=t.size()-1;
        while(a<b){
            if(t.get(a)+t.get(b)==k){
                return true;
            }else if(t.get(a)+t.get(b)<k){
                a++;
            }else if(t.get(a)+t.get(b)>k){
                b--;
            }
        }
        return false;

    }

    public void display(TreeNode root, ArrayList<Integer> a){

        if(root.left!=null) {
            display(root.left,a);
        }
        a.add(root.val);
        if(root.right!=null){
            display(root.right,a);
        }
    }

}
