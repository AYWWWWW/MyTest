package com.oth.FI;

import java.util.*;

/**
 * Created by anyanwen on 2016/11/28 11:25.
 */
public class FI1 {
    private List<String> words = new ArrayList<String>();

    Comparator<String > cmp = (s1, s2) ->{
        return Integer.compare(s1.length(), s2.length());
    };

    public FI1() {
        init();
}

    private void init() {
        initStringList();
    }

    private void initStringList() {
        words.add("aaa1");
        words.add("bbb12");
        words.add("ccc123");
        words.add("ddd11234");
        words.add("abc1444");
        words.add("acb1");
        words.add("bcv1323");
        words.add("dsc1");
        words.add("1aad");
    }

    public void useStreamFilter() {
        words.stream().filter((s -> s.startsWith("a"))).forEach(System.out::println);
    }

    public void useStreamSort() {
        words.stream().sorted(cmp).forEach(System.out::println);

        words.stream().forEach(System.out::println);
    }

    public void useStreamMap() {
        words.stream().map(String::length).sorted(Integer::compare).forEach(System.out::println);

        words.forEach(System.out::println);
    }

    public void useStreamReduce() {
        Optional<String> wordsCombine = words.stream().sorted().reduce((w1, w2) -> w1 + "#" + w2);

        wordsCombine.ifPresent(System.out::print);
        System.out.print(wordsCombine.get());
    }

    public void useParallelStreamSort() {
        int max = 1000000;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < max ; i++) {
            UUID uuid = UUID.randomUUID();
            list.add(uuid.toString());
        }

        long sequenceT0 = System.nanoTime();
        list.stream().sorted();
        long sequenceT1 = System.nanoTime();
        System.out.println("sequence : " + (sequenceT1 - sequenceT0));

        long parallelT0 = System.nanoTime();
        list.parallelStream().sorted();
        long parallelT1 = System.nanoTime();
        System.out.println("parallel : " + (parallelT1 - parallelT0));

    }

}
