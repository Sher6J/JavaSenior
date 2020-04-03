package cn.sher6j.java;

import org.junit.Test;

import java.io.*;

/**
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 * 1.对于文本文件(.txt, .java, .c, .cpp)，使用字符流处理
 * 2.对于非文本文件(.jpg, .mp3, .mp4, .avi, .doc, .ppt)，使用字节流处理
 * @author sher6j
 * @create 2020-04-02-下午6:29
 */
public class FileInputOutputStreamTest {

    @Test
    public void testFileInputStream() throws IOException {
        FileInputStream fis = null;
        try {
            File file = new File("hello.txt");
            fis = new FileInputStream(file);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                String s = new String(buffer, 0, len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }


    }

    /*
    实现对图片的复制
     */
    @Test
    public void testFileInputOutputStream() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("timg.jpg");
            File desFile = new File("copy.jpg");

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            byte[] buff = new byte[5];
            int len;
            while ((len = fis.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //指定路径下文件的复制
    public void copyFile(String srcPath, String desPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File(srcPath);
            File desFile = new File(desPath);

            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(desFile);

            byte[] buff = new byte[1024];
            int len;
            while ((len = fis.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testCopyFile() {
        long start = System.currentTimeMillis();

        String srcPath = "timg.jpg";
        String desPath = "copy.jpg";
        copyFile(srcPath, desPath);

        long end = System.currentTimeMillis();

        System.out.println("the copy wasted time is: " + (end - start));
    }
}
