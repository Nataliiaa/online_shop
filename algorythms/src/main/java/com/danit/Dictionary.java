package com.danit;

import java.security.KeyStore;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary {
  public String main(String origin) {
    String[] in = origin.split(" ");
    TreeMap<String, Integer> dict = new TreeMap<>();

    for (int i = 0; i < in.length; i++) {
      int count = (dict.containsKey(in[i])) ? dict.get(in[i]) + 1 : 1;
      dict.put(in[i], count);
    }
    StringBuilder sb = new StringBuilder();
    dict.forEach((str, count) -> sb.append(str + ": " + count+"\n"));
    return sb.toString();
  }

  public String main2(String origin) {
    return Stream.of(origin.split(" "))
        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
        .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
        .map(e -> String.format("%s: %d\n",e.getKey(),e.getValue()))
        .collect(Collectors.joining(""));
  }


}
