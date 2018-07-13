package com.itacademy.zakharenkov.task1;

import java.util.Scanner;

/*
 * Created by Roman Zakharenkov on 13.07.2018.
 *
 * It-academy.
 * Lesson 2. Homework 2.
 * Task 1.
 *
 * Имеются три числа - день, месяц и год, вводимые пользователем с консоли.
    Вывести дату следующего дня в формате &quot;День.Месяц.Год&quot;
    Учесть переход на следующий месяц, а также следующий год.
    Форматирование строки &quot;День.Месяц.Год&quot; вынести в отдельную функцию.
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите день:");
        int day = scanner.nextInt();

        System.out.println("Введите месяц:");
        int month = scanner.nextInt();

        System.out.println("Введите год:");
        int year = scanner.nextInt();

        if (!isDateValid(day, month, year)) {
            System.out.println("Дата введена некорректно!");
        } else if (isDateValid(day + 1, month, year)) {
            print(day + 1, month, year);
        } else if (isDateValid(1, month + 1, year)) {
            print(1, month + 1, year);
        } else {
            print(1, 1, year + 1);
        }
    }
    public static boolean isDateValid(int day, int month, int year) {
        boolean result = true;
        if (day <= 0 || day > 31) {
            result = false;
        }
        if (month <= 0 || month > 12) {
            result = false;
        }
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 31) {
                    result = false;
                }
                break;
            case 2:
                if (isTemporal(year)) {
                    if (day > 29) {
                        result = false;
                    }
                } else {
                    if (day > 28) {
                        result = false;
                    }
                }
                break;
        }

        return result;
    }
    public static boolean isTemporal(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void print(int day, int month, int year) {
        System.out.println("Следующий день:");
        System.out.println(day + "." + month + "." + year);
    }
}
