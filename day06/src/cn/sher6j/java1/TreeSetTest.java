package cn.sher6j.java1;

import cn.sher6j.java.Person;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author sher6j
 * @create 2020-04-01-下午4:43
 */
public class TreeSetTest {

    /*
    1. 向TreeSet中添加的数据，要求是相同类的对象
    2. 两种排序方式：
       自然排序：实现Comparable接口
       定制排序：Comparator接口
    3. 自然排序中，比较两个对象是否相同的标准：compareTo()返回0，不再是equals().
    4. 定制排序中，比较两个对象是否相同的标准：compare()返回0，不再是equals().
     */
    @Test
    public void test1() {
        TreeSet set = new TreeSet();

        //错误！class java.lang.Integer cannot be cast to class java.lang.String
//        set.add(456);
//        set.add("cc");
//        set.add(new Person("james", 36));

//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(9);

        set.add(new Person("Tom", 12));
        set.add(new Person("Jerry", 32));
        set.add(new Person("Jim", 2));
        set.add(new Person("Mike", 65));
        set.add(new Person("Jack", 33));
        set.add(new Person("Jack", 56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2() {

        Comparator com = new Comparator() {
            //按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                } else {
                    throw new RuntimeException("输入数据类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(com);

        set.add(new Person("Tom", 12));
        set.add(new Person("Jerry", 32));
        set.add(new Person("Jim", 2));
        set.add(new Person("Mike", 65));
        set.add(new Person("Jack", 33));
        set.add(new Person("Jack", 56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
