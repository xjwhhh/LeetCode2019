package spring2020;

/**
 * @Author JiaWei Xu
 * @Date 2020-03-23 11:49
 * @Email xjwhhh233@outlook.com
 */
public class ThreadJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("打开冰箱！");
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("拿出一瓶牛奶！");
            }
        });

        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("关上冰箱！");
            }
        });

        //下面三行代码顺序可随意调整，程序运行结果不受影响，因为我们在子线程中通过“join()方法”已经指定了运行顺序。
        thread3.start();
        thread2.start();
        thread1.start();

    }
}