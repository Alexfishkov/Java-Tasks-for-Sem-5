// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;


public class Task_5_1 {
    public static void main(String args[]) {
        System.out.print("\033[H\033[J");
        System.out.println("Реализуем структуру телефонной книги, где один человек может иметь несколько номеров");

        // Блок ввода исходных данных:
        ArrayList<Integer> ivanovTels = new ArrayList<Integer>();
        ivanovTels.add(5212);
        ivanovTels.add(4814);
        ArrayList<Integer> sidorovTels = new ArrayList<Integer>();
        sidorovTels.add(1513);
        sidorovTels.add(2211);
        ArrayList<Integer> kozlovTels = new ArrayList<Integer>();
        kozlovTels.add(1212);
        Map<String, ArrayList<Integer>> telGuide = new HashMap<>();
        telGuide.put("Ivanov", ivanovTels);
        telGuide.put("Sidorov", sidorovTels);
        telGuide.put("Kozlov", kozlovTels);

        System.out.println("Изначально наш справочник выглядит так:");
        printtelGuide(telGuide);

        System.out.println(
                "Выберете, что вы хотите сделать:\nВывести телефоны абонента по его фамилии - 1,\nдобавить абонента и номер - 2,\nудалить абонента по фамилии - 3");
        String answer = System.console().readLine("=>");

        switch (answer) {
            case "1":
                showTels(telGuide);
                break;
            case "2":
                ArrayList<Integer> newAbonent = new ArrayList<Integer>();
                addAbonent(telGuide, newAbonent);
                System.out.println("Теперь справочник выглядит так:");
                printtelGuide(telGuide);
                break;
            case "3":
                delAbonent(telGuide);
                System.out.println("Теперь справочник выглядит так:");
                printtelGuide(telGuide);
                break;
            default:
                System.out.println("Некорректный выбор операции!");

        }
    }

    public static void printtelGuide(Map guide) {
        for (var item : guide.keySet()) {
            System.out.printf("%s : %s\n", item, guide.get(item));
        }
    }

    public static void addAbonent(Map guide, ArrayList abonent) {
        String surname = System.console().readLine("Введите фамилию абонента=>");
        System.out.println("Укажите его телефонный номер=> ");
        Scanner iScanner = new Scanner(System.in);
        int tel = iScanner.nextInt();
        iScanner.close();
        abonent.add(tel);
        guide.put(surname, abonent);
    }

    public static void delAbonent(Map guide) {
        String surname = System.console().readLine("Укажите фамилию абонента, которого надо удалить=>");
        guide.remove(surname);
    }

    public static void showTels(Map guide) {
        String surname = System.console().readLine("Укажите фамилию абонента, телефоны которого вы хотите вывести=>");
        System.out.println("Телефоны абонента " + surname + ":" + guide.get(surname));
    }


}