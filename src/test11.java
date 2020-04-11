/**
 * @Author JiaWei Xu
 * @Date 2020-03-25 19:33
 * @Email xjwhhh233@outlook.com
 */
public class test11 {
    public static void main(String[] args){
        String a="This section introduces and compares several concepts for\n" +
                "computation at the edge integrated to the mobile network.\n" +
                "First, we overview various MEC solutions proposed in the\n" +
                "literature that enables to bring computation close to the UEs.\n" +
                "Secondly, we describe the effort done within ETSI standardization organization regarding the MEC. Finally, we compare\n" +
                "individual existing MEC concepts (proposed in both literature\n" +
                "and ETSI) from several perspectives such as MEC control and\n" +
                "location of the computation/storage resources.";
        a=a.replaceAll("\n"," ");
        System.out.println(a);
    }
}
