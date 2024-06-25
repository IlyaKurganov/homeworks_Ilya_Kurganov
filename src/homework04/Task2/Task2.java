package homework04.Task2;

public class Task2 {
    public static void main(String[] args) {
        String str = ">>--><--<<>>--><--<<--><<>>-->><--<<>>--><--<<--><<>>-->><--<<--><<>>--><--<<>>--><--<<--><<>>--><--<<>>-->";
        String arrowOne = ">>-->";
        String arrowTwo = "<--<<";

        int arrowOneQuantity = 0;
        int arrowTwoQuantity = 0;

        for (int i = 0; i < str.length(); i++) {
            String cutString = str.substring(i);
            if (cutString.length() >= 5) {
                String checkString = cutString.substring(0, 5);
                if (checkString.equals(arrowOne)) {
                    arrowOneQuantity++;
                }
                if (checkString.equals(arrowTwo)) {
                    arrowTwoQuantity++;
                }
            } else {
                break;
            }
        }

        System.out.println(arrowOneQuantity);
        System.out.println(arrowTwoQuantity);

    }
}