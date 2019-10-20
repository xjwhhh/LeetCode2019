public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n<=0){
            return 0;
        }
        else if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        int[] array=new int[n+1];
        array[0]=0;
        array[1]=1;
        array[2]=2;
        for(int i=3;i<=n;i++){
            array[i]=array[i-1]+array[i-2]+1;
        }
        return array[n];

    }
}
