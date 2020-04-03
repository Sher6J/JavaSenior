package cn.sher6j.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-01-上午11:59
 */
public class ListExer {
    /*
    区分List中的remove(int index)和remove(Object obj)
     */
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);//自动装箱
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private void updateList(List list) {
        list.remove(2);
        list.remove(new Integer(2));
    }
}
