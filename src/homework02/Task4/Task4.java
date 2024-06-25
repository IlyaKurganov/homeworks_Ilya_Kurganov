package homework02.Task4;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите число строк и столбцов сетки:");
        int size = sc.nextInt();

        System.out.println("Введите повторяемый элемент сетки:");
        String element = sc.next();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}