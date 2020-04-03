package cn.sher6j.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用Iterator接口
 * 内部的方法： hasNext() 和 next()
 *
 * Iterator使用来遍历Collection的，不是用来遍历Map的
 * @author sher6j
 * @create 2020-04-01-上午10:25
 */
public class IteratorTest {
    
    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);//Integer
        coll.add(456);
        coll.add(new String("Jack"));
        coll.add(false);//Boolean
        coll.add(456);
        coll.add(new Person("james", 36));

        Iterator iterator = coll.iterator();

        //hasNext():判断是否还有下一个元素
        while (iterator.hasNext()) {
            //next():1指针下移 2将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    //测试Iterator中的remove()方法
    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);//Integer
        coll.add(456);
        coll.add(new String("Jack"));
        coll.add(false);//Boolean
        coll.add(456);
        coll.add(new Person("james", 36));

        //删除集合中"Jack"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if ("Jack".equals(obj)) {
                iterator.remove();
            }
        }

        Iterator i1 = coll.iterator();
        while (i1.hasNext()) {
            System.out.println(i1.next());
        }
    }
}
