package sword;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-28 15:12
 * @Email xjwhhh233@outlook.com
 */
public class MinStack {
    /** initialize your data structure here. */

    ArrayList<Integer> arrayList;
    Stack<Integer> minStack;

    public MinStack() {
        arrayList=new ArrayList<>();
        minStack=new Stack<>();

    }

    public void push(int x) {
        arrayList.add(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            if(minStack.peek()>x){
                minStack.push(x);
            }else{
                minStack.push(minStack.peek());
            }
        }
//        System.out.println(x);

    }

    public void pop() {
        minStack.pop();
        arrayList.remove(arrayList.size()-1);
    }

    public int top() {
        return arrayList.get(arrayList.size()-1);
    }

    public int min() {
        return minStack.peek();

    }
}
