package homework04.Task3;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        String inputString = "Sell in may and go away";
        String str = inputString.toLowerCase();
        String[] splitedStr = str.split(" ");
        StringBuilder builder = new StringBuilder();

        for (String s : splitedStr) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String newStr = new String(chars);
            builder.append(newStr).append(" ");
        }
        System.out.println(builder);
    }
}