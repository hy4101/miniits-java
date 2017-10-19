package com.miniits.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author: wq
 * @Date: 2017/10/17
 * @Time: 20:25
 * <p>
 * Description:
 * ***
 */

public class Start {

    @Test
    public void miniitsInit() {

        List<String> names1 = new ArrayList<String>();
        names1.add("31");
        names1.add("2");
        names1.add("23");
        names1.add("4");
        names1.add("6");

        List<String> names2 = new ArrayList<String>();
        names2.add("31");
        names2.add("2");
        names2.add("23");
        names2.add("4");
        names2.add("6");

        System.out.println("使用 Java 7 语法: ");

        sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println("使用 Java 8 语法: ");

        sortUsingJava8(names2);
        System.out.println(names2);
    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}
