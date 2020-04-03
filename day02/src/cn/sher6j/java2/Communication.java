package cn.sher6j.java2;

/**
 * 线程通信的例子：使用两个线程打印1-100。线程1和线程2交替打印
 *
 * 涉及的三个方法：
 * wait()：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify()：一旦执行此方法，就会唤醒被wait的一个线程。若有多个线程被wait，则唤醒优先级高的那个
 * notifyAll()：一旦执行此方法，就会唤醒所有被wait的线程
 *
 * 说明：
 * 1.以上三个方法必须使用在同步代码块或同步方法中
 * 2.以上三个方法的调用者必须是同步代码块或同步方法中的同步监视器
 *      否则，会出现IllegalMonitorStateException异常
 * 3.以上三个方法定义在java.lang.Object类中
 *
 * 面试题：sleep() 和 wait()的异同？
 * 1.相同点：一旦执行方法，都可以使得当前线程进入阻塞状态
 * 2.不同点：
 *     ①两个方法声明位置不同：Thread类中声明sleep()，Object类中声明wait()
 *     ②调用要求不同：sleep()可以在任何需要的场景下调用，wait()必须使用在同步代码块或同步方法中
 *     ③关于是否释放同步监视器：若两个方法都使用在同步代码块或同步方法中，sleep()不会释放，wait()会释放
 *
 * @author sher6j
 * @create 2020-03-30-上午9:36
 */
class Number implements Runnable {
    private int number = 1;
//    Object obj = new Object();
    @Override
    public void run() {
        while (true) {
//            synchronized (obj) { //IllegalMonitorStateException
            synchronized (this) {

                notify();//唤醒

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        //使调用如下wait()方法线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }

    }
}
public class Communication {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }

}
