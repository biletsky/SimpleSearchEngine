package stage6;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
            case NONE: {
                selectionContext.setAlgorithm(new SelectNonePeople());
                break;
            }
            case ALL: {
                selectionContext.setAlgorithm(new SelectAllPeople());
                break;
            }
            case ANY: {
                selectionContext.setAlgorithm(new SelectAnyPeople());
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown algorithm type ");
            }
        }
        selectionContext.printPeople(selectionContext.selectPeople(mapWords(), query, people));
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
            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please choose option: 1, 2, 0");
            }
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

    Map<String, ArrayList<Integer>> mapWords() {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        int i = 0;
        for (String person : people.getPeopleList()) {
            String[] words = person.split(" +");
            for (String word : words) {
                word = word.toUpperCase();
                if (map.containsKey(word)) {
                    map.get(word).add(i);
                    map.put(word, map.get(word));
                } else {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(i);
                    map.put(word, arrayList);
                }
            }
            i++;
        }
        return map;
    }

    protected void search(String args) throws IOException {
        people.addPeopleFromFile(args);
        menu();
    }
}
