import java.util.HashSet;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-05 16:17
 * @Email xjwhhh233@outlook.com
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hashSet=new HashSet<>();
        for(String email:emails){
            String[] temp=email.split("@");
            String local=temp[0];
            String domain=temp[1];
            int index=local.indexOf("+");
            if(index!=-1){
                local=local.substring(0,index);
                System.out.println(local);
            }
            //以.为分隔符，需要加\\
            //或者使用replaceAll，将.进行替换
            String[] temp2=local.split("\\.");
            System.out.println(temp2.length);
            StringBuilder stringBuilder=new StringBuilder();
            for(String str:temp2){
                stringBuilder.append(str);
            }
            stringBuilder.append("@").append(domain);
            System.out.println(stringBuilder.toString());
            hashSet.add(stringBuilder.toString());

        }
        return hashSet.size();

    }
}
