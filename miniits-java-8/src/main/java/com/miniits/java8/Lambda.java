package com.miniits.java8;

import org.junit.Test;

/**
 * @author: wq
 * @Date: 2017/10/17
 * @Time: 20:46
 * <p>
 * Description:
 * ***
 */
public class Lambda {
    @Test
    public void LambdaTest() {

        // 类型声明-不带花括号
        ILambda addition = (int a, int b) -> a + b;
        // 不用类型声明-不带-不带花括号
        ILambda subtraction = (a, b) -> a - b;
        // -不带花括号中的返回语句
        ILambda multiplication = (int a, int b) -> {
            return a * b;
        };
        // 没有-不带花括号及返回语句
        ILambda division = (int a, int b) -> a / b;

        System.out.println(fun(1, 2, addition));
        System.out.println(fun(1, 2, subtraction));
        System.out.println(fun(1, 2, multiplication));
        System.out.println(fun(1, 2, division));
    }

    interface ILambda {
        int lm(int a, int b);
    }

    private int fun(int a, int b, ILambda mathOperation) {
        return mathOperation.lm(a, b);
    }

}
