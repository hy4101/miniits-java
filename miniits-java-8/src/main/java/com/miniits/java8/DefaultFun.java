package com.miniits.java8;

/**
 * @author: WWW.MINIITS.COM
 * @Date: 2017/10/20
 * @Time: 21:43
 * <p>
 * Description:
 * ***
 */
public class DefaultFun{
    public static void main(String args[]){
        Vehicle vehicle = new DF();
        vehicle.print();
    }
}

interface Vehicle {
    default void print(){
        System.out.println("这是个默认方法!");
    }

    static void blowHorn(){
        System.out.println("静态默认方法");
    }
}

interface FourWheeler {
    default void print(){
        System.out.println("这是第二个默认方法!");
    }
}

class DF  implements Vehicle, FourWheeler {
    public void print(){
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
    }
}



















































