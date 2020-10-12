package ru.itmo.practice3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        int choose = 1;
        while (choose != 0) {
            System.out.println("Please give me file number 1-3 (0 for quit)");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    first();
                    break;
                case 2:
                    second();
                    break;
                case 3:
                    third();
                    break;
                case 0:
                    System.out.println("На нет и суда нет");
                    break;
                default:
                    System.out.println("1-3 либо 0");
                    break;
            }
        }
    }
    public static void first() throws IOException {
        int choose = 1;
        while (choose != 0) {
            System.out.println("Please give me task number 1-6 (0 for quit)");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    List<String> ls = IO.task1("/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/tekst.txt");
                    for(String s : ls) {
                        System.out.println(s);
                    }
                    break;
                case 2:
                    String str = "Privet";
                    IO.task2("/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/tekst 2.txt", str);
                    break;
                case 3:
                    IO.task3("/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/tekst.txt", "/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/tekst 2.txt", "/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/tekst 3.txt");
                    break;
                case 4:
                    IO.task4("/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/tekst 4.txt", "/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/tekst 4 COPY.txt");
                    break;
                case 5:
                    List<String> l = IO.task5("/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/", " ");
                    for (String s : l) {
                        System.out.println(s);
                    }
                    break;
                case 6:
                    IO.task6("/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/tekst.txt");
                    break;
                case 0:
                    System.out.println("На нет и суда нет");
                    break;
                default:
                    System.out.println("1-6 либо 0");
                    break;
            }
        }
    }
    public static void second() throws IOException {
        int choose = 1;
        while (choose != 0) {
            System.out.println("Please give me task number 1-7 (0 for quit)");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    List<String> ls = IO.task1("/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/tekst.txt");
                    System.out.println(Str.task1(ls));
                    break;
                case 2:
                    String pal = "abcba";
                    String notPal = "cook";
                    System.out.println(Str.task2(pal));
                    System.out.println(Str.task2(notPal));
                    break;
                case 3:
                    List<String> ls2 = IO.task1("/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/baka.txt");
                    System.out.println(ls2);
                    System.out.println(Str.task3(ls2));
                    break;
                case 4:
                    System.out.println(Str.task4("asdasdf asd fff g", "asd"));
                    break;
                case 5:
                    System.out.println("Everyone can cook");
                    System.out.println(Str.task5("Everyone can cook"));
                    break;
                case 6:
                    String content = new String(Files.readAllBytes(Paths.get("/Users/mrsalamanders/Desktop/ИТМО/Разработка мобильных приложений/JAVA/practice3/Русский текст.txt")), StandardCharsets.UTF_8);
                    Str.task6(content);
                    break;
                case 7:
                    Integer[] key = {3, 0, 2, 1, 5, 4};
                    String coded = Str.task7("ВРАГБУДЕТРАЗБИТ", key, false);
                    System.out.println("ШИФР: " + coded);
                    System.out.println("РАСШИФРОВКА: " + Str.task7(coded, key, true));
                    break;
                case 0:
                    System.out.println("На нет и суда нет");
                    break;
                default:
                    System.out.println("1-7 либо 0");
                    break;
            }
        }
    }
    public static void third() throws InterruptedException {
        int choose = 1;
        while (choose != 0) {
            System.out.println("Please give me task number 1-4 (0 for quit)");
            Scanner scanner = new Scanner(System.in);
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    Trd.task1();
                    break;
                case 2:
                    Trd.task2();
                    break;
                case 3:
                    Trd.task3();
                    break;
                case 4:
                    Trd.task4();
                    break;
                case 0:
                    System.out.println("На нет и суда нет");
                    break;
                default:
                    System.out.println("1-4 либо 0");
                    break;
            }
        }
    }
}
