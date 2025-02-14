package com.example;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите три целых неотрицательных числа:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (isTriangle(a, b, c)) {
            System.out.println("Это треугольник.");
            if (a == b && b == c) {
                System.out.println("Треугольник равносторонний.");
            } else if (a == b || b == c || a == c) {
                System.out.println("Треугольник равнобедренный.");
            } else {
                System.out.println("Треугольник разносторонний.");
            }
        } else {
            System.out.println("Это не треугольник.");
        }
    }

    public static boolean isTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
