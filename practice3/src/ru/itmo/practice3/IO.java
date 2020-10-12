package ru.itmo.practice3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class IO {
    static public List<String> task1(String path) throws IOException {
        return Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
    }
    static public void task2(String path, String s) throws IOException {
        Files.writeString(Paths.get(path), s + "\n", StandardOpenOption.APPEND);
    }
    static public void task3(String path1, String path2, String pathResult) throws IOException {
        List<String> f1 = IO.task1(path1);
        List<String> f2 = IO.task1(path2);
        for (String s : f1) {
            task2(pathResult, s);
        }
        for (String s : f2) {
            task2(pathResult, s);
        }
    }
    static public void task4(String sourceString, String destString) throws IOException {
        File source = new File(sourceString);
        File dest = new File(destString);
        Files.copy(source.toPath(), dest.toPath());
    }
    static public List<String> task5(String dir, String target) throws IOException {
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        List<String> lof = new LinkedList<>();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                if (listOfFile.getName().contains(target)) {
                    lof.add(listOfFile.getName());
                }
            }
        }
        return lof;
    }
    static public void task6(String path) throws IOException {
        List<String> ls = IO.task1(path);
        for (String s : ls) {
            System.out.println(s);
            Function<String, String> function = str -> str.toUpperCase();
            System.out.println(function.apply(s));
        }
    }
    public interface Function<T, R> {
        R apply(T t);
    }
}
