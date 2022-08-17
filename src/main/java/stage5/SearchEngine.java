package stage5;

import java.io.IOException;
import java.util.*;

public class SearchEngine {
    Scanner scanner = new Scanner(System.in);
    People people = new People();

    private void printPeople() {
        for (var person : people.getPeopleList()) {
            System.out.println(person);
        }
    }

    private void findPerson() {
        System.out.println("\nEnter a name or email to search all suitable people.");
        String key = scanner.nextLine();
        if (people.mapWords().containsKey(key.toUpperCase())) {
            System.out.println(people.mapWords().get(key.toUpperCase()).size() + " persons found:");
            for (Integer i : people.mapWords().get(key.toUpperCase())) {
                System.out.println(people.getPeopleList().get(i));
            }
        }
        else {
            System.out.println("No matching people found.");
        }
    }

    private void menuOption() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    private void menu() {
        menuOption();
        int option = 6;
        while (option != 0) {
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            switch (option) {
                case 1: {
                    findPerson();
                    menuOption();
                    break;
                }
                case 2: {
                    printPeople();
                    menuOption();
                    break;
                }
                case 0: {
                    System.out.println("Bye!");
                    break;
                }
                default: {
                    System.out.println("Incorrect option! Try again.");
                    menuOption();
                    break;
                }
            }
        }
    }

    protected void search(String args) throws IOException {
        people.addPeopleFromFile(args);
        menu();
    }
}
