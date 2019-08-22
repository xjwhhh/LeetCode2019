import java.util.ArrayList;

public class RepeatedSubstringPattern {
    public static  boolean repeatedSubstringPattern(String s) {
        if(s.equals("")||s.length()==1){
            return false;
        }
        ArrayList<String> array=new ArrayList<>();
        int length=s.length();

        int i=2;
        while(i<=length){
            if(length%i==0){
                int subLength=length/i;
                String tempA=s.substring(0,subLength);
                System.out.println("a:"+tempA);
                boolean result=true;
                for(int j=1;j<i;j++){
                    String tempB=s.substring(j*subLength,(j+1)*subLength);
                    System.out.println("b:"+tempB);
                    if(!tempB.equals(tempA)){
                        result=false;
                        break;
                    }
                }
                if(result){
                    return true;
                }

            }
            i++;
        }
        return false;

    }

    public static void main(String[] args){
        System.out.println(repeatedSubstringPattern("bb"));
    }
}
