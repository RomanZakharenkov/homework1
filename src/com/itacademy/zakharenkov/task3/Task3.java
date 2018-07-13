package com.itacademy.zakharenkov.task3;

import java.util.Scanner;

import static java.lang.Math.sqrt;

/*
 * Created by Roman Zakharenkov on 13.07.2018.
 *
 * It-academy.
 * Lesson 2. Homework 2.
 * Task 3.
 *
 * Написать программу, вычисляющую корни квадратного уравнения
    вида ax ² + bx + c = 0, где a, b и c - вводимые пользователем из консоли
    данные.
    Учитывать только реальные корни (в случае отрицательного
    дискриминанта выводить сообщение пользователю).
    При решении создать и использовать следующие вынесенные
    функции:
    - функция isPositive, определяющая, является ли число
    положительным
    - функция isZero, определяющая, является ли число нулём
    - функция discriminant, вычисляющая дискриминант
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите коэффициенты (a, b, c) квадратного уравнения ax² + bx + c = 0:");
        System.out.println("Введите a (a > 0 или a < 0):");
        double a = scanner.nextDouble();

        System.out.println("Введите b:");
        double b = scanner.nextDouble();

        System.out.println("Введите c:");
        double c = scanner.nextDouble();

        if (!isZero(a)) {
            // Одно из условий квадратного уравнения: а не равно 0
            if (isPositive(discriminant(a, b, c))) {
                System.out.println("Корни квадратного уравнения:");
                System.out.println("x1 = " + (-b + sqrt(discriminant(a, b, c)))/ (2*a));
                System.out.println("x2 = " + (-b - sqrt(discriminant(a, b, c)))/ (2*a));
            } else if (isZero(discriminant(a, b, c))){
                System.out.println("Корень квадратного уравнения:");
                System.out.println("x = " + (-b) / (2*a));
            } else {
                System.out.println("Уравнение не имеет корней. Дискриминант меньше нуля");
            }
        } else {
            System.out.println("Ошибка! Коэффициент a = 0!");
        }

    }
    public static boolean isPositive(double number) {
        return number > 0 ? true : false;
    }
    public static boolean isZero(double number) {
        return number == 0 ? true : false;
    }
    public static double discriminant(double a, double b, double c) {
        return b*b - 4*a*c;
    }

}
