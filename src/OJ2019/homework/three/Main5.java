package OJ2019.homework.three;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Main5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String[] one=scan.nextLine().split(" ");
            int nodeNum=Integer.parseInt(one[0]);
            String start=one[1];
            String[] nodes=scan.nextLine().split(" ");
            String[][] matrix=new String[nodes.length+1][nodes.length];
            for(int j=0;j<nodes.length;j++){
                String[] temp=scan.nextLine().split(" ");
                matrix[j]=temp;
            }
            dfs(matrix,nodes,start);
        }
    }

    private static void dfs(String[][] matrix,String[] nodes,String start){

        int max=1;
        HashSet<String> visited=new HashSet<>();
        Stack<String> stack=new Stack<>();
        stack.push(start);
        visited.add(start);
        int depth=1;
        while(!stack.isEmpty()){
            start=stack.peek();
//            System.out.println(start);
            int startIndex=0;
            for(int i=0;i<nodes.length;i++){
                if(nodes[i].equals(start)){
                    startIndex=i;
                }
            }
            String[]row=matrix[startIndex];
            boolean flag=false;
            for(int i=0;i<row.length;i++){
                if(row[i].equals("1")&&!visited.contains(nodes[i-1])){
//                    System.out.println("tt"+nodes[i-1]);
                    stack.push(nodes[i-1]);
                    visited.add(nodes[i-1]);
                    flag=true;
                    depth++;
                    if(depth>max){
                        max=depth;
                    }
                    break;
                }
            }
            if(!flag){
                stack.pop();
                depth--;

            }

        }
        System.out.println(max);
        


    }
}
