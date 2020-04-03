package cn.sher6j.java;

/**
 * 测试Thread中的常用方法：
 * 1.start()：①启动当前线程；②调用当前线程的run()
 * 2.run()：通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread()：静态方法，返回执行当前代码的现场
 * 4.getName()：获取当前线程的名字
 * 5.setName()：设置当前线程的名字
 * 6.yield()：释放当前CPU执行权
 * 7.join()：在线程a中调用线程b的join()，此时线程a进行阻塞状态，直到线程b完全执行完以后，线程a才结束阻塞状态
 * 8.stop()：已过时。强制结束当前线程
 * 9.sleep(long milltime)：让当前线程“睡眠”指定的毫秒数。
 * 10.isAlive()：判断当前线程是否存活
 *
 * 线程的优先级：
 * 1.
 * MAX_PRIORITY:10
 * MIN _PRIORITY:1
 * NORM_PRIORITY:5 --> 默认优先级
 * 2.如何获取和设置当前线程优先级：
 *   getPriority();
 *   setPriority(int p);
 *
 *   说明：高优先级线程要抢占低优先级线程CPU的执行权，只是从概率上将，并不意味着只有当高优先级执行完后低优先级才执行
 *
 * @author sher6j
 * @create 2020-03-29-上午10:22
 */
class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {

//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                System.out.println(this.getName() + ":" + this.getPriority() + ":" + i);
            }

            if (i % 20 == 0) {
                this.yield();
            }
        }
    }

    public MyThread1(String name) {
        super(name);
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {
        MyThread1 h1 = new MyThread1("一线程");
//        h1.setName("线程一");

        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if (i == 20) {
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(h1.isAlive());
    }
}
