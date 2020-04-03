package cn.sher6j.java;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 * @author sher6j
 * @create 2020-03-30-下午7:31
 */
public class DataTimeTest {

    //1.System类中的currentTimeMillis
    @Test
    public void test1() {
        long l = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。、
        //称为时间戳
        System.out.println(l);
    }

    /*
    java.sql.Date是java.util.Date的子类
    java.util.Date类
          |---java.sql.Date类

    1.两个构造器的使用

    2.两个方法的使用
       ①toString()：显示当前的时间
       ②getTime()：获取当前Date对象相应时间戳
    3.java.sql.Date对应着数据库中的日期类型的变量

     */
    @Test
    public void test2() {
        //构造器一：Date()  创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());//Mon Mar 30 19:37:43 CST 2020
        System.out.println(date1.getTime());


        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(1585568342709L);
        System.out.println(date2.toString());

        //如何将java.util.Date对象转换为java.sql.Date对象
        Date date3 = new Date();
        java.sql.Date date4 = new java.sql.Date(date3.getTime());

    }
}
