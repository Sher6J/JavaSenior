package cn.sher6j.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：使用线程池
 *
 * @author sher6j
 * @create 2020-03-30-上午10:38
 */
class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100 ; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        //设置线程池属性
//        System.out.println(service.getClass());
        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();

        //2.执行执行的线程操作，需要提供实现Runnable接口或Callable接口实现类的对象
        service1.execute(new NumberThread()); //适合使用于Runnable
        service1.execute(new NumberThread1()); //适合使用于Runnable
//        service.submit(new NumberThread()); //适合使用于Callable
        //3.关闭连接池
        service1.shutdown();
    }
}
