public class CountAndSay {
    public static String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            res = next_time(res);
            System.out.println(res);
        }
        return res;
    }

    public static String next_time(String s){
        int i=0;
        int length=s.length();
        String res="";
        while(i<length){
            int count=1;
            while((i<length-1)&&(s.charAt(i)==s.charAt(i+1))){
                i++;
                count++;
            }
            res+=(count+""+s.charAt(i));
            i++;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(countAndSay(4));
    }
}
