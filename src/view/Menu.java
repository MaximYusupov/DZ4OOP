package view;

import presenter.DemoData;

import java.util.Scanner;

public class Menu
{
    public Menu()

    {
        dd = new DemoData();
    }

    private DemoData dd;

    public void mainMenu() throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int ex = 0;
        do
        {
            System.out.print("Выберите пукт для проверки: \n" +
                    "1. Integer(целые числа)\n" +
                    "2. String(строки)\n" +
                    "3. Double(с плавающей точкой)\n" +
                    "0. Выход\n" +
                    "Введите номер команды -> \n");
            ex = scan.nextInt();
            switch (ex)
            {
                case 1:
                    this.intDemo();
                    break;
                case 2:
                    this.strDemo();
                    break;
                case 3:
                    this.dblDemo();
                    break;
            }
        }
        while (ex != 0);
    }

    private void intDemo() throws Exception
    {
        System.out.println("Пример использования DynArray с типом данных Integer");
        System.out.println(dd.intDA);

        dd.intDA.add(5);
        System.out.println("Добавление в конец элемента со значением 5");
        System.out.println(dd.intDA);

        dd.intDA.add(25, 3);
        System.out.println("Добавление элемента со значением 25 на позицию 3");
        System.out.println(dd.intDA);

        dd.intDA.remove(8);
        System.out.println("Удаление элемента с позиции 8");
        System.out.println(dd.intDA);

        dd.intDA.remove((Integer) 25);
        System.out.println("Удаление элемента со значением 25");
        System.out.println(dd.intDA);

        System.out.println("Минимум");
        System.out.println(dd.intDA.min(Integer::compare));

        System.out.println("Максимум");
        System.out.println(dd.intDA.max(Integer::compare));

        System.out.println("Замена элемента по индексу 5 значением 25");
        dd.intDA.replace(25, 5);
        System.out.println(dd.intDA);

        System.out.println("Длина массива");
        System.out.println(dd.intDA.size());

        System.out.println("Сумма элементов массива");
        System.out.println(dd.intDA.sum());

        System.out.println("Сортировка пузырьком");
        dd.intDA.bubbleSort(Integer::compare);
        System.out.println(dd.intDA);
    }

    private void strDemo() throws Exception
    {
        System.out.println("Пример использования DynArray с типом данных String");
        System.out.println(dd.strDA);

        dd.strDA.add("END");
        System.out.println("Добавление в конец элемента со значением END");
        System.out.println(dd.strDA);

        dd.strDA.add("INTERMEDIATE", 5);
        System.out.println("Добавление элемента со значением INTERMEDIATE на позицию 5");
        System.out.println(dd.strDA);

        dd.intDA.remove(8);
        System.out.println("Удаление элемента с позиции 8");
        System.out.println(dd.strDA);

        dd.strDA.remove("INTERMEDIATE");
        System.out.println("Удаление элемента со значением INTERMEDIATE");
        System.out.println(dd.strDA);

        System.out.println("Минимум (длина строки)");
        System.out.println(dd.strDA.min((s0, s1) -> s0.length() - s1.length()));

        System.out.println("Максимум (длина строки)");
        System.out.println(dd.strDA.max((s0, s1) -> s0.length() - s1.length()));

        System.out.println("Замена элемента по индексу 8 значением EIGHT");
        dd.strDA.replace("EIGHT", 8);
        System.out.println(dd.strDA);

        System.out.println("Длина массива");
        System.out.println(dd.strDA.size());

        System.out.println("Сортировка вставками");
        dd.strDA.insertionSort((s0, s1) -> s0.length() - s1.length());
        System.out.println(dd.strDA);
    }

    private void dblDemo() throws Exception
    {
        System.out.println("Пример использования DynArray с типом данных Double");
        System.out.println(dd.dblDA);

        dd.dblDA.add(8.0);
        System.out.println("Добавление в конец элемента со значением 8.0");
        System.out.println(dd.dblDA);

        dd.dblDA.add(25.0, 3);
        System.out.println("Добавление элемента со значением 25.0 на позицию 3");
        System.out.println(dd.dblDA);

        dd.dblDA.remove(5);
        System.out.println("Удаление элемента с позиции 5");
        System.out.println(dd.dblDA);

        dd.dblDA.remove(25.0);
        System.out.println("Удаление элемента со значением 25.0");
        System.out.println(dd.dblDA);

        System.out.println("Минимум");
        System.out.println(dd.dblDA.min(Double::compare));

        System.out.println("Максимум");
        System.out.println(dd.dblDA.max(Double::compare));

        System.out.println("Замена элемента по индексу 5 значением 33.2");
        dd.dblDA.replace(33.2, 5);
        System.out.println(dd.dblDA);

        System.out.println("Длина массива");
        System.out.println(dd.dblDA.size());

        System.out.println("Сумма элементов массива");
        System.out.println(dd.dblDA.sum());

        System.out.println("Произведение элементов массива");
        System.out.println(dd.dblDA.mul());

        System.out.println("Сортировка выбором");
        dd.dblDA.selectionSort(Double::compare);
        System.out.println(dd.dblDA);
    }
}
