package cn.sher6j.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁 --- JDK5.0新增
 *
 * 1.面试题：synchronized与Lock异同？
 *      相同：二者都可以解决线程安全问题
 *      不同：synchronized机制在执行完相应的同步代码后自动释放同步监视器
 *           Lock需要手动的启动同步(lock())，结束同步也需要手动实现(unlock())
 *
 *
 * @author sher6j
 * @create 2020-03-29-下午8:29
 */
class Window implements Runnable {

    private int ticket = 100;
    //1.实例化
    private ReentrantLock lock = new ReentrantLock(true); //默认false，不公平

    @Override
    public void run() {
        while (true) {
            try {
                //调用lock()枷锁
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：售票，票号为：" + ticket);
                    ticket --;
                } else {
                    break;
                }
            }finally {
                //3.调用unlock()解锁
                lock.unlock();
            }

        }
    }
}
public class LockTest {
    public static void main(String[] args) {
        Window window = new Window();
        Thread t1 = new Thread(window);
        Thread t2 = new Thread(window);
        Thread t3 = new Thread(window);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
