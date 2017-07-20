package com.oth.testGenerator;

import java.util.Scanner;

/**
 * Created by anyanwen on 2016/11/10 12:02.
 */
public class TestGenerator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("��ʼ���⣺");
        String str = s.next();
        System.out.println("�Ƿ��ظ���Y/N��:");
        String repeat = s.next();
        System.out.println("������");
        int count = s.nextInt();
        if(repeat.equals("Y") || repeat.equals("y")) {
            for (int i = 0; i < count; i++) {
                System.out.println(str);
            }
        } else {
            System.out.println("��ʼֵ��");
            int start = s.nextInt();
            for (int i = 0; i < count; i++) {
                System.out.println(str + start++);
            }
        }
    }
}
