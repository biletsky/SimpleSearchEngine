package stage4;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SearchEngine {
    Scanner scanner = new Scanner(System.in);
    People people = new People();

    private void printPeople() {
        for (String people : people.getPeople()) {
            System.out.println(people);
        }
    }

    private void findPerson() {
        System.out.println("Enter a name or email to search all suitable people.");
        String key = scanner.nextLine();
        for (String people : people.getPeople()) {
            if (Pattern.compile(Pattern.quote(key), Pattern.CASE_INSENSITIVE).matcher(people).find()) {
                System.out.println(people);
            }
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
                case 1 -> {
                    findPerson();
                    menuOption();
                }
                case 2 -> {
                    printPeople();
                    menuOption();
                }
                case 0 -> System.out.println("Bye!");
                default -> {
                    System.out.println("Incorrect option! Try again.");
                    menuOption();
                }
            }
        }
    }

    protected void search(String args) throws IOException {
        people.addPeopleFromFile(args);
        menu();
    }
}
