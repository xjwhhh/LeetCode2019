package onefourseven;

public class Tribonacci {
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int n0=0;
        int n1=1;
        int n2=1;
        int result=0;
        for(int i=3;i<=n;i++){
            result=n0+n1+n2;
            n0=n1;
            n1=n2;
            n2=result;
        }

        return result;


    }

}
