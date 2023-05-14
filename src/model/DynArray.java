package model;

import java.util.Arrays;
import java.util.Comparator;

public class DynArray<T>
{
    public DynArray()
    {
        this.size = 0;
        this.length = 10;
        this.db = (T[]) new Object[this.length];

    }

    public DynArray(T[] db)
    {
        this();
        for (T element : db)
        {
            this.add(element);
        }
    }

    private T[] db;
    private int size;
    private int length;

    public void add(T element) // Добавление элемента в конец массива
    {
        checkArrLen();
        db[size++] = element;
    }

    public void add(T element, int index) // Добавление элемента(Элемент, Индекс вставки)
    {
        checkArrLen();
        for (int i = size; i > index; i--)
        {
            db[i] = db[i - 1];
        }
        size++;
        db[index] = element;
    }

    private void checkArrLen() // Проверка размера массива
    {
        if (size > 0 && (double) size / length > 0.8) // Если занято больше 80% массива, добавляем 20%
        {
            length = (int) (length * 1.2);
            db = Arrays.copyOf(db, length);
        }
        if (size > 10 && (double) size / length < 0.3) // Если занято менее 30%, то отнимаем 50%
        {
            length = (int) (length * 0.5);
            db = Arrays.copyOf(db, length);
        }
    }

    public T remove(int index) // Удаление эелемента из массива по заданному индексу
    {
        T res = null;
        if (index < size)
        {
            res = db[index];
            for (int i = index; i < size; i++)
            {
                db[i] = db[i + 1];
            }
            size--;
            checkArrLen();
        }
        return res;
    }

    public int remove(T element) // Удаление всех элементов с заданным значением
    {
        int count = 0;
        for (int i = 0; i < size; i++)
        {
            if (db[i].equals(element))
            {
                remove(i);
                count++;
            }
        }
        return count; // Количество удаленных элементов
    }

    public T min(java.util.Comparator<? super T> comparator) // Поиск минимального значения
    {
        T minRes = db[0];
        for (int i = 1; i < size; i++)
        {
            if (comparator.compare(minRes, db[i]) > 0)
                minRes = db[i];
        }
        return minRes;
    }

    public T max(java.util.Comparator<? super T> comparator) // Поиск максимального значения
    {
        T maxRes = db[0];
        for (int i = 1; i < size; i++)
        {
            if (comparator.compare(maxRes, db[i]) < 0)
                maxRes = db[i];
        }
        return maxRes;
    }

    public T sum() throws Exception // Суммирование элементов массива, если это возможно. Исключение, при несоответствии типа.
    {
        if (db[0] instanceof Long || db[0] instanceof Integer || db[0] instanceof Short || db[0] instanceof Byte)
        {
            Long sumRes = 0L;
            for (int i = 0; i < size; i++)
                sumRes += ((Number) db[i]).longValue();
            return (T) sumRes;
        }
        else if (db[0] instanceof Double || db[0] instanceof Float)
        {
            Double sumRes = 0.0;
            for (int i = 0; i < size; i++)
                sumRes += ((Number) db[i]).doubleValue();
            return (T) sumRes;
        }
        else
            throw new Exception(db[0].getClass().getSimpleName() + " невозможно суммировать");
    }

    public T mul() throws Exception // Перемножение элементов массива, Overflow не учитывается
    {
        if (db[0] instanceof Long || db[0] instanceof Integer || db[0] instanceof Short || db[0] instanceof Byte)
        {
            Long mulRes = 1L;
            for (int i = 0; i < size; i++)
                mulRes *= ((Number) db[i]).longValue();
            return (T) mulRes;
        }
        else if (db[0] instanceof Double || db[0] instanceof Float)
        {
            Double mulRes = 1.0;
            for (int i = 0; i < size; i++)
                mulRes *= ((Number) db[i]).doubleValue();
            return (T) mulRes;
        }
        else
            throw new Exception(db[0].getClass().getSimpleName() + " невозможно суммировать");
    }

    public Integer find(T element) // Поиск индекса заданного элемента в массиве
    {
        for (int i = 0; i < size; i++)
        {
            if (element.equals(this.db[i])) return i;
        }
        return -1; // Индекс массива, если нет совпадений - возвращает -1
    }

    public boolean isExist(T element) // Проверка наличия элемента в массиве
    {
        return this.find(element) != -1;
    }

    public void bubbleSort(java.util.Comparator<? super T> comparator) // Сортировка пузырьком
    {
        for (int j = 1; j < size; j++)
        {
            Boolean isSorted = true;
            for (int i = 0; i < size - j; i++)
            {
                if (comparator.compare(db[i], db[i + 1]) > 0)
                {
                    T tmp = db[i];
                    db[i] = db[i + 1];
                    db[i + 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }

    public void insertionSort(java.util.Comparator<? super T> comparator)  // Сортировка вставками
    {
        for (int j = 1; j < size; j++)
        {
            T key = db[j];
            int i = j - 1;
            while ((i >= 0 && comparator.compare(db[i], key) > 0))
            {
                db[i + 1] = db[i];
                i--;
            }
            db[i + 1] = key;
        }
    }

    public void selectionSort(java.util.Comparator<? super T> comparator) // Сортировка выбором
    {
        for (int i = 0; i < size - 1; ++i)
        {
            int minPos = i;
            for (int j = i + 1; j < size; ++j)
            {
                if (comparator.compare(db[j], db[minPos]) < 0)
                {
                    minPos = j;
                }
            }
            T tmp = db[minPos];
            db[minPos] = db[i];
            db[i] = tmp;
        }
    }

    public T get(int index) // Получение элемента по индеку
    {
        if (index > 0 && index < size) return db[index];
        else return null;
    }

    public T replace(T element, int index) // Замена элемента(Новый элемент, Индекс)
    {
        if (index > 0 && index < size)
        {
            T oldElement = db[index];
            db[index] = element;
            return oldElement; // Старое значение элемента
        }
        else return null;
    }

    public void printArray() // Печать массива на экран
    {
        System.out.println(db);
    }


    public int size() // Получение размера массива
    {
        return this.size;
    }

    @Override
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0; i < size; i++)
        {
            str.append(db[i].toString());
            if (i != size - 1) str.append(", ");
        }
        str.append("]");
        return str.toString();
    }
}
