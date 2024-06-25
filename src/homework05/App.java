package homework05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Создаю массив на 10 объектов Televisor
        Televisor[] tvs = new Televisor[10];

        // В Цикле задаю им статус, названия и устанавливаю канал и громкость на
        // рандомное значение в заданном диапазоне
        for (int i = 0; i < 10; i++) {
            tvs[i] = new Televisor("tv" + i);
            System.out.println("Включить ТВ " + i + "? (да/нет)");
            if ((scanner.nextLine()).equals("да")) {
                tvs[i].turnOn();
                tvs[i].setRandomVolume();
                tvs[i].setRandomChannel();
            }
        }

        // Проверяю в консоли как назвались объекты и их состояние
        for (int i = 0; i < tvs.length; i++) {
            System.out.println(tvs[i].toString());
        }

        // Сортирую массив через компаратор по каналам
        Arrays.sort(tvs, Comparator.comparing(Televisor::checkChannel));

        // Задаю максимальную громкость через консоль
        System.out.println("Введите максимальную громкость:");
        int maxVolume = scanner.nextInt();

        // Отображаю в консоли через цикл объекты по возрастанию канала и
        // со звуком меньше максимального

        for (int i = 0; i < tvs.length; i++) {
            if ((tvs[i].checkVolume() < maxVolume) && tvs[i].checkStatus()) {
                System.out.println(tvs[i].toString());
                }
        }





    }
}