package sword;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-02 11:27
 * @Email xjwhhh233@outlook.com
 */
class MaxQueue {
    private LinkedList<Integer> data;
    private LinkedList<Integer> maxQue;
    public MaxQueue() {
        data = new LinkedList<>();
        maxQue = new LinkedList<>();
        maxQue.addLast(Integer.MIN_VALUE);
    }

    public int max_value() {
        if(data.isEmpty()){
            return -1;
        }
        return maxQue.peekFirst();
    }

    public void push_back(int value) {
        data.addLast(value);
        while(!maxQue.isEmpty() && maxQue.peekLast() < value){
            maxQue.removeLast();
        }
        maxQue.addLast(value);
    }

    public int pop_front() {
        if(data.isEmpty()) return -1;
        int front = data.removeFirst();
        if(maxQue.peekFirst() == front){
            maxQue.removeFirst();
        }
        return front;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */


