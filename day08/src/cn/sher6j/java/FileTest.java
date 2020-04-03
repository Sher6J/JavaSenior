package cn.sher6j.java;

import org.junit.Test;

import java.io.File;

/**
 * File类的使用
 *
 * 1.File类的一个对象，代表一个文件或一个文件目录（俗称文件夹）
 * 2.File类声明在java.io包下
 * 3.File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法。
 *   并未涉及到写入或读取文件内容的操作。如果需要读取或写入文件内容，必须使用IO流完成。
 * 4.后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”。
 * @author sher6j
 * @create 2020-04-02-上午10:05
 */
public class FileTest {
    /*
    1. 如何创建File类的实例

    2. 相对路径：
       绝对路径：
    3. 路径分隔符
     */
    @Test
    public void test1() {
        //构造器1
        File file1 = new File("hello.txt");//相对于当前的module

        System.out.println(file1);

        System.out.println(file1.getAbsolutePath());
    }
}
