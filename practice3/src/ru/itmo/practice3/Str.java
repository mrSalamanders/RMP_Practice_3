package ru.itmo.practice3;

import java.util.*;

public class Str {
    public static String task1(List<String> ls) {
        int maxLength = 0;
        String longestString = "";
        for (String s : ls) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }
        return longestString;
    }
    public static Boolean task2(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static List<String> task3(List<String> ls) {
        List<String> nls = new ArrayList<>();
        for (String s : ls) {
            nls.add(s.replaceAll("(бяка)", "[вырезано цензурой]"));
        }
        return nls;
    }
    public static Integer task4(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
    public static String task5(String str) {
        String[] words = str.split(" ");
        StringBuilder revString = new StringBuilder();
        for (String word : words) {
            StringBuilder reverseWord = new StringBuilder();
            for (int j = word.length() - 1; j >= 0; j--) {
                reverseWord.append(word.charAt(j));
            }
            revString.append(reverseWord).append(" ");
        }
        return revString.toString();
    }
    public static void task6(String text) {
        text = text.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if(ch >= 'а' && ch <= 'я'){
                map.compute(ch, (character, integer) -> integer == null ? 1 : integer + 1);
            }
        }
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> Character.compare(o1.getKey(), o2.getKey()));
        for(Map.Entry<Character, Integer> entry : entries){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public static String task7(String str, Integer[] k, Boolean isCoded) {
        if (!(k.length == 6)) {
            return "Invalid key";
        }
        for (Integer integer : k) {
            if (integer > 5 || integer < 0) {
                return "Invalid key";
            }
        }

        Integer height = 1;
        while (height * 5 < str.length() - Str.task4(str, "&")) {
            height++;
        }
        Map<Integer, String> m = new HashMap<>();
        int index = 0;
        if (!isCoded) {
            for (Integer I : k) {
                StringBuilder boof = new StringBuilder();
                for (int i = 0; i < height; i++) {
                    if (index < str.length()) {
                        boof.append(str.charAt(index));
                        index++;
                    } else {
                        boof.append("&");
                    }
                }
                m.put(I, boof.toString());
            }
            ArrayList<Map.Entry<Integer, String>> entries = new ArrayList<>(m.entrySet());
            entries.sort((o1, o2) -> Integer.compare(o1.getKey(), o2.getKey()));
            StringBuilder res = new StringBuilder();
            for (Map.Entry<Integer, String> entry : entries){
                res.append(entry.getValue());
            }
//            System.out.println(m);
            return res.toString();
        } else {
            Integer[] nk = {0, 1, 2, 3, 4, 5};
            for (Integer I : nk) {
                StringBuilder boof = new StringBuilder();
                for (int i = 0; i < height; i++) {
                    if (index < str.length()) {
                        boof.append(str.charAt(index));
                        index++;
                    }
                }
                m.put(I, boof.toString());
            }
            ArrayList<Map.Entry<Integer, String>> entries = new ArrayList<>(m.entrySet());
            StringBuilder res = new StringBuilder();
            for (Integer I : k) {
                for (Map.Entry<Integer, String> entry : entries){
                    if (I.equals(entry.getKey())) {
                        res.append(entry.getValue());
                    }
                }
            }
//            System.out.println(m);
            return res.toString().replaceAll("&","");
        }
    }
}
