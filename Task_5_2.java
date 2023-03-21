// Пусть дан список сотрудников: Иван Иванов Светлана Петрова Кристина Белова Анна Мусина Анна Крутова Иван Юрин Петр Лыков Павел Чернов Петр Чернышов Мария Федорова
// Марина Светлова Мария Савина Мария Рыкова Марина Лугова Анна Владимирова Иван Мечников Петр Петин Иван Ежов 
// Написать программу, которая найдёт и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Task_5_2 {
    public static void main(String args[]) {
        System.out.print("\033[H\033[J");
        System.out.println(
                "Анализируем исходный список и выводим повторяющиеся имена в порядке убывания по частоте их присутствия в списке");
        Map<String, String> ourList = new HashMap<String, String>();
        List<String> names = new ArrayList<>();
        ourList.put("Иванов", "Иван");
        ourList.put("Петрова", "Светлана");
        ourList.put("Белова", "Кристина");
        ourList.put("Мусина", "Анна");
        ourList.put("Крутова", "Анна");
        ourList.put("Юрин", "Иван");
        ourList.put("Лыков", "Петр");
        ourList.put("Чернов", "Павел");
        ourList.put("Чернышов", "Петр");
        ourList.put("Федорова", "Мария");
        ourList.put("Светлова", "Марина");
        ourList.put("Савина", "Мария");
        ourList.put("Рыкова", "Мария");
        ourList.put("Лугова", "Марина");
        ourList.put("Владимирова", "Анна");
        ourList.put("Мечников", "Иван");
        ourList.put("Петин", "Петр");
        ourList.put("Ежов ", "Иван");

        // Записыаем имена в arrayList
        for (String fio : ourList.keySet()) {
            names.add(ourList.get(fio));
        }
        
        // Формируем Set из уникальных имён
        Set<String> set = new HashSet<>(names);
        
        // Формируем TreeMap для сортировки повторений
        TreeMap <Integer,String> result = new TreeMap<>();
        
        // Выводим имена и кол-во их повторений:
        for (String item : set) {
            System.out.println(item + " " + Collections.frequency(names, item));
            result.put(Collections.frequency(names, item),item);
        }

        // Сортируем имена по убыванию популярности:
        System.out.println(result.descendingMap());
    }

    
}
