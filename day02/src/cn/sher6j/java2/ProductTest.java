package cn.sher6j.java2;

/**
 * 线程通信应用：生产者/消费者问题
 *
 * 生产者(Productor)将产品交给店员(Clerk),而消费者(Customer)从店员处
 * 取走产品,店员一次只能持有固定数量的产品(比如:20),如果生产者试图
 * 生产更多的产品,店员会叫生产者停一下,如果店中有空位放产品了再通
 * 知生产者继续生产;如果店中没有产品了,店员会告诉消费者等一下,如
 * 果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1.是否是多线程问题？  是，生产者线程，消费者线程
 * 2.是否有共享数据？   有，产品数量
 * 3.如何解决线程安全问题？  同步机制，三种方法
 * 4.是否涉及线程通信？  是
 *
 * @author sher6j
 * @create 2020-03-30-上午9:58
 */
class Clerk{

    private int productCount = 0;

    //生产产品
    public synchronized void product() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + ":开始生产第" + productCount + "个产品");
            notify();
        } else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void comsume() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费第" + productCount + "个产品");
            productCount--;
            notify();
        } else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Productor implements Runnable{

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + "开始生产产品");

        while (true) {
            clerk.product();
        }
    }
}
class Customer implements Runnable{

    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + "开始消费产品");

        while (true) {
            clerk.comsume();
        }
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor p1 = new Productor(clerk);
        Thread p = new Thread(p1);
        p.setName("生产者一");


        Customer c1 = new Customer(clerk);
        Thread c = new Thread(c1);
        c.setName("消费者一");

        p.start();
        c.start();
    }
}
