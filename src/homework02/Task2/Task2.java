package homework02.Task2;

import java.util.Scanner;

/*
Вывести сумму, разницу, произведение, среднее значение, расстояние
(разница между целыми числами), максимум (большее из двух целых чисел),
минимум (меньшее из двух целых чисел)
 */

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первое целое число:");
        int firstNumber = sc.nextInt();

        System.out.println("Введите второе целое число:");
        int secondNumber = sc.nextInt();

        int minValue, maxValue;

        int sum = firstNumber + secondNumber;
        int difference = firstNumber - secondNumber;
        int product = firstNumber * secondNumber;
        double average = (firstNumber + secondNumber) / 2.0;

        if (firstNumber > secondNumber) {
            maxValue = firstNumber;
            minValue = secondNumber;
        } else {
            maxValue = secondNumber;
            minValue = firstNumber;
        }

        int distance = maxValue - minValue;

        System.out.println("Сумма двух целых чисел " + sum);
        System.out.println("Разница двух целых чисел " + difference);
        System.out.println("Произведение двух целых чисел " + product);
        System.out.println("Среднее из двух целых чисел " + average);
        System.out.println("Расстояние двух целых чисел " + distance);
        System.out.println("Максимальное целое число " + maxValue);
        System.out.println("Минимальное целое число " + minValue);
    }
}