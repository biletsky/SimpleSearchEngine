package stage6;

import stage6.command.SelectionContext;
import stage6.command.commands.SelectAllPeople;
import stage6.command.commands.SelectAnyPeople;
import stage6.command.commands.SelectNonePeople;

import java.io.IOException;
import java.util.Scanner;

public class SearchEngine {
    Scanner scanner = new Scanner(System.in);
    People people = new People();
    SelectionContext selectionContext = new SelectionContext();

    private void printPeople() {
        for (var person : people.getPeopleList()) {
            System.out.println(person);
        }
    }

    private void findPerson() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String type = scanner.nextLine();
        System.out.println("Enter a name or email to search all suitable people.");
        String query = scanner.nextLine();
        switch (SearchType.valueOf(type)) {
            case NONE -> selectionContext.setAlgorithm(new SelectNonePeople());
            case ALL -> selectionContext.setAlgorithm(new SelectAllPeople());
            case ANY -> selectionContext.setAlgorithm(new SelectAnyPeople());
            default -> throw new IllegalArgumentException("Unknown algorithm type ");
        }
        selectionContext.printPeople(selectionContext.selectPeople(query, people));
    }

    private void menuOption() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    private void menu() {
        int option = 6;
        while (option != 0) {
            Scanner scanner = new Scanner(System.in);
            try {
                menuOption();
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> findPerson();
                    case 2 -> printPeople();
                    case 0 -> System.out.println("Bye!");
                    default -> System.out.println("Incorrect option! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Please choose option: 1, 2, 0");
            }
        }
    }

    public void search(String args) throws IOException {
        people.addPeopleFromFile(args);
        menu();
    }
}
