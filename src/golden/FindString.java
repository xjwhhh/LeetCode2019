package golden;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-03 11:15
 * @Email xjwhhh233@outlook.com
 */
public class FindString {
    public int findString(String[] words, String s) {
        if(words==null||words.length==0){
            return -1;
        }
        return binarySearch(words,s,0,words.length-1);
    }

    private int binarySearch(String[] words,String s,int left,int right){
        if(left>right){
            return -1;
        }
        int mid=(left+right)>>2;
        if(words[mid].equals(s)){
            return mid;
        }
        if(words[mid].equals(" ")){
            int l=binarySearch(words,s,left,mid-1);
            int r=binarySearch(words,s,mid+1,right);
            if(l!=-1){
                return l;
            }
            return r;
        }else{
            if(words[mid].compareTo(s)<0){
                System.out.println(mid+1);
                System.out.println(right);
                return binarySearch(words,s,mid+1,right);
            }else{
                return binarySearch(words,s,left,mid-1);
            }
        }
    }
}
