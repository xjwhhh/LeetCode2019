import java.util.HashMap;

public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int[] num=new int[121];
        int result=0;
        for(int i=0;i<ages.length;i++){
            num[ages[i]]++;
        }
        for(int i=0;i<121;i++){
            int countA=num[i];
            for(int j=0;j<121;j++){
                int countB=num[j];
                if(i*0.5+7>=j){
                    continue;
                }
                if(i<j){
                    continue;
                }
                if(i<100&&j>100){
                    continue;
                }
                result+=countA*countB;
                if(i==j){
                    result-=countA;
                }



            }
        }
        return result;


    }
}
