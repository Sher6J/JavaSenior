package cn.sher6j.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *1.List接口框架：
 * |---Collection接口：单列集合，用来存储一个一个的对象
 *     |---List接口：存储有序的、可重复的数据。  -->“动态数组”，替换原有的数组
 *         |---ArrayList：作为List接口的主要实现类，线程不安全的，效率高；底层使用Object[]存储
 *         |---LinkedList：对于频繁的插入、删除操作，使用效率比ArrayList高；底层使用双向链表存储
 *         |---Vector：作为List接口的古老实现类，线程安全的，效率低；底层使用Object[]存储
 *
 *2.ArrayList源码分析：
 * ArrayList的源码分析： JDK7 和 JDK8不同
 *  JDK 7：
 *     ArrayList list = new ArrayList(); //底层创建了长度是10的Object[]数组 elementData
 *     list.add(123); //elementData[0] = new Integer(123);
 *     ......
 *     list.add(11); //如果此次的添加导致底层elementData数组容量不够，则扩容
 *     默认情况下，扩容为原来的容量的1.5倍(新造数组)，同时将原有数组中的数据复制到新的数组中
 *     结论：建议开发中使用带参的构造器：
 *          ArrayList list = new ArrayList(int initialCapacity);
 *  JDK 8：
 *     ArrayList list = new ArrayList(); //底层Object[] elementData初始化为{}，并没有创建长度为10的数组
 *     list.add(123); //第一次调用add()时，底层才创建了长度为10的数组，并elementData[0] = new Integer(123);
 *     ......
 *     后续的添加和扩容操作与JDK7无异
 *  小结：JDK7中的ArrayList的对象的创建类似于单例模式中的饿汉式
 *       JDK8中的ArrayList的对象的创建类似于单例模式中的懒汉式，延迟了数组的创建，节省内存
 *
 *3.LinkedList源码分析：7\8没什么区别
 *     LinkedList list = new LinkedList(); //内部声明了Node类型的first和last属性，默认值为null
 *     list.add(123);  //将123封装到Node当中，创建了Node对象
 *
 *     其中，Node定义为：
 *     private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *4.Vector源码分析：创建对象时，底层创建了长度为10的数组
 *  在扩容方面，默认扩容为原数组长度的2倍
 *
 *
 *
 * 面试题：ArrayList、LinkedList、Vector三者异同？
 * 同：三个类都实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 *
 *
 *5.List接口中的常用方法：
 * void add(int index, Object ele):在index位置插入ele元素
 * boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
 * Object get(int index):获取指定index位置的元素
 * int indexOf(Object obj):返回obj在集合中首次出现的位置
 * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
 * Object remove(int index):移除指定index位置的元素,并返回此元素
 * Object set(int index, Object ele):设置指定index位置的元素为ele
 * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
 *
 *总结：常用方法
 * 增：add(Object obj)
 * 删：remove(int index) / remove(Object obj)->Collection里
 * 改：set(int index, Object ele)
 * 查：get(int index)
 * 插：add(int index, Object ele)
 * 长度：size()
 * 遍历：①Iterator迭代器②增强for③普通循环
 * @author sher6j
 * @create 2020-04-01-上午10:51
 */
public class ListTest {

    @Test
    public void test1() {
        ArrayList li = new ArrayList();
        li.add(123);
        li.add(456);
        li.add("aa");
        li.add(new Person("james", 36));
        li.add(456);

        System.out.println(li);

        //void add(int index, Object ele):在index位置插入ele元素
        li.add(1, "bb");
        System.out.println(li);

        //boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list = Arrays.asList(1, 2, 3);
        li.addAll(list);
        System.out.println(li);

        //Object get(int index):获取指定index位置的元素
        System.out.println(li.get(1));
    }

    @Test
    public void test2() {
        ArrayList li = new ArrayList();
        li.add(123);
        li.add(456);
        li.add("aa");
        li.add(new Person("james", 36));
        li.add(456);

        //int indexOf(Object obj):返回obj在集合中首次出现的位置
        int i = li.indexOf(456); //有返回首次出现位置，没有返回-1
        System.out.println(i);

        //int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        int i1 = li.lastIndexOf(456);
        System.out.println(i1);

        //Object remove(int index):移除指定index位置的元素,并返回此元素
        //重载了Collection中的remove方法（根据对象删），可以根据索引删
        Object o = li.remove(0); //返回删除的元素
        System.out.println(o);
        System.out.println(li);

        //Object set(int index, Object ele):设置指定index位置的元素为ele
        li.set(1, "cc");
        System.out.println(li);

        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        List list = li.subList(2, 4);
        System.out.println(list);
    }

    //遍历
    @Test
    public void test3() {
        ArrayList li = new ArrayList();
        li.add(123);
        li.add(456);
        li.add("aa");

        //方式一：Iterator
        Iterator iterator = li.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("--------");

        //方式二：foreach
        for (Object o : li) {
            System.out.println(o);
        }
        System.out.println("--------");

        //方式三：for
        for (int i = 0; i < li.size(); i++) {
            System.out.println(li.get(i));
        }
    }
}
