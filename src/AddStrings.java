public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0;
        int len=Math.max(i,j)+2;
        int[] res=new int[len];
        int count=0;
        while(i>=0&&j>=0){
            int temp=Integer.parseInt(String.valueOf(num1.charAt(i)))+Integer.parseInt(String.valueOf(num2.charAt(j)))+carry;
            if(temp>=10){
                temp-=10;
                carry=1;
            }else{
                carry=0;
            }
            count++;
            res[len-count]=temp;
            i--;
            j--;
        }
        if(i==-1&&j!=-1){
            for(int k=j;k>=0;k--){
                int temp=Integer.parseInt(String.valueOf(num2.charAt(j)))+carry;
                if(temp>=10){
                    temp-=10;
                    carry=1;
                }else{
                    carry=0;
                }
                count++;
                res[len-count]=temp;
            }
        }
        if(j==-1&&i!=-1){
            for(int k=i;k>=0;k--){
                int temp=Integer.parseInt(String.valueOf(num1.charAt(i)))+carry;
                if(temp>=10){
                    temp-=10;
                    carry=1;
                }else{
                    carry=0;
                }
                count++;
                res[len-count]=temp;
            }
        }
        count++;
        res[len-count]=carry;

        String result="";
        if(res.length>0&&res[0]!=0){
            result+=res[0];
        }
        for(int k=1;k<res.length;k++){
            result+=res[k];
        }

        return result;
    }

    public String addStrings1(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--; j--;
        }
        if(carry == 1) res.append(1);
        return res.reverse().toString();
    }


}
