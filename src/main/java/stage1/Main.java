package stage1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String key = scanner.nextLine();
        String[] array = line.split(" ");
        int i = 0;
        int number = 0;
        for (String s : array) {
            i++;
            if(s.equals(key)){
                number = i;
            }
        }
        if (number > 0) {
            System.out.println(number);
        }
        else {
            System.out.println("Not found");
        }
    }
}
