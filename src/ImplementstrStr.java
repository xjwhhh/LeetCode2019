public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if(needle.equals("")){
            return 0;
        }
        int length=needle.length();
        int start=0;
        while(start+length<=haystack.length()){
            if(haystack.substring(start,length).equals(needle)){
                return start;
            }
            start++;
        }
        return -1;

    }
}
