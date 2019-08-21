import java.util.ArrayList;
import java.util.Arrays;

public class MinStack {

    ArrayList<Integer> array;


    /** initialize your data structure here. */
    public MinStack() {
        array = new ArrayList<>();
    }

    public void push(int x) {
       array.add(x);

    }

    public void pop() {
      array.remove(array.size()-1);
    }

    public int top() {
        return array.get(array.size()-1);
    }

    public int getMin() {
        Integer [] a=(Integer[])array.toArray(new Integer[array.size()]);
        Arrays.sort(a);
        if (a.length > 0) {
            return a[0];
        }else{
            return Integer.MIN_VALUE;
        }
    }

    //思路二：使用辅助栈
}
