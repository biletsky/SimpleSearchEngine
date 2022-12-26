package stage6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class People {
    private final ArrayList<String> peopleList = new ArrayList<>();

    public ArrayList<String> getPeopleList() {
        return peopleList;
    }

    public void addPeopleFromFile(String args) throws IOException {
        File file = new File(Objects.requireNonNullElse(args, "src/main/resources/data.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String person;
        while ((person = bufferedReader.readLine()) != null) {
            peopleList.add(person);
        }
        bufferedReader.close();
    }

    public Map<String, ArrayList<Integer>> mapWords() {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        int i = 0;
        for (String person : getPeopleList()) {
            String[] words = person.split(" ");
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
}
