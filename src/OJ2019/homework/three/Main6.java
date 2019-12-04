package OJ2019.homework.three;

import java.util.*;

public class Main6 {
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
            bfs(matrix,nodes,start);
        }
    }

    private static void bfs(String[][] matrix,String[] nodes,String start){
        ArrayList<String> visited=new ArrayList<>();
        Queue<String> queue=new LinkedList<>();
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()){
            start=queue.peek();
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
                    queue.add(nodes[i-1]);
                    visited.add(nodes[i-1]);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                queue.remove();
            }

        }

        StringBuilder str=new StringBuilder();
        for(int i=0;i<visited.size();i++){
            str.append(visited.get(i)+" ");
        }
        str.deleteCharAt(str.length()-1);
        System.out.println(str);
    }
}
