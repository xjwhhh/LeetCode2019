package OJ2019.homework.reviewer;

import java.util.Scanner;

public class mat_2 {
//    public static void main (String[] args) {
//        final String PAT = "12345$54321";
//
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        while (t-- > 0) {
//            long pos = in.nextLong();
//            if (pos == 0) {
//                System.out.println("");
//                continue;
//            }
//
//            while (pos > PAT.length()) {
//                long[] iter = findIter(pos);
//                long start = (iter[0]+iter[1]) / 2;
//                pos -= start;
//            }
//            char res;
//            if (pos <= 0) {
//                res = '$';
//            } else {
//                res = PAT.charAt((int)pos-1);
//            }
//            System.out.println(res);
//        }
//    }
//
//    private static long[] findIter(long pos) {
//        long len = 5;
//        int it = 0;
//        while (pos > len) {
//            it++;
//            len = 2*len + it;
//        }
//        return new long[] {len, it};
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < num; i++) {
            long pos=scan.nextLong();
            helper(pos);
        }
    }

    private static void helper(long pos){
        String str="12345$54321";
        while(pos>str.length()){
            long[] res=find(pos);
            long cur=res[0];
            long iNum=res[1];
            long pre=(cur-iNum)/2;
            if(pos<=pre+iNum){
                System.out.println("$");
                return;
            }else{
                pos-=(pre+iNum);
            }

        }
        System.out.println(str.charAt((int) (pos-1)));
    }

    private static long[] find(long pos){
        long len=5;
        int iNum=0;
        while(true){
            if(pos<=len){
                return new long[]{len,iNum};
            }
            iNum++;
            len=len*2+iNum;
        }
    }
}
