package com.testGenerator;

import java.util.Scanner;

/**
 * Created by anyanwen on 2016/11/10 12:02.
 */
public class TestGenerator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("起始标题：");
        String str = s.next();
        System.out.println("是否重复（Y/N）:");
        String repeat = s.next();
        System.out.println("数量：");
        int count = s.nextInt();
        if(repeat.equals("Y") || repeat.equals("y")) {
            for (int i = 0; i < count; i++) {
                System.out.println(str);
            }
        } else {
            System.out.println("起始值：");
            int start = s.nextInt();
            for (int i = 0; i < count; i++) {
                System.out.println(str + start++);
            }
        }
    }
}
