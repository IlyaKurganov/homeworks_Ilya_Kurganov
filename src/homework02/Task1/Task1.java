package homework02.Task1;

import java.util.Scanner;

/*
Для перевода градусов Фаренгейта в градусы Цельсия выполните следующие шаги:
1. Отнимите от температуры, измеренной в Фаренгейте, 32.
2. Полученное значение умножьте на 5.
3. Разделите результат на 9.
*/

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите температуру в Фаренгейтах (целое число): ");
        if (sc.hasNextInt()) {
            double tempFahr = sc.nextInt();
            double tempCels = (tempFahr - 32) * 5 / 9.0;
            System.out.println(tempFahr + " градусов по Фаренгейту равна " + tempCels + " по Цельсию");
        } else {
            System.out.println("Вы ввели не целое число или не число вовсе, попробуйте еще раз");
        }

    }
}