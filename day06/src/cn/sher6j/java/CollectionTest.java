package cn.sher6j.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的方法的测试
 *
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals().
 *
 * @author sher6j
 * @create 2020-04-01-上午9:52
 */
public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);//Integer
        coll.add(456);
        coll.add(new String("Jack"));
        coll.add(false);//Boolean
        coll.add(456);
        coll.add(new Person("james", 36));

        //1.contains(Object obj); 判断当前集合时候包含obj
        boolean contains = coll.contains(123);
        System.out.println(contains); //true

        //contains(Object obj)调用的是obj对象所在类的equals()方法。String中重写了equals所以为true，自定义类若重写equals则也为true
        System.out.println(coll.contains(new String("Jack")));//true --> 判断的不是地址，判断的是内容
//        System.out.println(coll.contains(new Person("james", 36)));//false(重写equals之前)
        System.out.println(coll.contains(new Person("james", 36)));//true(重写equals之后)

        System.out.println("----------");

        //2.containsAll(Collection coll1); 判断形参对应的coll1中的元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);//Integer
        coll.add(456);
        coll.add(new String("Jack"));
        coll.add(false);//Boolean
        coll.add(456);
        coll.add(new Person("james", 36));

        //3.remove(Object obj); 从当前集合中移除obj元素返回boolean型
        coll.remove(123);
        System.out.println(coll);

        //4.removeAll(Collection coll1); 从当前集合中移除coll1中所有的元素 -->coll与coll1的差集
        Collection coll1 = Arrays.asList(123, 456, 4567);
        coll.removeAll(coll1);
        System.out.println(coll);

    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);//Integer
        coll.add(456);
        coll.add(new String("Jack"));
        coll.add(false);//Boolean
        coll.add(456);
        coll.add(new Person("james", 36));

        //5.retainAll(Collection coll1); 获取当前集合与coll1的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123, 456, 4567, 789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj)：判断当前集合和当前形参集合是否元素相同
        Collection coll1 = new ArrayList();
        coll1.add(123);//Integer
        coll1.add(456);
        coll1.add(new String("Jack"));
        coll1.add(false);//Boolean
        coll1.add(456);
        coll1.add(new Person("james", 36));
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);//Integer
        coll.add(456);
        coll.add(new String("Jack"));
        coll.add(false);//Boolean
        coll.add(456);
        coll.add(new Person("james", 36));

        //7.hashCode(); 返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合-->数组  toArray()
        Object[] arr = coll.toArray();
        for (Object o : arr) {
            System.out.println(o);
        }

        //数组-->集合 调用Arrays中的静态方法asList
        List<String> list = Arrays.asList(new String[]{"aa", "bb", "cc"});
        System.out.println(list);

        //注意：
        List<int[]> arr1 = Arrays.asList(new int[]{1, 2});
        System.out.println(arr1.size()); //1

        List<Integer> arr2 = Arrays.asList(new Integer[]{1, 2});
        System.out.println(arr2.size()); //2

        List<Integer> arr3 = Arrays.asList(1, 2);
        System.out.println(arr3.size()); //2

        //9.iterator(); 返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }
}
