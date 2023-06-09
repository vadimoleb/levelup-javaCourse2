package org.levelup.bank.system.menu;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//класс ответственен за взаимодействие с консолью
public class ConsoleMenu {
    private static final BufferedReader CONSOLE_READER = new BufferedReader(new InputStreamReader(System.in));

    //приватный конструктор. чтобы нельзя было создать объекты. в нашем случае потому, что все поля статичные.
    private ConsoleMenu() {
    }

    public static void printGeneralMenu() {
        System.out.println("--------------");
        System.out.println("1. Показать все счета пользователя");
        System.out.println("2. Открыть новый счет");
        System.out.println("3. Изменить номер счета");
        System.out.println("4. Удалить счет");
        System.out.println("5. Вывести список пользователей");
        System.out.println("6. Редактировать пользователя");
        System.out.println("7. Посмотреть информацию о пользователе");

        System.out.println("0. Выход");

        System.out.println();
    }

    public static Long readLong(String message) {
        System.out.println(message);

        try {
            return Long.parseLong(CONSOLE_READER.readLine());
        } catch (Exception exc) {
            return null;
        }
    }

    public static Integer readInteger(String message) {
        System.out.println(message);

        try {
            return Integer.parseInt(CONSOLE_READER.readLine());
        } catch (Exception exc) {
            return null;
        }
    }

    public static String readString(String message){
        System.out.println(message);
        try {
            return CONSOLE_READER.readLine();
        } catch (Exception exc) {
            return null;
        }
    }
}
