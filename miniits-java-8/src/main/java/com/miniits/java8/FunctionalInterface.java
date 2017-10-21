package com.miniits.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: WWW.MINIITS.COM
 * @Date: 2017/10/20
 * @Time: 21:14
 * <p>
 * Description:
 * ***
 */
public class FunctionalInterface {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});
        //实例一： 调用predicate的test方法  ，表示存在的方法true ,就是遍历
        test(integers, i -> true);

        //实例二： 调用predicate的test方法  ，取出元素是 1 的数据
        test(integers, i -> i == 1);

    }

    public static void test(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer i : list) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }
}
