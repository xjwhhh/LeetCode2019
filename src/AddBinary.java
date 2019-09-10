public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder("");
        int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;
        while (i>=0||j>=0){
            int n1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 2;
            res.append(tmp % 2);
            i--; j--;
        }
        if(carry==1){
            res.append(1);
        }
        return res.reverse().toString();

    }
}
