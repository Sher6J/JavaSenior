package cn.sher6j.java;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类：
 * 1. 操作数据单位：字节流、字符流
 * 2. 数据的流向：输入流、输出流
 * 3. 流的角色：节点流、处理流
 * <p>
 * 二、流的体系结构
 * 抽象基类          节点流(或文件流)                                      缓冲流(处理流的一种)
 * InputStream      FileInputStream (read byte[] buffer)                BufferedInputStream (read byte[] buffer)
 * OutputStream     FileOutputStream (write(byte[] buffer, 0, len)      BufferedOutputStream (write(byte[] buffer, 0, len) / flush()
 * Reader           FileReader (read char[] cbuf)                       BufferedReader (read char[] cbuf  /  readLine())
 * Writer           FileWriter (writer(char[] cbuf, 0, len)             BufferedWriter (writer(char[] cbuf, 0, len) / flush()
 *
 * @author sher6j
 * @create 2020-04-02-下午3:43
 */
public class FileReaderWriterTest {

    /*
    将day09下的hello.txt文件内容读入到程序中，并输出

    说明点：
    1.read()的理解：返回读入的一个字符。如果达到文件末尾，返回-1
    2.异常的处理：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
    3.读入的文件一定存在，否则报异常FileNotFoundException
     */
    @Test
    public void test1() throws IOException {
        //1.实例化File类的对象，指明要操作的文件
        File file = new File("hello.txt");
        //2.提供具体的流
        FileReader fr = new FileReader(file);
        //3.数据读入
        //read()：返回读入的一个字符。如果达到文件末尾，返回-1
//        //方式一：
//        int read = fr.read();
//        while (read != -1) {
//            System.out.print((char)read);
//            read = fr.read();
//        }

        //方式二：语法上针对于方式一的修改
        int data;
        while ((data = fr.read()) != -1) {
            System.out.print((char) data);
        }

        //4.流的关闭操作
        fr.close();
    }

    /*
    对read()操作升级：使用read的重载方法
     */
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1.File类的实例化
            File file = new File("hello.txt");
            //2.流的实例化
            fr = new FileReader(file);
            //3.读入的操作
            //read(char[] cbuf);返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                //错误的写法
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);
//                }
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //4.资源的关闭
    }

    /*
    从内存中写出数据到硬盘的文件里
    说明：
    1. 输出操作，对应的File可以不存在。并不会报异常
        如果不存在，输出过程中，会自动创建文件
        如果存在：
            如果流使用的构造器是：FileWriter(file, false)/FileWriter(file)：对原有文件覆盖
            如果流使用的构造器是：FileWriter(file, true)：则不会对原文件覆盖，而是原有文件基础上追加内容
     */
    @Test
    public void testFileWriter() throws IOException {
        //1.提供File类的对象，指明写出到的文件
        File file = new File("hello1.txt");
        //2.提供FileWriter对象，用于数据写出
        FileWriter fw = new FileWriter(file, false);
        //3.写出的操作
        fw.write("i have a dream!\n");
        fw.write("you have a dream!");

        //4.流资源的关闭
        fw.close();
    }

    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;

        try {
            //1.创建File类的对象
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");
            //2.创建输入流和输出流
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3.数据的读入和写出操作
            char[] cbuf = new char[5];
            int len; //记录每次读入到cbuf数组中的字符的个数
            while ((len = fr.read(cbuf)) != -1) {
                //每次写出len个字符
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.关闭资源
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
