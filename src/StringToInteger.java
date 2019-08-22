public class StringToInteger {
    public static int myAtoi(String str) {
        if(str==""){
            return 0;
        }
        int i=0;
        boolean positive=true;
        long temp=0;
        while(i<str.length()){
            if(str.charAt(i)=='-'){
                positive=false;
                break;
            }else if(str.charAt(i)=='+'){
                break;
            }else if(Character.isDigit(str.charAt(i))){
                temp=Long.parseLong(String.valueOf(str.charAt(i)));
                break;
            }
            i++;
        }
        i++;
        while(i<str.length()){
            if(Character.isDigit(str.charAt(i))){
                temp=temp*10+Long.parseLong(String.valueOf(str.charAt(i)));
                i++;
            }else{
                break;
            }
        }
        if (positive&&temp>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(!positive&&-temp<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(positive) {
            return (int) temp;
        }else{
            return (int)(-temp);
        }


    }

    public static  void main(String[] args){
        System.out.println(myAtoi("\"words and 987\""));
    }
}
