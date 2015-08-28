package cn.boxfish;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LuoLiBing on 15/8/20.
 */
public class Test1 {

    @Test
    public void test1() {
        List<String> list = new ArrayList<String>();
        String str = "luolibing";
        list.add(str);
        list.add(str);
        System.out.println(list);
    }

    class Person {
        int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
