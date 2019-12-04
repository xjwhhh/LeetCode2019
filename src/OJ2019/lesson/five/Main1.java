package OJ2019.lesson.five;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            int N=scan.nextInt();
            int P=scan.nextInt();
//            int[] startArray=new int[P];
//            int[] endArray=new int[P];
//            int[] diameterArray=new int[P];
            ArrayList<Integer> startArray=new ArrayList<>();
            ArrayList<Integer> endArray=new ArrayList<>();
            ArrayList<Integer> diameterArray=new ArrayList<>();
            for(int j=0;j<P;j++){
                startArray.add(scan.nextInt());
                endArray.add(scan.nextInt());
                diameterArray.add(scan.nextInt());

            }
            helper(startArray,endArray,diameterArray,N);
        }
        
        
    }
    
    private static void helper(ArrayList<Integer> start,ArrayList<Integer> end,ArrayList<Integer> diameter,int N){
        ArrayList<Integer> tank=new ArrayList<>();
        ArrayList<Integer> tap=new ArrayList<>();
        HashMap<Integer,Integer> hashMap=new HashMap<>();

        for(int i=0;i<start.size();i++){
            hashMap.put(start.get(i),end.get(i));
        }

        int resultNum=0;
        ArrayList<Integer> aArray=new ArrayList<>();
        ArrayList<Integer> bArray=new ArrayList<>();
        ArrayList<Integer> dArray=new ArrayList<>();
        for(int i=1;i<=N;i++){
            tank.add(i);
            tap.add(i);
        }
        for(int i=0;i<start.size();i++){
            tap.remove(new Integer(start.get(i)));
        }
        for(int i=0;i<end.size();i++){
            tank.remove(new Integer(end.get(i)));
        }
        for(int i=0;i<tank.size();i++){
//            System.out.println(tank.get(i));
        }
        for(int i=0;i<tap.size();i++){
//            System.out.println(tap.get(i));
        }
        for(int i=0;i<tank.size();i++){
            int a=tank.get(i);
//            System.out.println(a);
            int b=hashMap.get(a);
            if(tap.contains(b)){
                resultNum++;
                aArray.add(a);
                bArray.add(b);
                int index=start.indexOf(a);
                dArray.add(diameter.get(index));
                tap.remove(new Integer(b));
            }else{
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(diameter.get(i));
                int realA=a;
                while(!tap.contains(b)){
                    a=b;
                    b=hashMap.get(a);
                    int index=start.indexOf(a);
                    temp.add(diameter.get(index));
                }
                resultNum++;
                aArray.add(realA);
                bArray.add(b);
                Collections.sort(temp);
                dArray.add(temp.get(0));
                tap.remove(new Integer(b));
            }
        }
        System.out.println(resultNum);
        for(int i=0;i<resultNum;i++){
            System.out.print(aArray.get(i)+" ");
            System.out.print(bArray.get(i)+" ");
            System.out.println(dArray.get(i));
        }

    }
}
