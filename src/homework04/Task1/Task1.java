package homework04.Task1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String standartKeyboard = "qwertyuiopasdfghjklzxcvbnm";
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        char inputLetter = inputString.charAt(0);
        char performedLetter = Character.toLowerCase(inputLetter);

        if (standartKeyboard.indexOf(performedLetter) == 0) {
            System.out.println(standartKeyboard.charAt(standartKeyboard.length() - 1));
        } else {
            System.out.println(standartKeyboard.charAt(standartKeyboard.indexOf(performedLetter) - 1));
        }
    }
}