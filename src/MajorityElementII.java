import java.util.*;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result=new ArrayList<>();
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int t=nums[i];
            int count=hashMap.getOrDefault(t,0)+1;
//            if(count>nums.length/3){
//                result.add(t);
//            }
            hashMap.put(t,count);
        }
        for(Map.Entry<Integer,Integer> entry:hashMap.entrySet()){
            if(entry.getValue()>nums.length/3){
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public List<Integer> majorityElement1(int[] nums) {
        List<Integer> result=new ArrayList<>();
        if(nums==null||nums.length==0){
            return result;
        }
        int count1,count2,num1,num2;
        num1=num2=0;
        count1=nums[0];
        count2=nums[0];
        for(int num:nums){
            if(num==num1){
                count1++;
                continue;
            }
            if(num==num2){
                count2++;
                continue;
            }
            if(count1==0){
                num1=num;
                count1++;
                continue;
            }
            if(count2==0){
                num2=num;
                count2++;
                continue;
            }
            count1--;
            count2--;


        }
        count1=count2=0;
        for(int num:nums){
            if(num==num1){
                count1++;
            }else if(num==num2){
                count2++;
            }

        }
        if(count1>nums.length/3){
            result.add(num1);
        }
        if(count2>nums.length/3){
            result.add(num2);
        }
        return result;


    }
}
