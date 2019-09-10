import java.util.Arrays;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {

        char[] ret = new char[num1.length() + num2.length()];
        Arrays.fill(ret, '0');

        for(int i = num1.length() - 1; i >= 0; i --) {
            int num1Val = num1.charAt(i) - '0';
            for(int j = num2.length() - 1; j >= 0; j --) {
                int num2Val = num2.charAt(j) - '0';
                int sum = (ret[i + j + 1] - '0') + num1Val * num2Val;
                ret[i + j + 1] = (char)(sum % 10 + '0');
                ret[i + j] += sum / 10;
            }
        }

        for(int i = 0; i < ret.length; i ++) {
            if(ret[i] != '0' || i == ret.length - 1) {
                return new String(ret, i, ret.length - i);
            }
        }

        return "0";
    }


}
