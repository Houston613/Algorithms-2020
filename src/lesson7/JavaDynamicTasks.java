package lesson7;

import kotlin.NotImplementedError;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class JavaDynamicTasks {
    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     * <p>
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */

    //трудоемкость - O(n), где n - произведение длин строк
    //ресурсы - O(n), где n - произведение длин строк
    public static String longestCommonSubSequence(String first, String second) {
        int firstLength = first.length();
        int secondLength = second.length();
        int[][] matrix = new int[firstLength + 1][secondLength + 1];
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < second.length(); j++) {
                if (first.charAt(i) == second.charAt(j))
                    matrix[i + 1][j + 1] = matrix[i][j] + 1;
                else
                    matrix[i + 1][j + 1] = Math.max(matrix[i][j + 1], matrix[i + 1][j]);
            }
        }

        while (firstLength > 0 && secondLength > 0) {
            if (first.charAt(firstLength - 1) == second.charAt(secondLength - 1)) {
                stringBuilder.append(first.charAt(firstLength - 1));
                firstLength--;
                secondLength--;
            } else if (matrix[firstLength - 1][secondLength] > matrix[firstLength][secondLength - 1])
                firstLength--;
            else
                secondLength--;
        }
        return stringBuilder.reverse().toString();
    }

    /**
     * Наибольшая возрастающая подпоследовательность
     * Сложная
     * <p>
     * Дан список целых чисел, например, [2 8 5 9 12 6].
     * Найти в нём самую длинную возрастающую подпоследовательность.
     * Элементы подпоследовательности не обязаны идти подряд,
     * но должны быть расположены в исходном списке в том же порядке.
     * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
     * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
     * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
     */
    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {

        if (list.size() <= 1)
            return list;

        int[] indexes = new int[list.size()];
        int[] listOfLength = new int[list.size()];

        List<Integer> result = new ArrayList<>();
        int maxlength = 0;
        int maxIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            indexes[i] = -1;
            listOfLength[i] = 1;

            for (int j = 0; j < list.size(); j++)
                if (list.get(i) > list.get(j) && listOfLength[i] - 1 < listOfLength[j]) {
                    listOfLength[i] = listOfLength[j] + 1;
                    indexes[i] = j;
                }
        }
        for (int i = 0; i < listOfLength.length; i++)
            if (listOfLength[i] > maxlength) {
                maxIndex = i;
                maxlength = listOfLength[i];
            }
        while (maxIndex > -1) {
            result.add(0,list.get(maxIndex));
            maxIndex = indexes[maxIndex];
        }
        return result;
    }

    /**
     * Самый короткий маршрут на прямоугольном поле.
     * Средняя
     * <p>
     * В файле с именем inputName задано прямоугольное поле:
     * <p>
     * 0 2 3 2 4 1
     * 1 5 3 4 6 2
     * 2 6 2 5 1 3
     * 1 4 3 2 6 2
     * 4 2 3 1 5 0
     * <p>
     * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
     * В каждой клетке записано некоторое натуральное число или нуль.
     * Необходимо попасть из верхней левой клетки в правую нижнюю.
     * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
     * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
     * <p>
     * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
     */
    public static int shortestPathOnField(String inputName) {
        throw new NotImplementedError();
    }

    // Задачу "Максимальное независимое множество вершин в графе без циклов"
    // смотрите в уроке 5
}
