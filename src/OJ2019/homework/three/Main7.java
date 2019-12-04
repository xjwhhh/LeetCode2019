package OJ2019.homework.three;

import java.util.*;

class Node {
    int in=0;
    int out=0;
    String value;
    List<String> inArray=new ArrayList<>();
    List<String> outArray=new ArrayList<>();
}


public class Main7 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            String str = scan.nextLine();
            String[] edge=str.split(",");
            ArrayList<Node> arrayList=new ArrayList<>();
            HashMap<String, Node> hashMap=new HashMap<>();
            for(int j=0;j<edge.length;j++){
                String[] nodes=edge[j].split(" ");
                String node1=nodes[0];
                String node2=nodes[1];
                construct(node1,node2,arrayList,hashMap);
            }



        }
    }

    private static void topo(ArrayList<Node> arrayList,HashMap<String, Node> hashMap){
        HashMap<Integer,HashSet<Node>> inMap=new HashMap<>();
        for(Map.Entry<String,Node> entry:hashMap.entrySet()){
            int in=entry.getValue().in;
            HashSet<Node> hashSet=new HashSet<>();
            if(inMap.containsKey(in)){
                hashSet=inMap.get(in);
            }
            hashSet.add(entry.getValue());
            inMap.put(in,hashSet);
        }
    }

    private static void helper(HashMap<Integer,HashSet<Node>> inMap,ArrayList<Node> arrayList){
//        while()

    }

    private static void construct(String nodeStr1,String nodeStr2, ArrayList<Node> arrayList, HashMap<String, Node> hashMap){
        Node node1 = new Node();
        Node node2 = new Node();
        if(hashMap.containsKey(nodeStr1)) {
            node1 = hashMap.get(nodeStr1);
        }
        if(hashMap.containsKey(nodeStr2)) {
            node2 = hashMap.get(nodeStr2);
        }

        node1.out++;
        node1.outArray.add(nodeStr2);
        hashMap.put(nodeStr1,node1);

        node2.in--;
        node2.inArray.add(nodeStr1);
        hashMap.put(nodeStr2,node2);



    }
}
