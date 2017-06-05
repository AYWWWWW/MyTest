package com.test;

/**
 * Created by anyanwen on 2016/11/11 14:14.
 */
public class TestSwitchCase {
    public static void main(String[] args) {
        String string = "1";
        switch (string) {
            case "1":
            case "2":
                System.out.println(string);
            default :
                System.out.println("default");
                break;
        }
        return;
    }
}
