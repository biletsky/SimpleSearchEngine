package stage2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of people:");
        List<String> list = new ArrayList<>();
        int numberOfPeople = scanner.nextInt();
        System.out.println("Enter all people:");
        while (numberOfPeople != list.size() - 1) {
            list.add(scanner.nextLine());
        }
        System.out.println("Enter the number of search queries:");
        int searchCount = scanner.nextInt();
        int count = 0;
        List<String> changedList = new ArrayList<>();
        while (searchCount != count) {
            changedList.clear();
            System.out.println("Enter data to search people:");
            String key = scanner.next();
            for (String text : list) {
                if(Pattern.compile(Pattern.quote(key), Pattern.CASE_INSENSITIVE).matcher(text).find()){
                    changedList.add(text);
                }
            }
            count++;
            if (!changedList.isEmpty()) {
                System.out.println("Found people:");
                for (String value : changedList) {
                    System.out.println(value);
                }
            } else {
                System.out.println("No matching people found.");
            }
        }
    }
}