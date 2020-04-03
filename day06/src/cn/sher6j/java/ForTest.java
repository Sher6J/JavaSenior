package cn.sher6j.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JDK 5.0 新增了foreach循环，用于遍历集合、数组
 * @author sher6j
 * @create 2020-04-01-上午10:42
 */
public class ForTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);//Integer
        coll.add(456);
        coll.add(new String("Jack"));
        coll.add(false);//Boolean
        coll.add(456);
        coll.add(new Person("james", 36));

        //for(集合元素的类型 局部变量 : 集合对象
        for (Object o : coll) {
            System.out.println(o);
        }
    }

    //练习题
    @Test
    public void test2() {
        String[] arr = new String[]{"mm","mm","mm"};

//        //方式一：普通for赋值   -->gg
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "gg";
//        }

        //方式二：增强for循环   -->mm
        for (String s : arr) {
            s = "gg";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
