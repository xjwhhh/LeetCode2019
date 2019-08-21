public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.length()==0){
            return true;
        }
        char[] array=s.toCharArray();
        int left=0;
        int right=array.length-1;
        while(left<right){
            char leftChar=array[left];
            char rightChar=array[right];
            if(!Character.isLetter(leftChar)&&!Character.isDigit(array[left])){
                left++;
                continue;
            }
            if(!Character.isLetter(rightChar)&&!Character.isDigit(rightChar)){
                right--;
                continue;
            }
            if(Character.isDigit(leftChar)&&Character.isLetter(rightChar)){
                return false;
            }
            if(Character.isDigit(rightChar)&&Character.isLetter(leftChar)){
                return false;
            }
            if(Character.isLetter(leftChar)&&Character.isLetter(rightChar)){
                if(!(String.valueOf(leftChar).toUpperCase().equals(String.valueOf(rightChar).toUpperCase()))){
                    return false;
                }
            }else if(!(String.valueOf(leftChar).equals(String.valueOf(rightChar)))){
                return false;
            }
            left++;
            right--;


        }
        return true;

    }

    private boolean isAlpha(char s){
        if((s<='z'&&s>='a')||s<='Z'&&s>='A'){
            return true;
        }
        return false;
    }
}
