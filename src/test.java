/**
 * @Author JiaWei Xu
 * @Date 2020-01-06 09:54
 * @Email xjwhhh233@outlook.com
 */
public class test {
    public static void main(String[] args){
//        String a="hello";
//        String b="hello";
//        String c=new String("hello");
//        System.out.println(a==b);
//        System.out.println(a==c);
//        System.out.println(b==c);

        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer e=321;
        Integer f=321;
        Long g=3L;
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));


    }
}
