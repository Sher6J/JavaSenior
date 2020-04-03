package cn.sher6j.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JDK 8 之前的日期时间的API测试
 * 1.System类中的currentTimeMills();
 * 2.java.util.Date和其子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calender
 *
 * @author sher6j
 * @create 2020-03-30-下午8:28
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：对日期Date类的格式化解析

    1.两个操作：
    1.1 格式化：日期 ---> 指定格式的字符串
    1.2 解析：格式化的逆过程， 字符串 ---> 日期

    2.SimpleDateFormat实例化
     */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化：使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期-->字符串
        Date date = new Date();
//        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程， 字符串 ---> 日期
        String str = "2020/6/27 下午8:36";
        Date date1 = sdf.parse(str);
        System.out.println(date1);

        //指定方式格式化和解析，调用带参的构造器
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");//02020.三月.30 公元 08:38 下午
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析：要求字符串必须符合SimpleDateFormat识别的格式，否则抛异常
        Date date2 = sdf1.parse("2020-02-14 11:45:33");
        System.out.println(date2);

    }

    /*
    练习一：字符串“2020-09-08”转换为java.sql.Date


    练习二：“三天打鱼两天晒网” 1990-01-01开始  到 xxxx-xx-xx 打鱼？晒网？

    举例 2020-09-08 ？ 总天数

    总天数 % 5 == 1/2/3：打鱼
    总天数 % 5 == 4/0：晒网

    总天数计算？
    方式一：(date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) + 1
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);
        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1);
    }

}
