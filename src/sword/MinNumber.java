package sword;

import com.sun.tools.javac.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author JiaWei Xu
 * @Date 2020-02-29 16:10
 * @Email xjwhhh233@outlook.com
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        ArrayList<String> array= new ArrayList<>();
        for(int num:nums){
            array.add(String.valueOf(num));
        }
        array.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : array) {
            sb.append(str);
        }
        return sb.toString();



    }
}
