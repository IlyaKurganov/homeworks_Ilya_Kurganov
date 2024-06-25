package homework02.Task3;

import java.util.Scanner;
import java.util.StringJoiner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите строку:");
        String str = sc.nextLine();


        System.out.println("Введите количество повторений");
        int cycles = sc.nextInt();

        StringJoiner joiner = new StringJoiner("");
        for (int i = 0; i < cycles; i++) {
            joiner.add(str);
        }
        String joined = joiner.toString();
        System.out.println(joined);
    }
}