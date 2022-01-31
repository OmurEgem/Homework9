package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        UserService service = new UserServiceImpl();

        while (true) {
            serviceSelection(service);
        }
    }

    private static void serviceSelection(UserService service) throws Exception {
        choiceString();
        int a = scanner.nextInt();

        switch (a) {
            case 1: {
                service.createUsersTable();
                break;
            }
            case 2: {
                service.dropUsersTable();
                break;
            }
            case 3: {
                addUser(service);
                break;
            }
            case 4: {
                System.out.println(service.getAllUsers());
                break;
            }
            case 5: {
                System.out.println(" id номерин тандагыла :");
                int b = scanner.nextInt();
                service.removeUserById(b);
                break;
            }
            case 6: {
                service.cleanUsersTable();
                break;
            }
            case 7: {
                System.exit(0);
                break;
            }
            default: {
                throw new Exception("1ден-9ка ичинен танда");
            }
        }
    }

    private static void addUser(UserService service) {
        service.saveUser("Askar", "Akaev", (byte) 70);
        service.saveUser("Kurmanbek", "Bakiev", (byte) 72);
        service.saveUser("Roza", "Otunbaeva", (byte) 67);
        service.saveUser("Almazbek", "Atambaev", (byte) 75);
        service.saveUser("Sooronbai", "Jeenbekov", (byte) 67);
        service.saveUser("Sadyr", "Japarov", (byte) 59);

    }


    public static void choiceString() {
        System.out.println(
                "1 - Таблица курулат\n" +
                        "2 - Таблица жок кылуу\n" +
                        "3 - Юзерди кошуу\n" +
                        "4 - Баарын чыгаруу\n" +
                        "5 - id си менен Очуруу\n" +
                        "6 - Таблицаны тазалоо \n" +
                        "7 - Программадан чыгуу");
    }


}

