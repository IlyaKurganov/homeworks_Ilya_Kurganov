package homework03;


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
    private String channel;
    private final String[] channels = {
            "Нулевой канал",
            "Первый канал",
            "Второй канал",
            "Третий канал",
            "Четвертый канал",
            "Пятый канал",
            "Шестой канал",
            "Седьмой канал",
            "Восьмой канал",
            "Девятый канал"};

    public Televisor() {

    }

    public Televisor(boolean status, int ch, int volume) {
        this.status = status;
        if (this.status) {
            this.channel = channels[ch];
            this.volume = volume;
        }

    }

    public Televisor(boolean status, int ch) {
        this.status = status;
        if (this.status) {
            this.channel = channels[ch];
            this.volume = 3;
        }

    }


    public void turnOn() {
        this.status = true;
        this.channel = channels[0];
        this.volume = 3;
        System.out.println("Телевизор включен! Приятного просмотра");
    }

    public void turnOff() {
        this.status = false;
        this.volume = 0;
        this.channel = null;
        System.out.println("Телевизор выключен! Отдыхайте");
    }

    public void setVolume(int volume) {
        if (volume < 0 || volume > 9) {
            System.out.println("Громкость может быть от 0 до 9 включительно");
        } else if (!this.status) {
            System.out.println("Невозможно менять громкость пока ТВ выключен");
        } else {
            this.volume = volume;
            System.out.println("Установлена громкость: " + this.volume);
        }
    }

    public void muteVolume() {
        this.volume = 0;
        System.out.println("Установлена громкость: " + this.volume);
    }

    public void getChannelsList() {
        System.out.println("Список каналов:");
        for (String ch : channels) {
            System.out.println("- " + ch);
        }
    }

    public void setChannel(int ch) {
        if (ch < 0 || ch > 9) {
            System.out.println("Всего 10 каналов (диапазон 0-9 включительно)");
        } else if (!this.status) {
            System.out.println("Невозможно менять канал пока ТВ выключен");
        } else {
            this.channel = channels[ch];
            System.out.println("Включен: " + this.channel);
        }
    }

    public void setRandomChannel() {
        if (!this.status) {
            System.out.println("Невозможно менять канал пока ТВ выключен");
        } else {
            Random rdm = new Random();
            this.channel = channels[rdm.nextInt(10)];
            System.out.println("Вы смотрите " + this.channel);
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
                "status=" + this.status +
                ", volume=" + this.volume +
                ", channel='" + this.channel + '\'' +
                '}';
    }

    public boolean checkStatus() {
        return this.status;
    }

    public int checkVolume() {
        return this.volume;
    }

    public String checkChannel() {
        return this.channel;
    }
}
