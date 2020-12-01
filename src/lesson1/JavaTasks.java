package lesson1;

import com.sun.jdi.DoubleValue;
import kotlin.NotImplementedError;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("unused")
public class JavaTasks {
    /**
     * Сортировка времён
     * <p>
     * Простая
     * (Модифицированная задача с сайта acmp.ru)
     * <p>
     * Во входном файле с именем inputName содержатся моменты времени в формате ЧЧ:ММ:СС AM/PM,
     * каждый на отдельной строке. См. статью википедии "12-часовой формат времени".
     * <p>
     * Пример:
     * <p>
     * 01:15:19 PM
     * 07:26:57 AM
     * 10:00:03 AM
     * 07:56:14 PM
     * 01:15:19 PM
     * 12:40:31 AM
     * <p>
     * Отсортировать моменты времени по возрастанию и вывести их в выходной файл с именем outputName,
     * сохраняя формат ЧЧ:ММ:СС AM/PM. Одинаковые моменты времени выводить друг за другом. Пример:
     * <p>
     * 12:40:31 AM
     * 07:26:57 AM
     * 10:00:03 AM
     * 01:15:19 PM
     * 01:15:19 PM
     * 07:56:14 PM
     * <p>
     * В случае обнаружения неверного формата файла бросить любое исключение.
     */
    static public void sortTimes(String inputName, String outputName) {
        throw new NotImplementedError();
    }

    /**
     * Сортировка адресов
     * <p>
     * Средняя
     * <p>
     * Во входном файле с именем inputName содержатся фамилии и имена жителей города с указанием улицы и номера дома,
     * где они прописаны. Пример:
     * <p>
     * Петров Иван - Железнодорожная 3
     * Сидоров Петр - Садовая 5
     * Иванов Алексей - Железнодорожная 7
     * Сидорова Мария - Садовая 5
     * Иванов Михаил - Железнодорожная 7
     * <p>
     * Людей в городе может быть до миллиона.
     * <p>
     * Вывести записи в выходной файл outputName,
     * упорядоченными по названию улицы (по алфавиту) и номеру дома (по возрастанию).
     * Людей, живущих в одном доме, выводить через запятую по алфавиту (вначале по фамилии, потом по имени). Пример:
     * <p>
     * Железнодорожная 3 - Петров Иван
     * Железнодорожная 7 - Иванов Алексей, Иванов Михаил
     * Садовая 5 - Сидоров Петр, Сидорова Мария
     * <p>
     * В случае обнаружения неверного формата файла бросить любое исключение.
     */


    static public void sortAddresses(String inputName, String outputName) {
        throw new NotImplementedError();
    }

    /**
     * Сортировка температур
     * <p>
     * Средняя
     * (Модифицированная задача с сайта acmp.ru)
     * <p>
     * Во входном файле заданы температуры различных участков абстрактной планеты с точностью до десятых градуса.
     * Температуры могут изменяться в диапазоне от -273.0 до +500.0.
     * Например:
     * <p>
     * 24.7
     * -12.6
     * 121.3
     * -98.4
     * 99.5
     * -12.6
     * 11.0
     * <p>
     * Количество строк в файле может достигать ста миллионов.
     * Вывести строки в выходной файл, отсортировав их по возрастанию температуры.
     * Повторяющиеся строки сохранить. Например:
     * <p>
     * -98.4
     * -12.6
     * -12.6
     * 11.0
     * 24.7
     * 99.5
     * 121.3
     */
    // время O(n)
    // память O(n)
    static public void sortTemperatures(String inputName, String outputName) throws IOException {
        try (FileReader fileReader = new FileReader(inputName)) {
            try (FileWriter fileWriter = new FileWriter(outputName)) {
                try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                        String line;
                        int[] listOfTemp = new int[(273 + 500) * 10 + 1];
                        int temp;

                        while ((line = bufferedReader.readLine()) != null) {
                            temp = (int) Math.round((Double.parseDouble(line) + 273) * 10);
                            listOfTemp[temp]++;
                        }

                        for (int i = 0; i < listOfTemp.length; i++)
                            if (listOfTemp[i] != 0)
                                for (int j = 0; j < listOfTemp[i]; j++) {
                                    String text = String.valueOf((double) Math.round((((double) i / 10) - 273) * 10) / 10);
                                    if (text.equals("-0.0"))
                                        text = "0.0";
                                    bufferedWriter.write(text);
                                    bufferedWriter.newLine();
                                }
                    }
                }
            }
        }
    }

    /**
     * Сортировка последовательности
     * <p>
     * Средняя
     * (Задача взята с сайта acmp.ru)
     * <p>
     * В файле задана последовательность из n целых положительных чисел, каждое в своей строке, например:
     * <p>
     * 1
     * 2
     * 3
     * 2
     * 3
     * 1
     * 2
     * <p>
     * Необходимо найти число, которое встречается в этой последовательности наибольшее количество раз,
     * а если таких чисел несколько, то найти минимальное из них,
     * и после этого переместить все такие числа в конец заданной последовательности.
     * Порядок расположения остальных чисел должен остаться без изменения.
     * <p>
     * 1
     * 3
     * 3
     * 1
     * 2
     * 2
     * 2
     */
    //время O(n)
    // память O(n)
    static public void sortSequence(String inputName, String outputName) throws IOException {
        try (FileReader fileReader = new FileReader(inputName)) {
            try (FileWriter fileWriter = new FileWriter(outputName)) {
                try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                    try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

                        String line;
                        int minimum = Integer.MAX_VALUE;
                        int count = -1;
                        HashMap<Integer, Integer> result = new HashMap<>();
                        ArrayList<Integer> res = new ArrayList<>();
                        while ((line = bufferedReader.readLine()) != null) {
                            int num = Integer.parseInt(line);
                            res.add(num);

                            result.put(num, result.getOrDefault(num, 0) + 1);
                            int c = result.get(num);

                            if (count == c)
                                if (minimum > num)
                                    minimum = num;

                            if (count < c) {
                                count = c;
                                minimum = num;
                            }
                        }

                        for (Integer re : res)
                            if (re != minimum) {
                                bufferedWriter.write(String.valueOf(re));
                                bufferedWriter.newLine();
                            }

                        while (count != 0) {
                            bufferedWriter.write(String.valueOf(minimum));
                            bufferedWriter.newLine();
                            count--;
                        }
                    }
                }
            }
        }
    }

    /**
     * Соединить два отсортированных массива в один
     * <p>
     * Простая
     * <p>
     * Задан отсортированный массив first и второй массив second,
     * первые first.size ячеек которого содержат null, а остальные ячейки также отсортированы.
     * Соединить оба массива в массиве second так, чтобы он оказался отсортирован. Пример:
     * <p>
     * first = [4 9 15 20 28]
     * second = [null null null null null 1 3 9 13 18 23]
     * <p>
     * Результат: second = [1 3 4 9 9 13 15 20 23 28]
     */
    static <T extends Comparable<T>> void mergeArrays(T[] first, T[] second) {
        throw new NotImplementedError();
    }
}
