package User_Interface;

import Domain.Entity;
import Domain.Entity1;
import Domain.Entity2;
import Service.ServiceEntity1;
import Service.ServiceEntity2;

import java.util.Scanner;

public class ConsoleInterface {

    private static ServiceEntity1 serviceEntity1;
    private static ServiceEntity2 serviceEntity2;


    Scanner input = new Scanner(System.in);

    public ConsoleInterface(ServiceEntity1 serviceEntity1, ServiceEntity2 serviceEntity2) {
        this.serviceEntity1 = serviceEntity1;
        this.serviceEntity2 = serviceEntity2;
    }

    private void printMenu() {
        System.out.print("""
                1. Add entity
                2. Delete entity
                3. Update entity
                4. Show all entities
                5. Add entity
                6. Delete entity
                7. Update entity
                8. Show all entities
                0. Exit
                """);
    }

    private void addEntity1() {
        Integer id;
        String name;
        String value;
        System.out.println("Enter data of entity you wish to add: ");
        id = input.nextInt();
        input.nextLine();
        name = input.nextLine();
        value = input.nextLine();
        serviceEntity1.add(new Entity1(id, name,value));
    }

    private void deleteEntity1() {
        Integer id;
        System.out.println("Enter id of entity you wish to delete: ");
        id = input.nextInt();
        serviceEntity1.delete(id);
    }

    private void updateEntity1() {
        Integer id;
        String name;
        String value;
        System.out.println("Enter id of entity you wish to update: ");
        id = input.nextInt();

        Integer newData;
        newData=input.nextInt();
        input.nextLine();
        name = input.nextLine();
        value = input.nextLine();

        serviceEntity1.update(id, new Entity1(newData, name, value));
    }

    private void showAllEntities() {
        for (Entity entity : serviceEntity1.getAll()) {
            System.out.println(entity.toString() + "\n");
        }
    }

    /////////////////////////////////////////////////////////////////////////////////

    private void addEntity2() {
        Integer id;
        boolean truth;
        int value2;
        System.out.println("Enter data of entity you wish to add: ");
        id = input.nextInt();
        truth = input.nextBoolean();
        value2 = input.nextInt();
        serviceEntity2.add(new Entity2(id, truth, value2));
    }

    private void deleteEntity2() {
        Integer id;
        System.out.println("Enter id of entity you wish to delete: ");
        id = input.nextInt();
        serviceEntity2.delete(id);
    }

    private void updateEntity2() {
        Integer id;
        Boolean truth;
        int value2;
        System.out.println("Enter id of entity you wish to update: ");
        id = input.nextInt();
        Integer newData;
        System.out.println("Enter new data: ");
        newData=input.nextInt();
        truth = input.nextBoolean();
        value2 = input.nextInt();

        serviceEntity2.update(id, new Entity2(newData, truth, value2));
    }

    private void showAllEntities2() {
        for (Entity entity : serviceEntity2.getAll()) {
            System.out.println(entity.toString() + "\n");
        }
    }

    public void run() {
        Integer option;

        while (true) {

            printMenu();

            System.out.println("Choose an option: ");

            option = input.nextInt();

            switch (option) {
                case 1:
                    addEntity1();
                    break;
                case 2:
                    deleteEntity1();
                    break;
                case 3:
                    updateEntity1();
                    break;
                case 4:
                    showAllEntities();
                    break;
                case 5:
                    addEntity2();
                    break;
                case 6:
                    deleteEntity2();
                    break;
                case 7:
                    updateEntity2();
                    break;
                case 8:
                    showAllEntities2();
                    break;

            }
        }
    }
}
