package cn.sher6j.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String类与其他结构的转换
 * @author sher6j
 * @create 2020-03-30-下午5:16
 */
public class StringTest1 {
    /*
    String 与基本数据类型、包装类之间的转化

    String --> 基本数据类型、包装类：调用包装类的静态方法 parseXxx(Str)
    基本数据类型、包装类 --> String：调用String重载的valueOf(xxx)
     */
    @Test
    public void test1() {
        String s1 = "123";
//        int num = (int)str1;//错误！子父类才可以强转
        int i = Integer.parseInt(s1);

        String s2 = String.valueOf(i);
        String s3 = i + "";//堆里

    }

    /*
    String与char[]之间的转换

    String --> char[]：调用String的toCharArray()
    char[] --> String：调用String的构造器
     */
    @Test
    public void test2() {
        String s1 = "abc124";

        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String s = new String(arr);
        System.out.println(s);
    }

    /*
    String 与 byte[]之间的转换

    String --> byte[]：调用String的getBytes()
    byte[] --> String：调用String的构造器

    编码：字符串 --> 字节
    解码：字节 --> 字符串
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String s1 = "abc123中国";
        byte[] bytes = s1.getBytes();//使用默认字符集进行编码
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = s1.getBytes("gbk");//使用GBK字符集进行编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("------------");

        String s2 = new String(bytes);//默认字符集解码
        System.out.println(s2);

        String s3 = new String(gbks);
        System.out.println(s3);//乱码，编码集和解码集不一致

        String s4 = new String(gbks, "gbk");
        System.out.println(s4);//没出现乱码
    }
}
