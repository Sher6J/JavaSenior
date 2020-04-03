package cn.sher6j.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张 使用实现Runnable接口方式
 *  存在线程安全问题
 *
 * @author sher6j
 * @create 2020-03-29-上午11:11
 */
class Window1 implements Runnable {

    private int ticket = 100; //不需要再加static了
    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 卖票， 票号为： " + ticket);
                ticket --;
            }else {
                break;
            }
        }

    }
}
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 window1 = new Window1();

        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");
    }
}
