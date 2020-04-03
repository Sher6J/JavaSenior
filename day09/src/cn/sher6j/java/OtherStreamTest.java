package cn.sher6j.java;

import org.junit.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1. 标准的输入、输出流
 * 2. 打印流
 * 3. 数据流
 *
 * @author sher6j
 * @create 2020-04-03-上午9:08
 */
public class OtherStreamTest {
    /*
    1.标准的输入、输出流
    System.in：默认从键盘输入
    System.out：默认从控制台输出

    可以通过System的setIn(InputStream is)/setOut(PrintStream ps)方式重新指定输入和输出的流
    从键盘输入字符串,要求将读取到的整行字符串转成大写输出。然后继续进行输入操作,直至当输入“e”或者“exit”时,退出程序。
     */
    @Test
    public void test1() {
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while (true) {
                String data = br.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }

                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    2.打印流：PrintStream 和 PrintWriter

    2.1 提供了一系列重载的print()和println()
     */
    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(new File("D:\\IO\\text.txt"));
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }

    /*
    3.数据流
    3.1 DataInputStream 和 DataOutputStream
    3.2 作用：用于读取或写出基本数据类型的变量或字符串
     */
    @Test
    public void test3() throws IOException {
        /**
         * 将内存中的字符串、基本数据类型的变量写出到文件中
         * 注意：处理异常应该用try-catch-finally
         */
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("james");
        dos.flush();
        dos.writeInt(32);
        dos.flush();

        dos.close();
    }

    @Test
    public void test4() throws IOException {
        /**
         * 将文件中存储的基本数据类型变量和字符串读取到内存中，保存到变量中
         * 注意：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致
         */
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

        String name = dis.readUTF();
        int age = dis.readInt();

        System.out.println(name + ", " + age);
    }
}
