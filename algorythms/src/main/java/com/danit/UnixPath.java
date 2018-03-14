package com.danit;

import java.util.*;

public class UnixPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String src = in.nextLine();
        String[] path = src.split("/");
        Deque<String> listIn = new LinkedList<>();
        Deque<String> listOut = new LinkedList<>();

        for (int i = 0; i < path.length; i++) {
            listIn.add(path[i]);
        }

        while (!listIn.isEmpty()) {
            String s = listIn.poll();
            switch (s) {
                case ".." :
                    if (!listOut.isEmpty()) {
                        listOut.pop();
                    }
                    break;

                case "." :
                    break;

                case "" :
                    break;

                default :
                    listOut.push(s);
                    break;
            }
        }

        if (listOut.isEmpty()) {
            listOut.add("");
        }

        StringBuilder sb = new StringBuilder();

        while (!listOut.isEmpty()) {
            sb.append("/").append(listOut.pop());
        }

        System.out.println(sb);
    }
}
