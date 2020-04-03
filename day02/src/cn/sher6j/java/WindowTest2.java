package cn.sher6j.java;

/**
 * 例子：创建三个窗口卖票，总票数为100张
 *
 * 存在线程安全问题，待解决
 *
 * 使用同步代码快解决继承Thread类的方式的线程安全问题
 *
 * 说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，可以考虑使用当前类充当监视器 Window2.class
 * @author sher6j
 * @create 2020-03-29-上午10:53
 */
class Window2 extends Thread {

    private static int ticket  = 100;

    private static Object obj = new Object(); //static保证唯一

    @Override
    public void run() {

        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(this.getName() + ": 卖票， 票号为： " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();
    }
}

