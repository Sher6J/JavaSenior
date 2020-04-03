package cn.sher6j.exer;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元,每次存1000,存3次。每次存完打
 * 印账户余额。
 *
 * 分析：
 * 1.是多线程问题吗？  是多线程问题，两个储户线程
 * 2.多线程问题有线程安全问题吗？（存在共享数据）  有，账户（账户余额）
 * 3.如何解决？  同步机制：三种
 * @author sher6j
 * @create 2020-03-29-下午8:40
 */

class Account{
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    //存钱
    public synchronized void deposit(double amt) {
        if (amt > 0) {
            balance += amt;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "存钱成功。余额为：" + balance);
        }
    }
}
class Customer extends Thread{
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++){
            acct.deposit(1000);
        }
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();
    }
}
