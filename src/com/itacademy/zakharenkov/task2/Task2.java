package com.itacademy.zakharenkov.task2;

import java.util.Scanner;

/*
 * Created by Roman Zakharenkov on 13.07.2018.
 *
 * It-academy.
 * Lesson 2. Homework 2.
 * Task 2.
 *
 * Имеются два дома размерами a на b и c на d. Размеры вводятся
    польователем с консоли.
    Проверить, помещаются ли эти дома на участке размерами e на f.
    Стороны домов - параллельны сторонам участка, в остальном
    размещение может быть любым.
 *
 */
public class Task2 {

    //Так как в условии ничего не сказано о типах размерах, я решил использовать int,
    //также можно использовать double.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размеры первого дома (a x b):");
        System.out.println("Введите a:");
        int a = scanner.nextInt();
        System.out.println("Введите b:");
        int b = scanner.nextInt();

        System.out.println("Введите размеры второго дома (c x d):");
        System.out.println("Введите c:");
        int c = scanner.nextInt();
        System.out.println("Введите d:");
        int d = scanner.nextInt();

        System.out.println("Введите размеры участка (e x f):");
        System.out.println("Введите e:");
        int e = scanner.nextInt();
        System.out.println("Введите f:");
        int f = scanner.nextInt();

        if (isGetInside(a, b, c, d, e, f)) {
            System.out.println("Два дома помещаются на участке");
        } else {
            System.out.println("Два дома не помещаются на учатске");
        }
    }
    public static boolean isGetInside(int a, int b, int c, int d, int e, int f) {
        boolean result = false;
        if ((max(a, b) <= max(e, f)) && (max(c, d) <= max(e, f)))  {
            if ((min(a, b) + min(c, d)) <= min(e, f)) {
                result = true;
            } else if (((min(a, b) <= min(e, f)) && (min(c, d) <= min(e, f))) && ((max(a, b) + max(c, d)) <= max(e, f))) {
                result = true;
            } else if (((min(a, b) + min(c, d)) <= max(e, f)) && (max(max(a, b), max(c, d)) <= min(e, f))) {
                result = true;
            }
        }
        return result;
    }
    public static int max(int a, int b) {
        return a >= b ? a : b;
    }
    public static int min(int a, int b) {
        return a <= b ? a : b;
    }
}
