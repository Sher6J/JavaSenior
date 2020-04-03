package cn.sher6j.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author sher6j
 * @create 2020-04-01-下午7:45
 */
public class PropertiesTest {

    //Properties:常用类处理配置文件。key和value都是String类型
    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();

        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis); //加载流对应的文件

        String name = pros.getProperty("name");
        String password = pros.getProperty("password");

        System.out.println("name:" + name + ", password:" + password);

        fis.close();

    }
}
