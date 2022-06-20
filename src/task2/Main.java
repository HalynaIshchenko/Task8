package task2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /*
    Дана колекція клас People (з полями name - ім'я, age - вік, sex - стать)
    Вибрати чоловіків-військовозобов'язаних (від 18 до 27 років)
    Знайти середній вік серед чоловіків
    Знайти кількість потенційно працездатних людей у вибірці (тобто від 18 років і з огляду на що жінки виходять в 55 років, а чоловік в 60)
    Відсортувати колекцію людей за ім'ям в зворотному алфавітному порядку
    Відсортувати колекцію людей спочатку за ім’ям, а потім за віком
    Знайти найстаршу людину
    Знайти наймолодшу людину
    Вивести скільки є чоловіків
    Вивести скільки є жінок
    Вивеcти всіх жінок в яких ім’я починається на “A”
    */

    public static void main(String[] args) {
        List<People> peopleList = Arrays.asList(
                new People("Roman Savkiv", 17, Sex.Male),
                new People("Ivan Savkiv", 18, Sex.Male),
                new People("Andriy Mykulenec", 27, Sex.Male),
                new People("Dmytro Mykulenec", 28, Sex.Male),
                new People("Zakhar Mykulenec", 55, Sex.Male), // to see that comparator by name then age works properly
                new People("Zakhar Mykulenec", 56, Sex.Male), // to see that comparator by name then age works properly
                new People("Zakhar Mykulenec", 57, Sex.Male), // to see that comparator by name then age works properly
                new People("Vita Rak", 70, Sex.Female),
                new People("Anna Rak", 22, Sex.Female)
        );

        // Вибрати чоловіків-військовозобов'язаних (від 18 до 27 років)
        System.out.printf("Вибрати чоловіків-військовозобов'язаних (від 18 до 27 років): %s\n",
                peopleList.stream().filter(p ->
                        p.getAge() >= 18
                                && p.getAge() < 27
                                && p.getSex().equals(Sex.Male)
                ).collect(Collectors.toList()));

        // Знайти середній вік серед чоловіків
        System.out.printf("Знайти середній вік серед чоловіків: %s\n",
                peopleList.stream().filter(people -> people.getSex().equals(Sex.Male)).mapToInt(People::getAge).average().getAsDouble());


        // Знайти кількість потенційно працездатних людей у вибірці (тобто від 18 років і з огляду на що жінки виходять в 55 років, а чоловік в 60)
        System.out.printf(
                "Знайти кількість потенційно працездатних людей у вибірці (тобто від 18 років і з огляду на що жінки виходять в 55 років, а чоловік в 60): %s\n"
                , peopleList.stream().filter(people ->
                        people.getAge() >= 18
                                && ((people.getSex().equals(Sex.Male) && people.getAge() < 55) || (people.getSex().equals(Sex.Female) && people.getAge() < 55)
                        )).collect(Collectors.toList()));

        // Відсортувати колекцію людей за ім'ям в зворотному алфавітному порядку
        System.out.printf(
                "Відсортувати колекцію людей за ім'ям в зворотному алфавітному порядку: %s\n"
                , peopleList.stream().map(People::getName).sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        Comparator<People> customPeopleComparatorByNameThenAge =
                Comparator.comparing(People::getName, Comparator.reverseOrder())
                        .thenComparingInt(People::getAge);
        System.out.printf("Відсортувати колекцію людей спочатку за ім’ям, а потім за віком: %s\n"
                , peopleList.stream().sorted(customPeopleComparatorByNameThenAge).collect(Collectors.toList()));

        Comparator<People> customPeopleComparatorByAge =
                Comparator.comparingInt(People::getAge);

        System.out.printf("Знайти найстаршу людину: %s\n"
                , peopleList.stream().max(customPeopleComparatorByAge).get());

        System.out.printf("Вивести скільки є чоловіків: %s\n"
                , peopleList.stream().filter(p -> p.getSex().equals(Sex.Male)).count());

        System.out.printf("Вивести скільки є жінок: %s\n"
                , peopleList.stream().filter(p -> p.getSex().equals(Sex.Female)).count());

        System.out.printf("Вивеcти всіх жінок в яких ім’я починається на “A”: %s\n"
                , peopleList.stream().filter(p -> p.getSex().equals(Sex.Female))
                        .filter(p -> p.getName().startsWith("A"))
                        .collect(Collectors.toList()));

    }


}
