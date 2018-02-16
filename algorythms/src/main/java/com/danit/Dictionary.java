package com.danit;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary {

    public String methodOne(String origin) {
        // we are using ScannerFromString for tests within IDEA
        //ScannerFromString in = new ScannerFromString(origin);
        // we are using Scanner for tests on codegym.in.ua
        Scanner in = new Scanner(System.in);

        TreeMap<String, Integer> dict = new TreeMap<>();

        while (in.hasNext()) {
            String item = in.next();
            //int count = dict.containsKey(item) ? dict.get(item) : 0;
            int count = dict.getOrDefault(item, 0);
            dict.put(item, ++count);
        }
        StringBuilder sb = new StringBuilder();
        dict.forEach((str, count) -> sb.append(str).append(": ").append(count).append("\n"));

        // for codegym test
        System.out.println(sb.toString());
        // for testing purposes
        return sb.toString();
    }

    public String methodTwo(String origin) {
        return Stream.of(origin.split(" "))
            .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
            .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
            .map(e -> String.format("%s: %d\n",e.getKey(),e.getValue()))
            .collect(Collectors.joining(""));
    }


}
