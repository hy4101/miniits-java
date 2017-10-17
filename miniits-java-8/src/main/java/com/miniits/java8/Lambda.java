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
    public void main() {

//        Lambda tester = new Lambda();
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + operate(10, 5, addition));
        System.out.println("10 - 5 = " + operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }




    @Test
    public void aa() {
        T t = (int a, int q) -> a + q;
        T t1 = (int a, int q) -> a * q;
        System.out.println(t.tt(1, 3));
        System.out.println(t1.tt(1, 3));
    }

    interface T {
        int tt(int q, int w);
    }
}
