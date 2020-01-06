import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author JiaWei Xu
 * @Date 2020-01-06 15:57
 * @Email xjwhhh233@outlook.com
 */
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> hashMap=new HashMap<>();
        for(String cpdomain:cpdomains){
            String[] temp=cpdomain.split(" ");
            int count=Integer.parseInt(temp[0]);
            String domains=temp[1];
//            String[] domainList=domains.split("\\.");
            while (domains.contains(".")){
                int index=domains.indexOf(".");
                hashMap.put(domains,hashMap.getOrDefault(domains,0)+count);
                domains=domains.substring(index+1);
//                System.out.println(domains);
            }
            hashMap.put(domains,hashMap.getOrDefault(domains,0)+count);
        }
        List<String> result=new ArrayList<>();
        for(Map.Entry<String,Integer> entry:hashMap.entrySet()){
            result.add(entry.getValue()+" "+entry.getKey());
        }
        return result;


    }
}
