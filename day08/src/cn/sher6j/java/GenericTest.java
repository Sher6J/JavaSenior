package cn.sher6j.java;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 泛型的使用
 * 1.JDK5.0新增的特性
 *
 * 2.在集合中使用泛型：
 *   ①集合接口或集合类在JDK5.0时都修改为带泛型的结构
 *   ②在实例化集合类时，可以致命具体的泛型类型
 *   ③泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类代替
 *   ④若没有指明泛型的类型，则默认类型为java.lang.Object类型
 *
 * @author sher6j
 * @create 2020-04-02-上午9:43
 */
public class GenericTest {

    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(123);
        //编译时就会进行类型检查，保证数据的安全
//        list.add("adf"); //报错

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
