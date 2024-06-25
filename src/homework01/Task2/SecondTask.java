package homework01.Task2;

import java.util.Random;

/*
 * Камень - 0, Ножницы - 1, Бумага - 2;
 */

public class SecondTask {
    public static void main(String[] args) {
        Random rmd = new Random();
        int vasya = rmd.nextInt(3), petya = rmd.nextInt(3);

        System.out.println("Вася: " + vasya + " " + "Петя: " + petya);

        if (vasya == petya) {
            System.out.println("Ничья");
        } else {
            if ((vasya == 0 && petya == 1) || (vasya == 1 && petya == 2) || (vasya == 2 && petya == 0)) {
                System.out.println("Выиграл Вася");
            } else {
                System.out.println("Выиграл Петя");
            }
        }
    }
}