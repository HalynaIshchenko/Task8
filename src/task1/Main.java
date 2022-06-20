package task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    Дана колекція стрічок : “One”, “Two”, “Three”, “Four”, “Five”, “One”.
    Повернути кількість входжень об'єкта «One»
    Повернути перший елемент колекції або 0, якщо колекція порожня
    Повернути останній елемент колекції або «empty», якщо колекція порожня
    Знайти елемент в колекції рівний «Three» або кинути помилку
    Повернути третій елемент колекції по порядку
    Повернути два елементи починаючи з другого
    Вибрати всі елементи в яких є більше ніж 3 букви у слові
    Повернути колекції без дублікатів
    Знайти чи існують хоч один «One» елемент в колекції
    Знайти чи є символ «o» у всіх елементів колекції
    Додати "_1" до кожного елементу колекції
    Відсортувати колекцію рядків за алфавітом і прибрати дублікати
 */

public class Main {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five", "One");
        //Повернути кількість входжень об'єкта «One»
        System.out.printf("Повернути кількість входжень об'єкта «One» : %s\n",
                list.stream().filter(s -> s.equalsIgnoreCase("One")).count());

        //Повернути перший елемент колекції або 0, якщо колекція порожня
        System.out.printf("Повернути перший елемент колекції або 0, якщо колекція порожня: %s\n",
                list.stream().findFirst().orElse("0"));
        List<String> emptyList = new ArrayList<>();
        System.out.printf("Повернути перший елемент колекції або 0, якщо колекція порожня: %s\n",
                emptyList.stream().findFirst().orElse("0"));

        //  СОРТОВАНО: Повернути останній елемент колекції або «emptyList», якщо колекція порожня
        System.out.printf("СОРТОВАНО: Повернути останній елемент колекції або «emptyList», якщо колекція порожня: %s\n",
                list.stream().max(String::compareTo).orElse("emptyList"));

        //  СОРТОВАНО: Повернути останній елемент колекції або «emptyList», якщо колекція порожня
        System.out.printf("СОРТОВАНО: Повернути останній елемент колекції або «emptyList», якщо колекція порожня: %s\n",
                emptyList.stream().max(String::compareTo).orElse("emptyList"));

        // НЕ СОРТОВАНО: Повернути останній елемент колекції або «emptyList», якщо колекція порожня
        System.out.printf("НЕ СОРТОВАНО: Повернути останній елемент колекції або «emptyList», якщо колекція порожня: %s\n",
                list.stream().reduce((first, second) -> second).orElse("emptyList"));

        // НЕ СОРТОВАНО: Повернути останній елемент колекції або «emptyList», якщо колекція порожня
        System.out.printf("НЕ СОРТОВАНО: Повернути останній елемент колекції або «emptyList», якщо колекція порожня: %s\n",
                emptyList.stream().reduce((first, second) -> second).orElse("emptyList"));

        System.out.printf("Знайти елемент в колекції рівний «Three» або кинути помилку: %s\n",
                list.stream().filter(s -> s.equals("Three")).findFirst().orElseThrow(
                        () -> new RuntimeException("element not found")));

        // Way1 Повернути третій елемент колекції по порядку
        System.out.printf("1 Повернути третій елемент колекції по порядку: %s\n",
                list.stream().collect(Collectors.toList()).get(2));
        // Way2 Повернути третій елемент колекції по порядку
        System.out.printf("2 Повернути третій елемент колекції по порядку: %s\n",
                list.stream().skip(2).limit(3).findFirst().get());

        // Повернути два елементи починаючи з другого
        System.out.printf("Повернути два елементи починаючи з другого: %s\n",
                list.stream().skip(1).limit(2).collect(Collectors.toList()));

        // Вибрати всі елементи в яких є більше ніж 3 букви у слові
        System.out.printf("Вибрати всі елементи в яких є більше ніж 3 букви у слові: %s\n",
                list.stream().filter(s -> s.length()>3).collect(Collectors.toList()));

        // Повернути колекції без дублікатів
        System.out.printf("Повернути колекції без дублікатів: %s\n",
                list.stream().distinct().collect(Collectors.toList()));

        // Знайти чи існують хоч один «One» елемент в колекції
        System.out.printf("Знайти чи існують хоч один «One» елемент в колекції: %s\n",
                list.stream().anyMatch(s -> s.equals("One")));

        //Знайти чи є символ «o» у всіх елементів колекції
        System.out.printf("Знайти чи є символ «o» у всіх елементів колекції: %s\n",
                list.stream().allMatch(s -> s.contains("One")));

        // Додати "_1" до кожного елементу колекції
        System.out.printf("Додати '_1' до кожного елементу колекції: %s\n",
                list.stream().map(s -> s + "_1").collect(Collectors.toList()));

        // Відсортувати колекцію рядків за алфавітом і прибрати дублікати
        System.out.printf("Відсортувати колекцію рядків за алфавітом і прибрати дублікати: %s\n",
                list.stream().distinct().sorted(String::compareTo).collect(Collectors.toList()));

    }

}
