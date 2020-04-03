package cn.sher6j.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections：操作Collection和Map的工具类
 *
 * 面试题：Collection和Collections的区别？
 *       一个接口，一个工具类
 *
 * 常用方法：
 * 排序操作:(均为static方法)
 *   reverse(List):反转 List 中元素的顺序
 *   shuffle(List):对 List 集合元素进行随机排序
 *   sort(List):根据元素的自然顺序对指定 List 集合元素按升序排序
 *   sort(List,Comparator):根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 *   swap(List,int, int):将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 * 查找、替换
 *   Object max(Collection):根据元素的自然顺序,返回给定集合中的最大元素
 *   Object max(Collection,Comparator):根据 Comparator 指定的顺序,返回给定集合中的最大元素
 *   Object min(Collection)
 *   Object min(Collection,Comparator)
 *   int frequency(Collection,Object):返回指定集合中指定元素的出现次数
 *   void copy(List dest,List src):将src中的内容复制到dest中
 *   boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换List对象的所有旧值
 * @author sher6j
 * @create 2020-04-01-下午7:53
 */
public class CollectionsTest {

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(45);
        list.add(345);
        list.add(324);
        list.add(34);
        list.add(455);
        list.add(323);

        System.out.println(list);

//        Collections.reverse(list);
//        Collections.shuffle(list);
        Collections.sort(list);


        System.out.println(list);

        /*
        Collections 类中提供了多个 synchronizedXxx() 方法,该方法可使将
        指定集合包装成线程同步的集合,从而可以解决多线程并发访问集合时的线程安全问题
         */
        //返回的list1即为线程安全的List
        List list1 = Collections.synchronizedList(list);


    }
}
