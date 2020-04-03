package cn.sher6j.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：Java中的对象，正常情况下，只能进行比较==或!=，不能使用>或<的
 *         但是在开发场景中，需要对多个对象进行排序，需要比较对象大小
 *         如何实现？使用两个接口中的任何一个：Comparable(自然排序)或Comparator(定制排序)
 * 二、Comparable接口与Comparator接口对比
 *  Comparable接口的方式一旦指定，保证该接口实现类对象在任何位置都可以比较大小
 *  Comparator接口属于临时性的比较
 *
 * @author sher6j
 * @create 2020-03-31-上午10:30
 */
public class CompareTest {

    /*
    Comparable接口的使用举例：      自然排序
    1.String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式
    2.重写compareTo(obj)的规则：
        如果当前对象this大于形参对象obj，则返回正整数。
        如果当前对象this小于形参对象obj，则返回负整数。
        如果当前对象this等于形参对象obj，则返回零。
    3.对于自定义类来说，如果需要排序，可以让自定义类实现Comparable接口，重写compareTo(obj)方法
      在compareTo(obj)中指明如何排序
     */
    @Test
    public void test1() {
        String[] arr = new String[]{"AA","CC","MM","GG","JJ","DD"};
        //
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("appleMouse", 65);
        arr[4] = new Goods("huaweiMouse", 43);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    /*
    Comparator接口的使用：       定制排序
    1.背景：当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码,
           或者实现了java.lang.Comparable接口的排序规则不适合当前的操作,
           那么可以考虑使用 Comparator 的对象来排序
    2.重写compare(Object o1,Object o2)方法,比较o1和o2的大小:
           如果方法返回正整数,则表示o1大于o2;
           如果返回0,表示相等;
           返回负整数,表示o1小于o2。
     */
    @Test
    public void test3() {
        String[] arr = new String[]{"AA","CC","MM","GG","JJ","DD"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("appleMouse", 65);
        arr[4] = new Goods("huaweiMouse", 43);

        Arrays.sort(arr, new Comparator<Goods>() {
            //商品按照产品名称从低到高，再按价格从高到低排序
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getName().equals(o2.getName())) {
                    return -Double.compare(o1.getPrice(), o2.getPrice());
                } else {
                    return o1.getName().compareTo(o2.getName());
                }
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
