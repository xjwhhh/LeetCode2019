package OJ2019.homework.three;

import java.util.*;

public class Main77 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String str = scan.nextLine();
            String[] edge=str.split(",");
//            ArrayList<Node> arrayList=new ArrayList<>();
            ArrayList<String> arrayList=new ArrayList<>();
            HashMap<String, Node> hashMap=new HashMap<>();
            for(int j=0;j<edge.length;j++){
                String[] nodes=edge[j].split(" ");
                String node1=nodes[0];
                String node2=nodes[1];
                if(!arrayList.contains(node1)){
                    arrayList.add(node1);
                }
                if(!arrayList.contains(node2)){
                    arrayList.add(node2);
                }

            }
            String[][] graph=new String[arrayList.size()][arrayList.size()];
            for(int j=0;j<edge.length;j++){
                String[] nodes=edge[j].split(" ");
                String node1=nodes[0];
                String node2=nodes[1];
                int index1=arrayList.indexOf(node1);
                int index2=arrayList.indexOf(node2);

            }





        }
    }
}
