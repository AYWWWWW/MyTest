package com.oth.RegAnalysis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anyanwen on 2016/11/8 17:25.
 */
public class UsernameAnalysis {

    public static void main(String[] args) {
        Map<String,Integer> userMap = new HashMap<>();
        userMap = readDataToMap("C:\\Users\\OneAPM\\Desktop\\user.dat");
        ArrayList<String> badUserList = new ArrayList<>();
        getGoodUser(userMap, "C:\\Users\\OneAPM\\Desktop\\output.txt");
        return;
    }

    private static void getGoodUser(Map<String,Integer> userMap, String path) {
        File file = new File(path);
        String reg = "TEST200[0-3][0-9][0-9][0-9]";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String temp = null;
            temp = br.readLine();
            while (temp != null) {
                if(isMatch(temp, reg))
                    userMap.remove(temp);
                temp = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> readBadDataToList(String path) {
        File file = new File(path);
        ArrayList<String> result = null;
        String reg = "TEST200[0-3][0-9][0-9][0-9]";
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String temp = null;
            temp = br.readLine();
            result = new ArrayList<String>();
            while (temp != null) {
                if(isMatch(temp, reg))
                    result.add(temp);
                temp = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static boolean isMatch(String str, String reg) {
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }


    private static Map<String, Integer> readDataToMap(String path) {
        File file = new File(path);
        Map<String,Integer> result = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String temp = null;
            temp = br.readLine();
            result = new HashMap<>();
            while (temp != null) {
                result.put(temp,1);
                temp = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
