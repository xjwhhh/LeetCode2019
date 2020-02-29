package sword;

import java.util.*;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 15:09
 * @Email xjwhhh233@outlook.com
 */
public class Permutation {
    Set<String> result = new HashSet<>();
    public String[] permutation(String s) {
        if(s == null) return new String[]{};
        boolean[] visited = new boolean[s.length()];
        process(s, "", visited);
        return result.toArray(new String[result.size()]);
    }

    private void process(String s, String letter, boolean[] visited){
        if(s.length() == letter.length()){
            result.add(letter);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(visited[i]) continue;
            visited[i] = true;
            process(s, letter + temp, visited);
            visited[i] = false;
        }
    }



}
