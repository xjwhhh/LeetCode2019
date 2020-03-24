package spring2020.kuaishoubishi;

import java.util.*;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-22 18:57
 * @Email xjwhhh233@outlook.com
 */
public class Three {


    static class Value{
        public boolean baoZi=false;
        public boolean shunZi=false;
        public double baoZiNum=-1;
        public double shunZiNum=-2;

    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        ArrayList<String> arrayList=new ArrayList<>();
        String str=scanner.nextLine();
        String[] array=str.split(",");
//        for(int i=0;i<array.length;i++){
//            array[i]=array[i].substring(3);
//        }
        helper(array);
    }

    private static void helper(String[] array){
        HashMap<String,Value> hashMap=new HashMap<>();
        for(int i=0;i<array.length;i++){
            double baoZiNum=baoZi(array[i]);
            double shunZiNum=shunZi(array[i]);
//            System.out.println(baoZiNum);
//            System.out.println(shunZiNum);
            Value value=new Value();
            if(baoZiNum>=3){
                value.baoZi=true;
                value.baoZiNum=baoZiNum;
            }
            if(shunZiNum>=3){
                value.shunZi=true;
                value.shunZiNum=shunZiNum;
            }
            hashMap.put(array[i],value);
        }
        PriorityQueue<Map.Entry<String,Value>> priorityQueue=new PriorityQueue<>(new Comparator<Map.Entry<String, Value>>() {
            @Override
            public int compare(Map.Entry<String, Value> o1, Map.Entry<String, Value> o2) {
//                boolean o1Value=o1.getValue().baoZi||o1.getValue().shunZi;
//                boolean o2Value=o2.getValue().baoZi||o2.getValue().shunZi;
//                boolean o1BaoZi=o1.getValue().baoZi;
//                boolean o2BaoZi=o2.getValue().baoZi;
//                boolean o1ShunZi=o1.getValue().shunZi;
//                boolean o12ShunZi=o1.getValue().shunZi;
//                if(o1Value&&!o2Value){
//                    return 1;
//                }else if(!o1Value&&!o2Value){
//                    return 0;
//                }else if(o1Value&&o2Value){
//                    double o1Max=Math.max(o1.getValue().baoZiNum,o1.getValue().shunZiNum);
//                    double o2Max=Math.max(o2.getValue().baoZiNum,o2.getValue().shunZiNum);
////                    if(o1Max>o2Max){
////                        return 1;
////                    }else if(o1Max<o2Max){
////                        return -1;
////                    }else{
////                        if(o1.getValue().baoZiNum>o2.getValue())
////                    }
//                    if(o1Max>o2Max){
//                        return 1;
//                    }else if(o1Max<o2Max){
//                        return -1;
//                    }else{
//                        return 0;
//                    }
//                }
//                return 0;
                double o1Max=Math.max(o1.getValue().baoZiNum,o1.getValue().shunZiNum);
                double o2Max=Math.max(o2.getValue().baoZiNum,o2.getValue().shunZiNum);
//                    if(o1Max>o2Max){
//                        return 1;
//                    }else if(o1Max<o2Max){
//                        return -1;
//                    }else{
//                        if(o1.getValue().baoZiNum>o2.getValue())
//                    }
                if(o1Max>o2Max){
                    return -1;
                }else if(o1Max<o2Max){
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        for(Map.Entry<String,Value> entry:hashMap.entrySet()){
            boolean value=entry.getValue().baoZi||entry.getValue().shunZi;
            if(value) {
//                System.out.println(entry.getKey());
                double max=Math.max(entry.getValue().shunZiNum,entry.getValue().baoZiNum);
//                System.out.println(max);
                priorityQueue.add(entry);
            }
        }
//        for(int i=0;i<priorityQueue.size();i++){
//            System.out.println(priorityQueue);
//        }
//        Iterator<Map.Entry<String,Value>> iterator=priorityQueue.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next().getKey());
//        }
        if(!priorityQueue.isEmpty()) {
            StringBuilder stringBuilder=new StringBuilder();
            while (!priorityQueue.isEmpty()) {
                stringBuilder.append(priorityQueue.poll().getKey()).append(",");
            }
            System.out.println(stringBuilder.substring(0,stringBuilder.length()-1));
        }else{
            System.out.println("null");
        }

    }

    private static double baoZi(String number){
        double max=-1;
        for(int i=3;i<=number.length()-3;i++){
            double count=1.1;
            for(int j=i+1;j<number.length();j++){
                if(number.charAt(j)==number.charAt(j-1)){
                    count+=1.1;
                }else{
                    break;
                }
            }
            if(count>=3){
                max=Math.max(max,count);
            }
        }
        return max;
    }

    private static double shunZi(String number){
        double max=-1;
        for(int i=3;i<=number.length()-3;i++){
            double count=1;
            for(int j=i+1;j<number.length();j++){
                if(number.charAt(j)==number.charAt(j-1)+1){
                    count++;
                }else{
                    break;
                }
            }
            if(count>=3){
                max=Math.max(max,count);
            }
        }
        return max;
    }
}
