package com.miniits.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author: wq
 * @Date: 2017/10/19
 * @Time: 17:18
 * <p>
 * Description:
 * ***
 */
public class MethodReferences {

    private String id = "迷你科技";
    private String url = "www.miniits.com";

    public static MethodReferences get(final Supplier<MethodReferences> supplier) {
        return supplier.get();
    }

    public static void staticFun(final MethodReferences methodReferences) {
        System.out.println("url: " + methodReferences.url);
    }

    public void follow(final MethodReferences methodReferences) {
        System.out.println("id: " + methodReferences.id);
    }

    public void repair() {
        System.out.println("id: " + this.id);
    }

    @Test
    public void test() {
        // 1 、构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：
        final MethodReferences methodReferences = MethodReferences.get(MethodReferences::new);
        final List<MethodReferences> methodReferencesList = Arrays.asList(methodReferences);

        // 2 、静态方法引用：它的语法是Class::static_method，实例如下：
        methodReferencesList.forEach(MethodReferences::staticFun);

        // 3 、特定类的任意对象的方法引用：它的语法是Class::method实例如下
        methodReferencesList.forEach(MethodReferences::repair);

        /**
         * 4 、特定对象的方法引用：它的语法是instance::method实例如下：
         */
        methodReferences.id = "www";
        methodReferencesList.forEach(methodReferences::follow);
    }

    @Test
    public void test2() {
        List<Integer> s = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});
        s.forEach(System.out::println);
    }
}