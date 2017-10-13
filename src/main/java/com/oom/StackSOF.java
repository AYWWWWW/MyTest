package com.oom;

/**
 * vm: Xss160k
 * created by anyanwen on 2017/10/13.
 */
public class StackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackSOF oom = new StackSOF();

        try {
            oom.stackLeak();
        } catch (Throwable expected) {
            System.out.println("stackLength : " + oom.stackLength);
            throw expected;
        }
    }
}
