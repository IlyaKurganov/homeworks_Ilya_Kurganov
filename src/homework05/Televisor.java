package homework05;


import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/*
Исправил – переименовал методы checkFull,checkStatus, checkVolume, checkChannel
         - переопределил метод toString
*/

/*
Реализован класс Televisor. Конструкторы позволяют создавать экземляр без ввода переменных,
так и с ними. Для того чтобы не нарушить логику работы, есть некоторые неявные ограничения:
при создании экземляра выключенного телевизора - показатели громкости и канала останутся
по умолчанию. Также нет возможности создать экземпляр выключенного ТВ с установленным звуком и
каналом. Можно создать включенный телезивизор с установленным каналом, и громкостью по умолчанию.

В классе реализованы методы управления телевизором и проверки состояния:

## Включение-выключение ##
• turnOn – включение ТВ (по умолчанию включает Нулевой канал и устанавливает громкость на 3);
• turnOff - выключение ТВ (выключает каналы – null (на экране ничего), устанавливает громкость на 0);

## Работа с каналами ##
• getChannelsList – получить список всех возможных каналов
• setChannel - позволяет ввести номер канала от 0-9, и переключиться на него; нельзя менять
   канал пока ТВ выключен и выбрать канал вне диапазона - вылезет предупреждение;
• setRandomChannel - позволяет установить рандомный канал, нельзя вызвать пока
   ТВ выключен - вылезет предупреждение;

 ## Работа со звуком ##
• setVolume - позволяет ввести номер от 0-9, и установить громкость ; нельзя менять
   громкость пока ТВ выключен и выбрать громкость вне диапазона - вылезет предупреждение;
• muteVolume - устанавливает громкость на 0

## Информация о состоянии ##
• checkFull - выводит в консоли состояние ТВ;
• checkStatus – возвращает boolean значение - включен ТВ или нет
• checkVolume– возвращает int значение - уровень громкости
• checkChannel – возвращает String значение - какой канал
 */
public class Televisor {
    private boolean status;
    private int volume;

    private String model;
    private int channel;
    private final int[] channels = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public Televisor() {

    }

    public Televisor(String model, boolean status, int ch, int volume) {
        this.status = status;
        if (this.status) {
            this.channel = channels[ch];
            this.volume = volume;
        }
        this.model = model;

    }

    public Televisor(String model, boolean status, int ch) {
        this.status = status;
        if (this.status) {
            this.channel = channels[ch];
            this.volume = 10;
        }
        this.model = model;

    }

    public Televisor(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Televisor televisor)) return false;
        return status == televisor.status && volume == televisor.volume && channel == televisor.channel && Objects.equals(model, televisor.model) && Arrays.equals(channels, televisor.channels);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(status, volume, model, channel);
        result = 31 * result + Arrays.hashCode(channels);
        return result;
    }

    public void turnOn() {
        this.status = true;
        this.channel = channels[0];
        this.volume = 10;
    }

    public void turnOff() {
        this.status = false;
        this.volume = 0;
        this.channel = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVolume(int volume) {
        if (volume <= 0 || volume >= 100) {
            System.out.println("Громкость может быть от 0 до 100 включительно");
        } else if (!this.status) {
            System.out.println("Невозможно менять громкость пока ТВ выключен");
        } else {
            this.volume = volume;
        }
    }

    public void setRandomVolume() {
        if (!this.status) {
            System.out.println("Невозможно менять канал пока ТВ выключен");
        } else {
            Random randomVolume = new Random();
            this.volume = randomVolume.nextInt(101);
        }
    }

    public void muteVolume() {
        this.volume = 0;
    }

    public void getChannelsList() {
        System.out.println("Список каналов:");
        for (int ch : channels) {
            System.out.println("- " + ch + " канал");
        }
    }

    public void setChannel(int ch) {
        if (ch < 0 || ch > 9) {
            System.out.println("Всего 10 каналов (диапазон 0-9 включительно)");
        } else if (!this.status) {
            System.out.println("Невозможно менять канал пока ТВ выключен");
        } else {
            this.channel = channels[ch];
        }
    }

    public void setRandomChannel() {
        if (!this.status) {
            System.out.println("Невозможно менять канал пока ТВ выключен");
        } else {
            Random rdm = new Random();
            this.channel = channels[rdm.nextInt(10)];
        }
    }

    public void checkFull() {
        System.out.println("**********");
        System.out.print("Текущий статус: Телевизор — ");
        if (!this.status) {
            System.out.println("выключен");
            System.out.println("**********");

        } else {
            System.out.println("включен");
            System.out.println("Вы смотрите: " + this.channel);
            System.out.println("Громкость: " + this.volume);
            System.out.println("**********");
        }

    }

    @Override
    public String toString() {
        return "Televisor{" +
                "model=" + model +
                ", status=" + status +
                ", volume='" + volume + '\'' +
                ", channel=" + channel +
                '}';
    }

    public boolean checkStatus() {
        return this.status;
    }

    public int checkVolume() {
        return this.volume;
    }

    public int checkChannel() {
        return this.channel;
    }
}
