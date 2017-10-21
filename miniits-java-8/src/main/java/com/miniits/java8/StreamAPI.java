package com.miniits.java8;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: WWW.MINIITS.COM
 * @Date: 2017/10/20
 * @Time: 22:59
 * <p>
 * Description:
 * ***
 */
public class StreamAPI {

    public static void main(String[] args) {
        //创建一个 List
        List<String> l = Arrays.asList("1", "", "2", "3", "4", "", "5");
        /**
         * 支持 Lambda 表达式 ，
         * 下面这句是 对 List l 做过滤处理，并且返回一个新的 List
         * 调用 stream 的 filter接口 ，同时 定义一个变量 s （也就是 List 中的元素），
         * 判断 s 是否为空
         * 得到新的 List
         *
         */
        List<String> m = l.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());

        m.stream().forEach(System.out::println);
        /**
         * 输出
         * abc
         * bc
         * efg
         * abcd
         * jkl
         */

        forEachTest();
        mapTest();
        filterTest();
    }

    //forEach 实例
    public static void forEachTest() {
        println("forEach 实例");
        //输出 5个随机数
        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println);

        //获取元素
        List<String> s = Arrays.asList("1", "", "2", "3", "4", "", "5");
        s.forEach(System.out::println);

    }

    //mapTest  实例
    public static void mapTest() {
        //类型转换、去重
        println("mapTest  实例");
        List<String> s = Arrays.asList("1", "2", "2", "3", "4", "1", "50");
        List<Integer> n = s.stream().map(i -> Integer.valueOf(i)).distinct().collect(Collectors.toList());
        n.forEach(System.out::println);
        //获取最小值 输出 ：1
        System.out.println(n.stream().mapToInt(i -> i).min().getAsInt());
        //获取最大值 输出 ：50
        System.out.println(n.stream().mapToInt(i -> i).max().getAsInt());
        //求和 输出 ：60
        System.out.println(n.stream().mapToInt(i -> i).sum());
    }

    //filterTest  实例
    public static void filterTest() {
        println("filterTest  实例");

        List<String> s = Arrays.asList("0", "", "12", "23", "24", "21", "35");
        // 获取空字符串的数量
        long count = s.stream().filter(string -> string.isEmpty()).count();
        System.out.println("空字符串的数量为：" + count);//输出： 空字符串的数量为：1
        //得到新的 List
        List<String> n = s.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        n.forEach(System.out::println);
        sortedTest();
    }

    //sortedTest  实例
    public static void sortedTest() {
        println("sortedTest  实例");

        List<Integer> s = Arrays.asList(0, 12, 23, 24, 21, 35);
        println("默认升序  实例");
        s.stream().sorted().forEach(System.out::println);
        println("降序  实例");
        s.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        collectorsTest();
    }

    //collectorsTest  实例
    public static void collectorsTest() {
        println("collectorsTest  实例");

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("使用逗号隔开并且合并字符串: " + mergedString);
        statisticsTest();

    }

    //statisticsTest  实例
    public static void statisticsTest() {
        println("statisticsTest  实例");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());
    }

    public static void println(String msg) {
        System.err.println(msg + "--------------------------------------------------------");
    }
}
