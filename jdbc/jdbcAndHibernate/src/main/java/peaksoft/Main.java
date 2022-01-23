package peaksoft;

import peaksoft.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {









        
        UserServiceImpl service = new UserServiceImpl();
        service.createUsersTable();
        service.saveUser("Askar", "Akaev", (byte) 70);
        System.out.println(service.getAllUsers() + "\n жаны user кошулду");
        service.saveUser("Kurmanbek", "Bakiev", (byte) 72);
        System.out.println(service.getAllUsers() + "\n жаны user кошулду");
        service.saveUser("Roza", "Otunbaeva", (byte) 67);
        System.out.println(service.getAllUsers() + "\n жаны user кошулду");
        service.saveUser("Almazbek", "Atambaev", (byte) 75);
        System.out.println(service.getAllUsers() + "\n жаны user кошулду");
        service.saveUser("Sooronbai", "Jeenbekov", (byte) 67);
        System.out.println(service.getAllUsers() + "\n жаны user кошулду");
        service.saveUser("Sadyr", "Japarov", (byte) 59);
        System.out.println(service.getAllUsers() + "\n жаны user кошулду");
        service.removeUserById(1);
        System.out.println(service.getAllUsers() + "биринчи user алындый");
        service.cleanUsersTable();
        System.out.println(service.getAllUsers() + "Тазаландый");
        service.dropUsersTable();
        System.out.println(service.getAllUsers() + "Таблица болду жок");


    }
}
