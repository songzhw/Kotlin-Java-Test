package threads;
/*
三个不同的线程将会共用一个 Foo 实例。

线程 A 将会调用 one() 方法
线程 B 将会调用 two() 方法
线程 C 将会调用 three() 方法
请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。


示例 2:
输入: [1,3,2]
输出: "onetwothree"
解释:
输入 [1,3,2] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 three() 方法，线程 C 将会调用 two() 方法。
正确的输出是 "onetwothree"。

链接：https://leetcode-cn.com/problems/print-in-order
 */


class Foo {
    public void one() { System.out.println("one"); }
    public void two() { System.out.println("two"); }
    public void three() { System.out.println("three"); }
}

public class PrintInOrder {
    public static void main(String[] args) {
        System.out.println("hello world");
    }
}